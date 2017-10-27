package be.superteam.model;

public class Mage extends Charact {
	
	private int manaPoints;

	public Mage(String name, int healthPoints, int manaPoints) {
		super(name, healthPoints);
		this.manaPoints = manaPoints;
	}

	@Override
	public int getPoints() {
		return manaPoints;
	}

}
