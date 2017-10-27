package be.superteam.compteur;

import java.util.Random;

/**
 * Un "compteur" a un nom (Toto par exemple) et il compte de 1 à n (nombre entier positif quelconque). 
 * Il marque une pause aléatoire entre chaque nombre (de 0 à 5000 millisecondes par exemple).
 * Un compteur affiche chaque nombre (Toto affichera par exemple, "Toto : 3") 
 * et il affiche un message du type "*** Toto a fini de compter jusqu'à 10" quand il a fini.
 * 
 * @author Sev
 *
 */
public class Compteur extends Thread {
	
	private Random random = new Random();
	private int n;
		
	public Compteur(String nom, int n) {
		super(nom);
		this.n= n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + " : " + i);
		}
		Main.listeArrivee.add(this);
		System.out.println("*** " + getName() + " a fini de compter jusqu'à " + n);
		System.out.println("\tIl est le n° " + (Main.listeArrivee.indexOf(this) + 1));
	}
}
