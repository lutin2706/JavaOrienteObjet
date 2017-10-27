package be.superteam.model;

public class Enemy extends Charact {
	
	private int forcePoints;

	public Enemy(String name, int healthPoints, int forcePoints) {
		super(name, healthPoints);
		this.forcePoints = forcePoints;
	}

	@Override
	public int getPoints() {
		return forcePoints;
	}

	
}
