package ders18calismalar;

public class exceptionHandlingExample3 {

	public static void main(String[] args) {

		// Hər hansı dəyişənin və ya nömrənin formatı uyğun gəlmirsə, bu,
		// NumberFormatException ilə nəticələnə bilər.

		// Tutaq ki, simvolları olan sətir dəyişənimiz var; bu dəyişəni rəqəmə çevirmək
		// NumberFormatException-a səbəb olacaq.

		try {
			String s = "abc";
			int i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

	}

}
