package domaine;

import java.time.LocalDate;
import java.util.Iterator;

public class PizzaComposable extends Pizza {
	
	private LocalDate date;
	private Client createur;

	public PizzaComposable(Client client) {
		super("Pizza composable du client " + client.getNumero() + "(" + LocalDate.now().toString() + ")", " Pizza de  " + client.getNom() + " " + client.getPrenom());
		this.createur = client;
		this.date = LocalDate.now();
	}
	
	public double getPrix() {
		return calculPrix();
	}

	public void ajouterIngredient(Ingredient ingredient) {
		if (!ingredients.contains(ingredient))
			ingredients.add(ingredient);
	}
	
	public void retirerIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}
	
	@Override
	public Iterator<Ingredient> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
