package lessonsJava.Lesson0;

import lessonsJava.Lesson1.Point;

public class MyFirstProgram {
	

	public static void main (String[] args) {
		hello("world");
		hello("Admin");

		Square s = new Square(5.5);
		System.out.println("ploshadj kvadrata " + s.l + " = " + s.area());

		Restangle r = new Restangle(5, 8);
		System.out.println("restangle " + r.a + " и " + r.b + " = " + r.area());

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
	
}