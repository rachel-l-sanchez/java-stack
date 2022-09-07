package zookeeper;

public class Gorilla extends Mammal{
	private String throwThings;
	
	public Gorilla(int energyLevel, String throwThings) {
		super(energyLevel);
		this.throwThings = throwThings;
	}

	public Gorilla(int energyLevel) {
		super(energyLevel);
		this.climb(100);
		super.displayEnergy();
		// TODO Auto-generated constructor stub
	}
	
	public int eatBananas(int energyLevel) {
		energyLevel = super.setEnergyLevel(getEnergyLevel()+ 10);
		return energyLevel;
	}
	
	public int climb(int energyLevel) {
		energyLevel = super.getEnergyLevel();
 		int depletedEnergy = super.setEnergyLevel(energyLevel - 10);
		return depletedEnergy;
	}

	public int throwSomething(int energyLevel, String throwThings) {
		energyLevel = super.getEnergyLevel();
		int depletedEnergy = super.setEnergyLevel(energyLevel- 5);
		this.throwThings = throwThings;
		System.out.print(throwThings);
		return depletedEnergy;
	}


}

