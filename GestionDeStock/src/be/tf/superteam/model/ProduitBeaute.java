package be.tf.superteam.model;

public class ProduitBeaute extends Produit implements Echangeable {

	@Override
	public void utiliser() {
		System.out.println("Je suis utilisé dans la salle de bain");
	}

}
