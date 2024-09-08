package core.java.programs.abstraction;

public class Cat extends Animal {


	public Cat(String color ){
		super(color);

	}

	@Override
	public void sound() {

		System.out.println("Cat sound Meo Meo"+'\n'+"Cat color..."+color);

	}



}
