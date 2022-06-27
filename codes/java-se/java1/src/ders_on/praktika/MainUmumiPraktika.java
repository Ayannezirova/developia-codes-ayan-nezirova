package ders_on.praktika;

public class MainUmumiPraktika {

	public static void main(String[] args) {

		Computer[] computers = new Computer[4];
		computers[0] = new Computer(8, 500, "HP");
		computers[1] = new Computer(24, 250, "ACER");
		computers[2] = new Computer(12, 750, "DELL");
		computers[3] = new Computer(16, 120, "TOSHIBA");

		ArrayPrinter printer = new ArrayPrinter();
		printer.print(computers);

		ArraySorter sorter = new ArraySorter();
		sorter.sort(computers);
		printer.print(computers);
	}

}
