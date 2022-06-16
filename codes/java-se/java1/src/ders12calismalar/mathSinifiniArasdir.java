package ders12calismalar;

public class mathSinifiniArasdir {

	public static void main(String[] args) {
		/* .abs moduldur, mutleq musbet eded verir */
		System.out.println("abs() - " + Math.abs(-12.3));

		/* verilmis onluq ededi yuxari yuvarlaqlasdirir */
		System.out.println("ceil() - " + Math.ceil(0.1));

		/* verilmis onluq ededi asagi yuvarlaqlasdirir */
		System.out.println("floor() - " + Math.floor(0.12));

		/*
		 * moterize icinde kicik eded, boyuk ededin quvveti kimi hereket edir. yeni 5 ustu 4
		 */
		System.out.println("pow() - " + Math.pow(5, 4));

		/* tesadufi ededler yaradmaq ucun istifade olunur */
		System.out.println("random() - " + Math.random() * 45);

		/* yuvarlaqlasdirma aparir */
		System.out.println("round() - " + Math.round(45.9));

		/* daxil edilmis deyerin kvadrat kokunu goturur */
		System.out.println("sqrt() - " + Math.sqrt(49));

	}

}
