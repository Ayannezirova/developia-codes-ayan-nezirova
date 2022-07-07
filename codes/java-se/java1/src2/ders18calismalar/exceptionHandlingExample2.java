package ders18calismalar;

public class exceptionHandlingExample2 {

	public static void main(String[] args) {

		// Hər hansı bir dəyişəndə ​​null dəyərimiz varsa , dəyişən üzərində hər hansı
		// əməliyyatı yerinə yetirmək NullPointerException adlanır.

		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException a) {
			System.out.println(a);
		}
	}

}
