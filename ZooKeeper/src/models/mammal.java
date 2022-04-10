package models;

public class mammal {
	private int energyLevels = 100;
	
	
public int displayEnergy() {
	
	System.out.println(this.energyLevels);
	
	return this.energyLevels;
	
}


public int getEnergyLevels() {
	return energyLevels;
}


public void setEnergyLevels(int energyLevels) {
	this.energyLevels = energyLevels;
}

}
