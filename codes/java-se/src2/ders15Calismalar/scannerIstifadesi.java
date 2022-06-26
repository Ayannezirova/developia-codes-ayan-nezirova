package ders15Calismalar;

import java.util.Scanner;

public class scannerIstifadesi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Adinizi yazin");
		String name = sc.nextLine();
		System.out.println("Salam" + name);
	}

}
