package domaine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PizzaComposee extends Pizza {
	
	private static final int REMISE = 15;
	private double prix;
	
	public double getPrix() {
		return prix;
	}

	public PizzaComposee(String titre, String description, ArrayList<Ingredient> ingredients) {
		super(titre, description);
		this.ingredients = ingredients;
		
		// Calcul du prix de la pizza
		this.prix = Math.ceil(calculPrix() * (1 - REMISE / 100));
	}
	
	@Override
	public void ajouterIngredient(Ingredient ingredient) {
		throw new UnsupportedOperationException("La liste des ingrédients de cette pizza ne peut être modifiée");
	}

	@Override
	public void retirerIngredient(Ingredient ingredient) {
		throw new UnsupportedOperationException("La liste des ingrédients de cette pizza ne peut être modifiée");
	}

	@Override
	public Iterator<Ingredient> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
