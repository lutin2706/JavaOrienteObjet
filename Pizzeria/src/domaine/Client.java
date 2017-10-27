package domaine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.CommandeDejaEnCoursException;
import exceptions.NoCommandeEnCoursException;

public class Client implements Iterable<Commande> {

	private int numero;
	private String nom;
	private String prenom;
	private String tel;
	
	private Commande commandeEnCours;
	private List<Commande> commandesPassees;
	
	
	public Client(int numero, String nom, String prenom, String tel) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.commandesPassees = new ArrayList<>();
	}


	public int getNumero() {
		return numero;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTel() {
		return tel;
	}
	
	
	public Commande getCommandeEnCours() {
		return commandeEnCours;
	}

	public void ajouterCommandeEnCours(Commande commande) {
		if (commandeEnCours == null) {
			commandeEnCours = commande;
		} else
			throw new CommandeDejaEnCoursException("Il y a déjà une commande en cours pour ce client.");
	}

	public void cloturerCommandeEnCours() throws NoCommandeEnCoursException {
		if (commandeEnCours != null) {
			commandesPassees.add(commandeEnCours);
			commandeEnCours = null;
		} else
			throw new NoCommandeEnCoursException("Aucune commande en cours pour ce client.");
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + "]";
	}

}
