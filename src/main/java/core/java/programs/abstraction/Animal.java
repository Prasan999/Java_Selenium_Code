package core.java.programs.abstraction;

public abstract class Animal {
	String color;
	int height;

	public Animal(String color) {
		this.color= color;
	}

	public Animal(String color, int height ) {

		this.height= height;
		this.color= color;
	}
	
	abstract void sound();
	
	public void animalName() {
		
		System.out.println("Arjuna");
		
		
	}

	public String getColor() {
		return color;

	} 
	
	public int getHeight() {
		return height;

	} 

}
