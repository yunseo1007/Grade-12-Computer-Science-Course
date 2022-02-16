
public class Circle extends Shape {
		
	public Circle(double radius) {
		super(1);
		this.sideLengths[0] = radius;
	}
	public void perimeter (){
		double perimeter = 2 * Math.PI * this.sideLengths[0];
		System.out.println("The perimeter of the circle is " + perimeter + " units.");
	}
	public void area () {
		double area = Math.PI * Math.pow(this.sideLengths[0], 2);
		System.out.println("The area of the circle is " + area + " circle units.");
	}
}
