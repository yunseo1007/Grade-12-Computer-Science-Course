
public class Square extends Shape {
	
	public Square(double side) {
		super(1);
		this.sideLengths[0] = side;
	}
	public void perimeter() {
		double perimeter = this.sideLengths[0] * 4;
		System.out.println("The perimeter of the square is " + perimeter + " units.");
	}
	public void area() {
		double area = Math.pow(this.sideLengths[0],2);
		System.out.println("The area of the square is " + area + " square units.");
	}
}
