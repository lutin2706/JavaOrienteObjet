package be.tf.superteam.model;

public class ProduitInformatique extends Produit implements Remboursable {

	@Override
	public void utiliser() {
		System.out.println("Je suis utilis� dans le bureau");

	}

}
