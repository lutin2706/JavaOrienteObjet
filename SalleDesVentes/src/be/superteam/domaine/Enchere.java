package be.superteam.domaine;

import java.time.LocalDateTime;

public class Enchere {

	private double montant;
	private LocalDateTime date;
	private Utilisateur encherisseur;
	private Objet objet;
	
	public Enchere(double montant, Utilisateur encherisseur, Objet objet) {
		this.date = LocalDateTime.now();
		this.montant = montant;
		this.encherisseur = encherisseur;
		this.objet = objet;
		objet.ajouterEnchere(this);
	}

	public double getMontant() {
		return montant;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public Objet getObjet() {
		return objet;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((encherisseur == null) ? 0 : encherisseur.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((objet == null) ? 0 : objet.hashCode());
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
		Enchere other = (Enchere) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (encherisseur == null) {
			if (other.encherisseur != null)
				return false;
		} else if (!encherisseur.equals(other.encherisseur))
			return false;
		if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
			return false;
		if (objet == null) {
			if (other.objet != null)
				return false;
		} else if (!objet.equals(other.objet))
			return false;
		return true;
	}
	
	
}
