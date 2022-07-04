package ders17calismalar;

public class Computer implements Comparable<Computer> {

	public int id;
	public String model;
	public int ram;

	public Computer(int id, String model, int ram) {
		this.id = id;
		this.model = model;
		this.ram = ram;
	}

	public Computer() {

	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", model=" + model + ", ram=" + ram + "]";
	}

	public int compareTo(Computer o) {
		return this.ram - o.ram;
	}

}
