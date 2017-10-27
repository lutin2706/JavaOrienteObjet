package casUtilisation;

import static domaine.Ingredients.*;

import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaine.Commande;
import domaine.Ingredient;
import domaine.Pizza;
import domaine.PizzaComposable;
import domaine.PizzaComposee;
import exceptions.NoCommandeEnCoursException;

public final class GestionPizzeria {

	private List<Client> listeClients;

	public Pizza p_4saisons;
	public Pizza p_4fromages;
	public Pizza p_margarita;
	public Pizza p_duchef;
	public Pizza p_mariniere;

	private static class PizzeriaLoader { 
		private static final GestionPizzeria INSTANCE = new GestionPizzeria(); 
	} 

	private GestionPizzeria() { 
		if (PizzeriaLoader.INSTANCE != null) { 
			throw new IllegalStateException("Already instantiated"); 
		} 
		ArrayList<Ingredient> ingredients = new ArrayList<>(); 
		ingredients.add(tomate); 
		ingredients.add(artichaut); 
		ingredients.add(jambon); 
		ingredients.add(olives); 
		ingredients.add(parmesan); 
		ingredients.add(mozza); 
		p_4saisons = new PizzaComposee("4 saisons", "4 go�ts qui d�filent selon les saisons", 
				ingredients); 
		ingredients = new ArrayList<>(); 
		ingredients.add(tomate); 
		ingredients.add(parmesan); 
		ingredients.add(gogonzola); 
		ingredients.add(pecorino); 
		ingredients.add(mozza); 
		p_4fromages = new PizzaComposee("4 fromages", "le m�lange g�n�reux des fromages italiens", 
				ingredients); 
		ingredients = new ArrayList<>(); 
		ingredients.add(tomate); 
		ingredients.add(mozza); 
		p_margarita = new PizzaComposee("margarita", "la simplissit� culinaire", ingredients); 
		ingredients = new ArrayList<>(); 
		ingredients.add(tomate); 
		ingredients.add(aubergines); 
		ingredients.add(jambon); 
		ingredients.add(epinards); 
		ingredients.add(mozza); 
		ingredients.add(gogonzola); 
		p_duchef = new PizzaComposee("du chef", "l'�quilibre des saveurs du chef", ingredients); 
		ingredients = new ArrayList<>(); 
		ingredients.add(tomate); 
		ingredients.add(scampis); 
		ingredients.add(mozza); 
		p_mariniere = new PizzaComposee("marini�re", "les saveurs de l'oc�an", ingredients);
		listeClients = new ArrayList<Client>();
	} 

	public static GestionPizzeria getInstance() { 
		return PizzeriaLoader.INSTANCE; 
	}

	public Client enregistrerClient(String nom, String prenom, String telephone) {
		Client newClient = new Client(listeClients.size() + 1, nom, prenom, telephone);
		listeClients.add(newClient);
		return newClient;
	}

	/** 
	 * Cr�e une commande 
	 *  
	 * @param client 
	 *            le client pour qui la commande est cr��e; ce client appartient 
	 *            � la liste des clients 
	 * @return la commande cr��e pour le client sinon null (pas d'exception) 
	 */ 
	public Commande creerCommande(Client client) { 
		Commande commande = null;
		if (listeClients.contains(client)) {
			commande = new Commande(client);
//			Commande commande2 = (Commande) commande.clone();
		}
		return commande;
	} 

	/** 
	 * Ajoute � la commande en cours du client la pizza en quantit� indiqu�e 
	 *  
	 * @param client 
	 *            le client qui a une commande en cours � qui on ajoute la pizza;  
	 *            ce client appartient � la liste des clients 
	 * @param pizza 
	 *            la pizza � rajouter � la commande en cours du client ; la pizza  
	 *            appartient � la carte des pizzas 
	 * @param quantite 
	 *            le nombre de fois qu'on ajoute la pizza � la commande en 
	 *            cours du client 
	 * @throws NoCommandeEnCoursException 
	 *             si le client n'a pas de commande en cours 
	 * @throws IllegalArgumentException si la quantit� est n�gative ou nulle 
	 */  
	public void ajouterALaCommande(Client client, Pizza pizza, int quantite) throws NoCommandeEnCoursException, IllegalArgumentException {
		if (!listeClients.contains(client))
			return;
		
		if (quantite <= 0)
			throw new IllegalArgumentException("La quantit� doit �tre positive");
		
		Commande commandeEnCours = client.getCommandeEnCours();
		
		if (commandeEnCours == null)
			throw new NoCommandeEnCoursException("Le client n'a pas de commande en cours");

		client.getCommandeEnCours().ajouterPizza(pizza, quantite);
	} 

	/** 
	 * Cr�e une pizza composable pour un client � partir des ingr�dients. Ajoute 
	 * ensuite cette pizza � la commande en cours du client en quantit� pass�e 
	 * en param�tre. 
	 *  
	 * @param client 
	 *            le client qui a une commande en cours qui cr�e un pizza 
	 *            composable ; ce client appartient � la liste des clients 
	 * @param quantite 
	 *            le nombre de fois qu'on ajoute la pizza composabe � la 
	 *            commande en cours du client 
	 * @param ingredients 
	 *            les ingr�dients qui composent la pizza composable du client ;  
	 *            la liste contient au moins un ingr�dient et tous les ingr�dients  
	 *            de la liste sont dans Ingr�dients  
	 * @throws NoCommandeEnCoursException 
	 *             si le client n'a pas de commande en cours 
	 * @throws IllegalArgumentException si la quantit� est n�gative ou nulle 
	 */ 
	public void creerPizzaComposable(Client client, int quantite, Ingredient... ingredients) throws NoCommandeEnCoursException, IllegalArgumentException { 
		Pizza pizza = new PizzaComposable(client);
		if (ingredients.length == 0)
			return;
		for (Ingredient ingredient : ingredients) { // Verifier que l'ingr�dient fait partie de la liste des Ingr�dients
//			Ingredient.class.getField("NOM").get(null);
			pizza.ajouterIngredient(ingredient);
		}
		ajouterALaCommande(client, pizza, quantite);
	} 

	/** 
	 * Cr�e une pizza composable pour un client � partir des ingr�dients. Ajoute 
	 * ensuite cette pizza � la commande en cours du client. 
	 *  
	 * @param client 
	 *            le client qui a une commande en cours qui cr�e un pizza 
	 *            composable ;  ce client appartient � la liste des clients 
	 * @param ingredients 
	 *            les ingr�dients qui composent la pizza composable du client ; 
	 *            la liste contient au moins un ingr�dient et tous les ingr�dients  
	 *            de la liste sont dans Ingr�dients  
	 * @throws NoCommandeEnCoursException 
	 *             si le client n'a pas de commande en cours 
	 */ 
	public void creerPizzaComposable(Client client, Ingredient... ingredients) throws NoCommandeEnCoursException {
		creerPizzaComposable(client, 1, ingredients);
	} 

	/** 
	 * Valide la commande en cours du client; la commande devient pass�e et 
	 * n'est donc plus en cours. 
	 *  
	 * @param client 
	 *            le client qui valide sa commande ; ce client appartient � 
	 *            la liste des clients 
	 * @throws NoCommandeEnCoursException 
	 *             si le client n'a pas de commande en cours 
	 */ 
	public void validerCommande(Client client) throws NoCommandeEnCoursException {
		if (!listeClients.contains(client))
			return;
		if (client.getCommandeEnCours() == null)
			throw new NoCommandeEnCoursException();
		client.cloturerCommandeEnCours();
		
	} 
}
