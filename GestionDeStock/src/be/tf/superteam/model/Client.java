package be.tf.superteam.model;

import java.util.HashMap;

public class Client {

	HashMap<Produit, Integer> listeProduits;
	int solde;
	
	public Client(int solde) {
		listeProduits = new HashMap<>();
		this.solde = solde;
	}
	public void acheter(Magasin magasin, Produit produit, int qte) {
		int montant = magasin.vendre(produit, qte);
		if (montant <= solde) {
			solde -= montant;
			if (listeProduits.containsKey(produit))
				listeProduits.put(produit, listeProduits.get(produit) + qte);
			else
				listeProduits.put(produit, qte);
		}
		else {
			System.out.println("Pas assez d'argent pour acheter ce produit !!");
			magasin.annulerVente(produit, qte);
		}
	}

	public void utiliser(Produit produit) {
		produit.utiliser();	
	}
}
