package be.tf.superteam.model;

public class ProduitBricolage extends Produit implements Echangeable, Remboursable {

	@Override
	public void utiliser() {
		System.out.println("Je suis utilis� dans le garage");
	}

}
