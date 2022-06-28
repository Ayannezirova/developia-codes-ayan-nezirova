package ders15Calismalar;

import java.util.Arrays;

public class MainLinkedlist {

	public static void main(String[] args) {
		MyList l = new MyList();
		l.add(1);
		l.add(2);
		l.add(5);
		l.add(8);
		l.add(11);
		System.out.println(l);

	}

}

class MyList {
	Value v;

	void add(Integer i) {
		if (v == null) {
			v = new Value();
			v.i = i;
			v.v = new Value();
			return;
		}
		Value v2 = v;
		while (v2.i != null) {
			v2 = v2.v;
		}
		v2.i = i;
		v2.v = new Value();

	}

	public String toString() {
		String s = "[";
		Value v = this.v;
		while (v.i != null) {
			s += v.i + " ";
			v = v.v;
		}
		s = s.trim();
		s += "]";
		return s;
	}
}

class Value {
	Integer i;
	Value v;
}
