
public class Dog {
	
	String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public boolean equals (Object other) {
		
		if (other.equals(this.name)) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog d1= new Dog("Rufus");
		Dog d2= new Dog("Sally");
		Dog d3= new Dog("Rufus");
		Dog d4 = d3;
		System.out.println(d1.equals(d2));
		System.out.println(d2.equals(d3));
		System.out.println(d1.equals(d3));
		System.out.println(d3.equals(d4));
		
		// test for yourself
		Beagle b1 = new Beagle("Rufus");
		System.out.println(b1.equals(d1));
		System.out.println(d1.equals(b1));
	}

}
