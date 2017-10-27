package domaine;

public class LigneCommande {
	
	private int quantite;
	private double prixUnitaire;
	private Pizza pizza;
	
	public LigneCommande(Pizza pizza, int quantite) {
		this.quantite = quantite;
		this.pizza = pizza;
		this.prixUnitaire = pizza.getPrix();
	}

	public int getQuantite() {
		return quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public double calculTotalLigne() {
		return quantite * prixUnitaire;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pizza == null) ? 0 : pizza.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixUnitaire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LigneCommande other = (LigneCommande) obj;
		if (pizza == null) {
			if (other.pizza != null)
				return false;
		} else if (!pizza.equals(other.pizza))
			return false;
		if (Double.doubleToLongBits(prixUnitaire) != Double.doubleToLongBits(other.prixUnitaire))
			return false;
		return true;
	}
	
	
}
