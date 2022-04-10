package models;

public class Gorilla extends mammal{
	
public void throwSomething() {
	this.setEnergyLevels(this.getEnergyLevels()-5);
	
	System.out.println("Gorilla has thrown something and now their energy is " + this.getEnergyLevels());
}

public void eatBananas() {
	this.setEnergyLevels(this.getEnergyLevels()+10);
	System.out.println("Gorilla has eaten some good bananas and now their energy is " + this.getEnergyLevels());
}

public void climb() {
	this.setEnergyLevels(this.getEnergyLevels()-10);
	System.out.println("Gorilla is climbing and now their energy is " + this.getEnergyLevels());
}

}
