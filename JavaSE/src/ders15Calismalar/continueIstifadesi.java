package ders15Calismalar;

public class continueIstifadesi {
	public static void main(String[] args) {

		for (int j = 1; j <= 10; j++) {
			if (j == 5) {
				continue;
			}
			System.out.println(j);

			/*
			 * Continue dövrlərdə istifadə olunur. Qeyd edilən ədədi konsola çap etmir .
			 * Yuxarıdakı misalda j 5 olduqda şərt ödənir və continue girdiyi üçün 5 konsola
			 * çıxmır və digər ədədlər konsola çıxır.
			 */

		}
	}
}
