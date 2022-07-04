package ders16Calismalar;

public class MainGenerics {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5, 4);
		list.add(24);
		list.add(13);
		list.add(45);
		System.out.println("list : " + list);
		System.out.println("size : " + list.size());
		

	}
}
