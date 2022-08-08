package ders16Calismalar;

public class MyArrayList<T> {

	public int size() {
		return index;
	}

	Object[] array;
	int index = 0;
	int length;
	int initial;

	public MyArrayList(int length, int initial) {
		this.length = length;
		this.initial = initial;
		array = new Object[length];

	}

	public void add(T j) {
		array[index] = j;
		index++;
		if (index == array.length) {
			Object[] a = new Object[array.length + length];
			for (int i = 0; i < array.length; i++) {
				a[i] = array[i];
			}
			array = a;
		}
	}

	public String toString() {
		String s = "(";
		for (int i = 0; i < index; i++) {
			if (i == index - 1) {
				s += array[i];

			} else {
				s += array[i] + ", ";
			}
		}
		s += ")";
		return s;
	}

	public void remove(int indeks) {
		if (indeks < 0) {
			return;
		}
		if (indeks > index - 1) {
			return;
		}

		for (int i = indeks; i < index - 1; i++) {
			array[i] = array[i + 1];
		}

		index--;
	}

}
