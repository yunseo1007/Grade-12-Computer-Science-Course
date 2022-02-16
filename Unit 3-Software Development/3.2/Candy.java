
public class Candy {

	public String taste() {
		return "tastes sweet!";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Candy c1 = new Candy();
		System.out.println(c1.taste());
		Candy c2 = new Chocolate();
		System.out.println(c2.taste());
	}

}
