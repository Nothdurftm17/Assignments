package models;

public class Bat extends mammal {
	
	public Bat () {
		this.setEnergyLevels(300);
		
	}
	
	
	public void fly() {
		this.setEnergyLevels(this.getEnergyLevels()-50);
		System.out.println("*bat flying*");
		System.out.println("the bat's energy level is " + this.getEnergyLevels());
	}
	
	public void eatHumans() {
		this.setEnergyLevels(this.getEnergyLevels()+25); 
		System.out.println("yikes, well the bat's energy level is " + this.getEnergyLevels());
	}
	
	public void attackTown() {
		this.setEnergyLevels(this.getEnergyLevels()-100);
		System.out.println("Ahhh the bats are attacking the town!");
		System.out.println("the bat's energy level is " + this.getEnergyLevels());
	}
	
	
}
