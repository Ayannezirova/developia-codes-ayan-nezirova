package ders_on.praktika;

public class ArrayPrinter {

	public void print(Computer[] computers) {
		for (int i = 0; i < computers.length; i++) {
			computers[i].print();

		}

	}

	public void sort(Computer[] computers, String sortType) {
		boolean swapOccured = true;

		if (computers[0].getRamSize() > computers[1].getRamSize()) {
			Computer temp = computers[0];
			computers[0] = computers[1];
			computers[1] = temp;
		}

	}

}
