
public class Person {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name; 
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return getName() + " " + getAge();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person("Destini", 20);
		System.out.println(p);
		Teacher p2 = new Teacher("Erica", 55, "Masters in Teaching");
		System.out.println(p2);
	

	}

}
