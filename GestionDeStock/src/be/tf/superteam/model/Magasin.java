package be.tf.superteam.model;

import java.util.HashMap;

public class Magasin {

	private HashMap<Produit, Integer> stock;
	private int chiffreAffaire;
	
	public Magasin() {
		stock = new HashMap<>();
	}

	public void ajouterStock(Produit produit, int qte) {
		if (stock.containsKey(produit))
			stock.put(produit, stock.get(produit) + qte);
		else
			stock.put(produit, qte);
	}

	public int vendre(Produit produit, int qte) {
		int montant = produit.getPrix() * qte;
		chiffreAffaire += montant;

		if (stock.containsKey(produit) && stock.get(produit) > qte) {
			stock.put(produit, stock.get(produit) - qte);
			montant = produit.getPrix() * qte;
		} else {
			System.out.println("Pas assez de produits en stock !");
			montant = 0;
		}
		return montant;
	}

	public void annulerVente(Produit produit, int qte) {
		// TODO Auto-generated method stub

	}
}
