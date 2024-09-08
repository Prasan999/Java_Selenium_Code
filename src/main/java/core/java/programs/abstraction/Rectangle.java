package core.java.programs.abstraction;

public class Rectangle extends Shape { 

	double length; 
	double width; 

	public Rectangle(String color, double length, 
			double width) 
	{ 
		// calling Shape constructor 
		super(color); 
		System.out.println("Rectangle constructor called"); 
		this.length = length; 
		this.width = width; 
	} 

	@Override 
	double area() { 

		double area = length * width;
		return area ; 
	} 

	@Override 
	public String toString() 
	{ 
		return "Rectangle color is " + super.getColor() 
		+ "and area is : " + area(); 
	} 
} 

