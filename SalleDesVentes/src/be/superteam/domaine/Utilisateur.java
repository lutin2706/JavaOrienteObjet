package be.superteam.domaine;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Utilisateur {

	private static int numeroCourant = 0;
	private int num;
	private String nom;
	private String prenom;
	private String mail;
	private TreeSet<Objet> objetsAchetes;
	
	public Utilisateur(String nom, String prenom, String mail) {
		this.num = ++numeroCourant;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		objetsAchetes = new TreeSet<>();
	}

	
	public SortedSet<Objet> getObjetsAchetes() {
		return Collections.unmodifiableSortedSet(objetsAchetes);
	}

	/**
	 *  Rajoute l�objet � la liste des objets achet�s 
	 *  - s�il ne s�y trouve pas d�j�
	 *  - si l�objet n�est pas d�j� achet�.
	 *  - si l�utilisateur � qui on ajoute l�objet est bien celui de l�ench�re accept�e.
	 *  
	 * @param objet
	 * @return
	 * 		True si l'objet a bien �t� ajout� � la liste des objets achet�s
	 * 		False si l'objet n'a pas �t� ajout�
	 */
	public boolean ajouterObjetAchete(Objet objet) {
		if (objetsAchetes.contains(objet))
			return false;
		if (!objet.meilleureEnchere().getEncherisseur().equals(this))
			return false;
		if (objet.estVendu())
			return false;
		return objetsAchetes.add(objet);
	}
	
	/**
	 *  Renvoie les objets achet�s par l�utilisateur. 
	 *  
	 * @return
	 */
	public SortedSet<Objet> objetsAchetes() {
		return Collections.unmodifiableSortedSet(objetsAchetes);
	}
	
	/**
	 * Renvoie les objets achet�s par l�utilisateur chez un certain vendeur pass� en param�tre
	 * 
	 * @param vendeur
	 * @return
	 */
	public SortedSet<Objet> objetsAchetes(Utilisateur vendeur) {
		TreeSet<Objet> listeARenvoyer = new TreeSet<>();
		for (Objet objet : objetsAchetes) {
			if (objet.getVendeur().equals(vendeur))
				listeARenvoyer.add(objet);
		}
		return listeARenvoyer;
	}


	@Override
	public String toString() {
		return "Utilisateur [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
