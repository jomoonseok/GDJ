package ex14_interface;

public class Circle implements Shape {
	
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return PI * Math.pow(radius, 2);
	}

}
