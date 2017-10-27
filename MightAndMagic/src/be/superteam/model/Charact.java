package be.superteam.model;

import java.util.Random;

public abstract class Charact {

	protected String name;
	protected int healthPoints;
	private Random random;
	
	public Charact(String name, int healthPoints) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.random = new Random();
	}
	
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	public String getName() {
		return name;
	}

	public abstract int getPoints();

	public boolean attack(Charact opponent) {
		opponent.healthPoints = calculatePoints(this.getPoints(), opponent.getHealthPoints());
		return (opponent.healthPoints > 0 ? false : true);
	}

	private int calculatePoints(int attackPoints, int opponentHealthPoints) {
		if (opponentHealthPoints > attackPoints) {
			opponentHealthPoints -= attackPoints * random.nextFloat();
		} else {
			opponentHealthPoints = 0;
		}
		return opponentHealthPoints;
	}

}
