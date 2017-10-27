package be.superteam.main;

import java.util.ArrayList;
import java.util.Iterator;

import be.superteam.model.Charact;
import be.superteam.model.Enemy;
import be.superteam.model.Mage;
import be.superteam.model.Thief;
import be.superteam.model.Warrior;

public class Main {

	public static void main(String[] args) {
		Warrior warrior = new Warrior("Rambo", 10, 5);
		Enemy enemy = new Enemy("Terminator", 40, 3);
		Thief thief = new Thief("Arsène", 8, 4, 6);
		Mage mage = new Mage("Merlin", 5, 3);

		ArrayList<Charact> groupe = new ArrayList<>();
		groupe.add(warrior);
		groupe.add(mage);
		groupe.add(thief);

		boolean battleOnGoing = true;
		do {
			Iterator<Charact> it = groupe.iterator(); // On declare explicitement un iterator, afin de pouvoir retirer les personnages de la liste sans se ramasser une exception
			while (it.hasNext()) {
				Charact character = it.next();
				// Phase 1 : le personnage attaque l'ennemi
				System.out.println(character.getName() + " (" + character.getPoints() + " points) attacks " + enemy.getName() + " (health " + enemy.getHealthPoints() + ")");

				if (!character.attack(enemy)) {
					System.out.println("\t" + character.getName() + " does not win. " + enemy.getName() + " has " + enemy.getHealthPoints() + " health remaining. ");
					System.out.println("\t" + enemy.getName() + " (" + enemy.getPoints() + " points) attacks " + character.getName() + " (health " + character.getHealthPoints() + ")");
					
					// Phase 2 : l'ennemi attaque le personnage
					if (enemy.attack(character)) {
						System.out.println(enemy.getName() + " wins ! " + character.getName() + " is dead and removed from the group.");
						it.remove();
						if (groupe.size() == 0) {
							System.out.println(enemy.getName() + " wins !");
							// enemyWins = true;
							battleOnGoing = false;
							break;
						} 
					} else {
						System.out.println("\t" + enemy.getName() + " does not win. " + character.getName() + " has " + character.getHealthPoints() + " health remaining. ");
					}
				} else {
					System.out.println(character.getName() + " wins ! " + enemy.getName() + " is dead !");
					battleOnGoing = false;
					break;
				}
				System.out.println("Attack is over.");
				System.out.println("------------------------------------------------------------------------------------------");
			}
		} while (battleOnGoing);
		System.out.println("Battle is over. " + groupe.size() + " characters remaining in the group");
	}

}
