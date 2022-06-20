package ders13calismalar;

public class hasA {

	public static void main(String[] args) {
		Car car = new Car();
		car.brand = "Ford";
		car.speed = 1000;
		car.value = 15000;
		car.dateOfProduction = 2003;
		car.color = "black";

		System.out.println("brand : " + car.brand);
		System.out.println("speed : " + car.speed);
		System.out.println("value : " + car.value);
		System.out.println("dateOfProduction : " + car.dateOfProduction);
		System.out.println("color: " + car.color);
	}

}
