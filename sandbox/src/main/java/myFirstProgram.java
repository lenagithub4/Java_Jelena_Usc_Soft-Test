public class MyFirstProgram {
	
	
	public static void main (String[] args) {
		hello("world");
		hello("Admin");

		double l = 3.5;
		System.out.println("Площадь квадрата со стороной  " + l + " = " + square(l));

	}
		public static void hello(String slovo1) {

			System.out.println("Hello, " + slovo1  + "!");
		}

		public static void match() {
			System.out.println(2 + 2);
			System.out.println(2 / 2);
			System.out.println(1.0 / 2);
			System.out.println(1 / 2.0);
			System.out.println("2" + "A");
			System.out.println("2" + 2);
			System.out.println(2 + 2 * 2);
			System.out.println("2 + 2 =" + (2 + 2));
		}

		public static double square(double len) {
			return (len * 2);
		}




	
	
}