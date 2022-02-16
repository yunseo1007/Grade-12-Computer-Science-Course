
public class Teacher extends Person{

	String degree;
	
	public String getDegree() {
		return this.degree;
	}
	
	public String toString() {
		return getName() + " " + getAge() + " " + getDegree();
	}
	public Teacher(String name, int age, String theDegree)  {
	
		super(name, age);
		this.degree = theDegree;
	}
}