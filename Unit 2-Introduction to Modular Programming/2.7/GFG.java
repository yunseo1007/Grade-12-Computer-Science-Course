
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating an instances of Bicycle
		// doing some operations
		Bicycle bicycle = new Bicycle();
		bicycle.changeGear(2);
		bicycle.speedUp(3);
		bicycle.applyBrakes(1);
		
		System.out.println("Bicycle present state: ");
		bicycle.printStates();
		
		// creating instance of the bike.
		Bike bike = new Bike();
		bike.changeGear(1);
		bike.speedUp(4);
		bike.applyBrakes(3);
		
		System.out.println("Bike present state: ");
		bike.printStates();
	}

}
