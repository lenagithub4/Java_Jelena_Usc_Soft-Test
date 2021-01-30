package lessonsJava.Lesson0;

public class MyFirstProgram {
	
	
	public static void main (String[] args) {
		hello("world");
		hello("Admin");

		Square s = new Square(5.5);
		System.out.println("ploshadj kvadrata " + s.l + " = " + area(s));

		Restangle r = new Restangle(5, 8);
		System.out.println("restangle " + r.a + " и " + r.b + " = " + area(r));

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

		public static double area(Square s) {
			return (s.l * s.l);
		}


	 	public static double area(Restangle r) {
		return (r.a * r.b);
		}

	
	
}