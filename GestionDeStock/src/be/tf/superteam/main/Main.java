package be.tf.superteam.main;

import be.tf.superteam.model.Client;
import be.tf.superteam.model.Magasin;
import be.tf.superteam.model.Produit;
import be.tf.superteam.model.ProduitBeaute;

public class Main {

	public static void main(String[] args) {
		Client julie = new Client(100);
		Magasin superU = new Magasin();
		
		Produit eyeLiner = new ProduitBeaute();
		
		superU.ajouterStock(eyeLiner, 2);
		
		julie.acheter(superU, eyeLiner, 1);
		julie.utiliser(eyeLiner);

	}

}
