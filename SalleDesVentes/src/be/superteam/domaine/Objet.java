package be.superteam.domaine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Objet implements Comparable<Object> {

	private static int numeroCourant = 0;
	private int num;
	private String description;
	private Utilisateur vendeur;
	private List<Enchere> encheres;
	
	public Objet(String description, Utilisateur vendeur) {
		this.num = ++numeroCourant;
		this.description = description;
		this.vendeur = vendeur;
		this.encheres = new ArrayList<>();
	}

	/**
	 *  Ajoute une nouvelle ench�re sur l�objet � condition que le montant soit plus �lev� que la derni�re ench�re effectu�e, 
	 *  que la date soit ult�rieure et que l�objet ne soit pas d�j� vendu. 
	 *  Cette m�thode ne doit �tre visible que par les classes du m�me package et ses sous-classes.
	 *  
	 * @param 
	 * 		enchere: L'ench�re � ajouter � l'objet
	 * @return
	 * 		un booleen, true si tout s'est bien pass�, false si l'ench�re n'a pas �t� ajout�e � l'objet
	 */
	
	protected boolean ajouterEnchere(Enchere enchere) {
		// V�rifie si le montant de l'ench�re est sup�rieur au montant de la derni�re ench�re
		if (!encheres.isEmpty() && !(enchere.getMontant() > meilleureEnchere().getMontant()))
			return false;
		
		// V�rifie si l'ench�re est bien ult�rieure � la derni�re ench�re
		if (!encheres.isEmpty() && !enchere.getDate().isBefore(meilleureEnchere().getDate()))
			return false;
			
		// V�rifie si l'objet n'est pas d�j� vendu
		if (this.estVendu())
			return false;
		
		return encheres.add(enchere);
	}
	
	/**
	 * Renvoie toute les ench�res de l'objet dans une collection non modifiable.
	 * 
	 * @return
	 * 		Une liste non modifiable, comprenant toute les ench�res de l'objet
	 */
	
	public List<Enchere> encheres() {
		return Collections.unmodifiableList(encheres);
	}
	
	/**
	 * Renvoie les ench�res effectu�es le jour donn� en param�tre.
	 * 
	 * @param 
	 * 		date, date pour laquelle on souhaite les ench�res
	 * @return
	 * 		Une liste non modifiable, comprenant les ench�res de l'objet effectu�es � la date sp�cifi�e
	 */
	
	public List<Enchere> encheres(LocalDate date) {
		ArrayList<Enchere> encheresDeLaDate = new ArrayList<>();
		for (Enchere enchere : encheres) {
			LocalDate dateEnchere = enchere.getDate().toLocalDate();
			if (dateEnchere.isEqual(date))
				encheresDeLaDate.add(enchere);
		}
		return Collections.unmodifiableList(encheresDeLaDate);
	}
	
	/**
	 * Donne la liste des ench�risseurs du jour (aujourd'hui)
	 * 
	 * @return
	 * 	Une liste non modifiable, comprenant les utilisateurs ayant ench�ri aujourd'hui
	 */
	
	public List<Utilisateur> encherisseursDuJour() {
		List<Enchere> encheresDuJour = encheres(LocalDate.now());
		List<Utilisateur> encherisseursDuJour = new ArrayList<Utilisateur>();
		if (!encheresDuJour.isEmpty()) {
			for (Enchere enchere : encheresDuJour) {
				encherisseursDuJour.add(enchere.getEncherisseur());
			}
		}
		return Collections.unmodifiableList(encherisseursDuJour());
	}
	
	/**
	 * Renvoie la meilleure (derni�re) ench�re. 
	 * 
	 * @return
	 * 		La meilleure ench�re pour l'objet. Null est renvoy� si aucune ench�re n�est pr�sente
	 */
	public Enchere meilleureEnchere() {
		if (encheres.size() == 0)
			return null;
		return encheres.get(encheres.size()-1);
	}
	
	/**
	 * Pr�cise si l�objet est vendu (c�d s'il se trouve dans la liste des objets achet�s du meilleur ench�risseur)
	 * 
	 * @return
	 * 		boolean: true si l'objet est vendu, false s'il ne l'est pas
	 */
	public boolean estVendu() {
		if (encheres.size() == 0)
			return false;
		
		if (meilleureEnchere().getEncherisseur().getObjetsAchetes().contains(this))
			return true;
	
		return false;
	}
	
	/**
	 * Renvoie le prix de vente de l'objet
	 * 
	 * @return
	 * 		double: le prix de vente de l'objet.  Renvoie 0 si l�objet n�est pas vendu
	 */
	
	public double prixDeVente() {
		if (!estVendu())
			return 0;
		
		return meilleureEnchere().getMontant();
	}
	
	public Utilisateur getVendeur() {
		return vendeur;
	}

	public String getDescription() {
		return description;
	}

	/** Compares this object with the specified object for order. 
	 * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. 
	 * 
	 * The implementor must ensure sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y. (This implies that x.compareTo(y) 
	 * must throw an exception if y.compareTo(x) throws an exception.) 
	 * 
	 * The implementor must also ensure that the relation is transitive: 
	 * (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
	 * Finally, the implementor must ensure that x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z. 
	 * 
	 * It is strongly recommended, but not strictly required that (x.compareTo(y)==0) == (x.equals(y)). 
	 * Generally speaking, any class that implements the Comparable interface and violates this condition should clearly indicate this fact. 
	 * The recommended language is "Note: this class has a natural ordering that is inconsistent with equals." 
	 * 
	 * In the foregoing description, the notation sgn(expression) designates the mathematical signum function, 
	 * which is defined to return one of -1, 0, or 1 according to whether the value of expression is negative, zero or positive.
	 * 
	 * @param:
	 * 		otherObject - the object to be compared.
	 * @return:
	 * 		a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 * @throws:
	 * 		NullPointerException - if the specified object is null
	 * 		ClassCastException - if the specified object's type prevents it from being compared to this object.
	 */
	
	@Override
	public int compareTo(Object otherObject) {
		if (this == otherObject)
			return 0;
		if (otherObject == null)
			throw new NullPointerException();
		if (getClass() != otherObject.getClass())
			throw new ClassCastException();
		
		Objet other = (Objet)otherObject;
		if (other.meilleureEnchere().getMontant() == this.meilleureEnchere().getMontant()) {
			return this.num-other.num;
		}
		return (int) (this.meilleureEnchere().getMontant()- other.meilleureEnchere().getMontant());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((encheres == null) ? 0 : encheres.hashCode());
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objet other = (Objet) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}
