package ders16Calismalar;

public class MainGenerics {

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<String>(4, 4);
		list.add("Html");
		list.add("Java");
		list.add("CSS");
		list.add("JavaScript");
		list.add("Python");

		System.out.println(list.toString());
		System.out.println("size : " + list.size());
		list.remove(1);
		System.out.println(list.toString());
		System.out.println("size : " + list.size());

	}
}
