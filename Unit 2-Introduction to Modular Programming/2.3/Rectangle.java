
public class Rectangle extends Shape {

	
	public Rectangle(double width, double length) {
		super(2);
		this.sideLengths[0] = length;
		this.sideLengths[1] = width;
	}
	public void area () {
		double area = this.sideLengths[0] * this.sideLengths[1];
		System.out.println("The area of the rectangle is " + area + " square units.");
	}
	public void perimeter () {
		double perimeter = (this.sideLengths[0] + this.sideLengths[1]) * 2;
		System.out.println("The perimeter of the rectanle is " + perimeter + " units.");
	}
}