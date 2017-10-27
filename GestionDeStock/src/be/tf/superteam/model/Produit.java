package be.tf.superteam.model;

public abstract class Produit {

	private int prix;
	
	
	public int getPrix() {
		return prix;
	}

	public abstract void utiliser();
}
