package domaine;

public class Ingredient {
	
	private String nom;
	private double prix;
	
	public Ingredient(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Ingredient otherIngredient = (Ingredient) obj;
		if (nom == null) {
			if (otherIngredient.nom != null)
				return false;
		} else if (!nom.equals(otherIngredient.nom))
			return false;
		return true;
	}
	
}
