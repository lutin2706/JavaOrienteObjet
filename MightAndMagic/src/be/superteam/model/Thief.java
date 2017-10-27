package be.superteam.model;

public class Thief extends Warrior {
	
	private int forcePoints;
	private int manaPoints;

	public Thief(String name, int healthPoints, int forcePoints, int manaPoints) {
		super(name, healthPoints, forcePoints);
		this.manaPoints = manaPoints;
	}

	@Override
	public int getPoints() {
		
		return (manaPoints > forcePoints ? manaPoints : forcePoints);
	}

}
