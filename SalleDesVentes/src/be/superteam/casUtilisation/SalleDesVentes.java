package be.superteam.casUtilisation;

import java.util.ArrayList;

import be.superteam.domaine.Enchere;
import be.superteam.domaine.Objet;
import be.superteam.domaine.Utilisateur;

public final class SalleDesVentes {
	
	private ArrayList<Utilisateur> utilisateurs;
	private ArrayList<Objet> objets;
	
	private SalleDesVentes() { 
		if (SalleDesVentesLoader.INSTANCE != null) { 
			throw new IllegalStateException("Already instantiated"); 
		} 
	}
	
	private static class SalleDesVentesLoader { 
		private static final SalleDesVentes INSTANCE = new SalleDesVentes(); 
	} 

	public static SalleDesVentes getInstance() { 
		return SalleDesVentesLoader.INSTANCE; 
	}

	/**
	 * Retourne la liste des objets en vente (c'est-à-dire pas vendus)
	 * 
	 * @return
	 * 		Une liste contenant les objets
	 */
	public ArrayList<Objet> objetsEnVente() {
		ArrayList<Objet> objetsEnVente = new ArrayList<>();
		for (Objet objet : objets) {
			if (!objet.estVendu())
				objetsEnVente.add(objet);
		}
		return objetsEnVente;
	}
	
	public ArrayList<Objet> objetsVendus() {
		ArrayList<Objet> objetsVendus = new ArrayList<>();
		for (Objet objet : objets) {
			if (!objet.estVendu())
				objetsVendus.add(objet);
		}
		return objetsVendus;
	}

	/**
	 * Vend l'objet, c'est-à-dire qu'il la rajoute à la liste des objets achetés du meilleur enchérisseur
	 * 
	 * @param objet
	 * 		L'objet vendu
	 */
	public void vendreObjet(Objet objet) {
		objet.meilleureEnchere().getEncherisseur().ajouterObjetAchete(objet);
	}

}
