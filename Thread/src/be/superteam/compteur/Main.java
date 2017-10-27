package be.superteam.compteur;

import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Compteur> listeArrivee = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		Compteur[] compteurs = new Compteur[10];
		for (int i = 0; i < compteurs.length; i++) {
			compteurs[i] = new Compteur("Toto " + i, 10);
			compteurs[i].start();
		}
	}
}
