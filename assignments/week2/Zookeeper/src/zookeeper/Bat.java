package zookeeper;

public class Bat extends Mammal {
	private String flying;
	private String burning;
	private int energyLevel = 300;

	public Bat(int energyLevel2, String flying, String burning, int energyLevel) {
		super(energyLevel2);
		this.setEnergyLevel(energyLevel);
		this.flying = flying;
		this.burning = burning;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public int setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
		return energyLevel;
	}

	public int fly(String flying, int energyLevel2) {
		System.out.println(flying);
		setEnergyLevel(getEnergyLevel() - 100);
		return getEnergyLevel();
	}
	
	public int eatHumans(int energyLevel2) {
		int increasedEnergy = setEnergyLevel(getEnergyLevel() + 25);
		return increasedEnergy;
	}
	
	public int attackTown(int energyLevel2) {
		burning =  "ahhhh";
		System.out.println(burning);
		int depletedEnergy = setEnergyLevel(getEnergyLevel() - 100);
		return depletedEnergy;
	}

}
