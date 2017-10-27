package domaine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.CommandeDejaEnCoursException;

public class Commande implements Iterable<LigneCommande>, Cloneable {

	private static int numero = 0;
	private int num;
	private LocalDate date;
	private Client client;
	private List<LigneCommande> lignesCommandes;
	
	
	public Commande(Client client) {
		numero++;
		this.num = numero;
		this.date = LocalDate.now();
		this.client = client;
		lignesCommandes = new ArrayList<>();
		try {
			client.ajouterCommandeEnCours(this);
		} catch (CommandeDejaEnCoursException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	public void ajouterPizza(Pizza pizza, int quantite) {
		LigneCommande ligne = new LigneCommande(pizza, quantite);
		if (!lignesCommandes.contains(ligne))
			lignesCommandes.add(ligne);
		else {
			LigneCommande ligneAncienne = lignesCommandes.get(lignesCommandes.indexOf(ligne));
			ligneAncienne.setQuantite(ligneAncienne.getQuantite() + quantite);;
		}
	}
	
	public double calculMontantTotal() {
		double montantTotal = 0;
		for (LigneCommande ligne : lignesCommandes) {
			montantTotal += ligne.getPrixUnitaire() * ligne.getQuantite();
		}
		return montantTotal;
	}
	
	public String detailler() {
		StringBuilder sb = new StringBuilder("\nCommande n° " + num + " du " + date.toString() + " pour le client " + client.getNom() + 
				" " + client.getPrenom() 
				+ ".\nListe des pizzas commandées:");
		sb.append("\n\tTitre\t\tQuantité\tPrix Unitaire\tTotal ligne");
		for (LigneCommande ligne : lignesCommandes) {
			sb.append("\n\t" + ligne.getPizza().getTitre() + "\t" + ligne.getQuantite() + "\t\t" + ligne.getPrixUnitaire() + "\t" + ligne.calculTotalLigne());
		}
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public Iterator<LigneCommande> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande autreCommande = (Commande) obj;
		if (num != autreCommande.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commande [num=" + num + ", date=" + date + ", client=" + client + "]";
	}

	

}
