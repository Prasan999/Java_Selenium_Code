package core.java.programs.abstraction;

public class Dog extends Animal{



	public Dog(String color) {
		super(color);
	}

	@Override
	void sound() {
		System.out.println("Dog sound bow bow..."+'\n'+"Dog color.."+color);

	}

	public void animalName() {

		System.out.println("Tony");


	}



}
