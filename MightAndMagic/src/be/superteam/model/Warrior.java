package be.superteam.model;

public class Warrior extends Charact {
	
	private int forcePoints;

	public Warrior(String name, int healthPoints, int forcePoints) {
		super(name, healthPoints);
		this.forcePoints = forcePoints;
	}

	@Override
	public int getPoints() {
		return forcePoints;
	}

}
