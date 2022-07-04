package ders17calismalar;

import java.util.ArrayList;
import java.util.Collections;

public class list {

	public static void main(String[] args) {

		ArrayList<Computer> list = new ArrayList<Computer>();
		list.add(new Computer(2123, "HP", 12383));
		list.add(new Computer(1381, "acer", 13423));
		list.add(new Computer(3424, "asus", 23435));
		list.add(new Computer(2521, "lenovo", 15352));
		Collections.sort(list);
		System.out.println(list);
	}

}
