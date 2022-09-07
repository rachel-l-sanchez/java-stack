package zookeeper;

public class Mammal {
	private int energyLevel= 100;
	
	public int displayEnergy() {
		System.out.print("Energy Level: " + getEnergyLevel());
		return getEnergyLevel();
	}

	public Mammal(int energyLevel2) {
		// TODO Auto-generated constructor stub
		this.setEnergyLevel(energyLevel);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public int setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
		return energyLevel;
	}
	
}


