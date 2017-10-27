package domaine;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza implements Iterable<Ingredient> {

	public static final double PRIX_BASE = 4;
	private String titre;
	private String description;
	
	protected List<Ingredient> ingredients;

	protected Pizza(String titre, String description) {
		this.titre = titre;
		this.description = description;
		ingredients = new ArrayList<Ingredient>();
	}
	
	protected double calculPrix() {
		double prix = PRIX_BASE;
		for (Ingredient ingredient : ingredients) {
			prix += ingredient.getPrix();
		}
		return prix;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public abstract void ajouterIngredient(Ingredient ingredient);
	
	public abstract void retirerIngredient(Ingredient ingredient);

	public abstract double getPrix();
	
}
