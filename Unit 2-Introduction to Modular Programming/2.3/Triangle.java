
public class Triangle extends Shape{
	
	public Triangle(double base, double height, double side1, double side2) {
		super(4);
		this.sideLengths[0] = base;
		this.sideLengths[1] = height;
		this.sideLengths[2] = side1;
		this.sideLengths[3] = side2;
		
	}
	public void perimeter (){
		double perimeter = this.sideLengths[0] + this.sideLengths[2] + this.sideLengths[3];
		System.out.println("The perimeter of the triangle is " + perimeter + " units.");
	}
	public void area () {
		double area = this.sideLengths[0] * this.sideLengths[1] * 1/2;
		System.out.println("The area of the triangle is " + area + " square units.");
	}
}
 