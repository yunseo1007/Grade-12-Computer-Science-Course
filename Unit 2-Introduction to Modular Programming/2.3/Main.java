
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape myShape = new Shape(8);
		Shape myRectangle = new Rectangle(2,4);
		Shape myTriangle = new Triangle(5,6,4,3);
		Shape myCircle = new Circle(3);
		myShape.perimeter();
		myRectangle.perimeter();
		myRectangle.area();
		myTriangle.perimeter();
		myTriangle.area();
		myCircle.perimeter();
		myCircle.area();
	}

}
