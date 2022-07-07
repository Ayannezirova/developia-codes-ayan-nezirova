package ders18calismalar;

public class exceptionHandlingExample1 {
	public static void main(String[] args) {

		//Hər hansı bir ədədi sıfıra bölsək, ArithmeticException yaranır.

		try {
			int data = 100 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("rest of the code...");
	}
}
