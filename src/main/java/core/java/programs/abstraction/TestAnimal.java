package core.java.programs.abstraction;

public class TestAnimal {
	
	public static void main(String[] args) {
		
		Animal animalCat = new Cat("white");
		animalCat.sound();
		animalCat.animalName();
		
		
		Animal animalDog = new Dog("black");
		animalDog.sound();
		animalDog.animalName();
		
		
	}

}
