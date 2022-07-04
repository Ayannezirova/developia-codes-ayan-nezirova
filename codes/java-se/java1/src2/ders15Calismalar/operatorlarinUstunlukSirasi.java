package ders15Calismalar;

public class operatorlarinUstunlukSirasi {
	public static void main(String[] args) {

		// mötərizə bütün operatorlardan üstündür.
		int a = 7;
		int b = 2;
		int c = 5;
		System.out.println("( 7 + 5 ) * 2 = " + (a + c) * b);

		/*
		 * . operatoru o deməkdir ki, aşağıdakı misala baxsaq System'in daxilindəki
		 * out'a müraciət edir. Out'un daxilindəki println'a müraciət edir
		 */

		System.out.println("Salam");

		// sonra unary operatorlardan "!" işarəsi gəlir.

		boolean nida = !true;
		System.out.println("!true = " + nida);
		boolean nida2 = !false;
		System.out.println("!false = " + nida2);

		// sonra vurma(*), bölmə(/), qalıq tapma(%) gəlir.

		System.out.println("4 * 5 = " + 4 * 5);
		System.out.println("54 / 6 = " + 54 / 6);
		System.out.println("63 % 2 = " + 63 % 2);

		// sonra unary operatorlar(++ və ya --) gəlir.

		int i = 25;
		i++;
		System.out.println("i++ = " + i);
		--i;
		System.out.println("--i = " + i);

		// sonra bitwise left shift(<<), bitwise right shift(>>), bitwise unsigned right
		// shift(>>>) gəlir.

		System.out.println("20<<4 = " + (20 << 4));
		System.out.println("10>>2 = " + (10 >> 2));
		System.out.println("32>>>5 = " + (32 >>> 5));

		// sonra əlaqəli operatorlar( == ; != ; > ; < ; >= ; <= ) gəlir.

		System.out.println("5 == 20 = " + (5 == 20));
		System.out.println("13 != 13 = " + (13 != 13));
		System.out.println("22 > 12 = " + (22 > 12));
		System.out.println("5 < 2 = " + (5 < 2));
		System.out.println("12 >= 12 = " + (12 >= 12));
		System.out.println("24 <= 32 = " + (24 <= 32));

		// sonra bitwise and(&), bitwise or(|), bitwise xor(^), bitwise complement(~)
		// gəlir.

		System.out.println("4 & 7 = " + (4 & 7)); // hər iki bit 1 olarsa, 1 verir, əks halda 0 göstərir.
		System.out.println("6 | 7 = " + (6 | 7)); // bitlərdən biri ya da ikisi də 1 olarsa, 1 verir, ikisidə 0 olarsa,
													// 0-ı göstərir.
		System.out.println("12 ^ 10 = " + (12 ^ 10)); // bitlər fərqlidirsə, 1 verir, əks halda 0 göstərir.
		System.out.println(" ~ 6 = " + ~6);

		// sonra məntiqi operatorlar( &&, || ) gəlir.

		int k = 13;
		int l = 26;
		if (k == 13 && l == 24) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

		int h = 6;
		int y = 15;
		if (h == 6 || y == 15) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

		// sonra ternary operatorlar( ?, : ) gəlir.
		
		int x = 7;
		int w = 5;
		int min = (x < w) ? x : w;
		System.out.println(min);
		
		// ən axırda mənimsətmə operatorları( =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=,
		// >>=, >>>= ) gəlir.

		int f = 10;
		int g = 20;
		int n = 13;
		int s = 10;
		f += 4;// f=f+4 (f=10+4)
		g -= 4;// g=g-4 (g=20-4)
		System.out.println(f);
		System.out.println(g);
		n *= 2;// n*2
		s /= 5;// s/5
		System.out.println(n);
		System.out.println(s);
//ve s.
	}
}
