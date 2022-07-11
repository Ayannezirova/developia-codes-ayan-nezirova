package ders18calismalar;

public class exceptionHandlingExample4 {

	public static void main(String[] args) {

		// Massiv öz ölçüsünü aşdıqda, ArrayIndexOutOfBoundsException baş verir.
		// ArrayIndexOutOfBoundsException baş verməsinin başqa səbəbləri də ola bilər.
		try {
			int a[] = new int[5];
			a[10] = 50;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}
}
