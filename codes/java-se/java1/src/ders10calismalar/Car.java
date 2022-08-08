package ders10calismalar;

public class Car {

	public Car(int id, String brand, int speed) {
		Car.arraySum(300, 450, 150, 200, 250);
	}

	private static void arraySum(int speed, int speed1, int speed2, int speed3, int speed4) {

	}

	public static void main(String[] args) {

		int id;
		String brand;
		int speed = 250;

		Car[] cars = new Car[5];
		cars[0] = new Car(9714, "Ford", 300);
		cars[1] = new Car(8651, "Hundai", 450);
		cars[2] = new Car(5373, "Mercedes", 150);
		cars[3] = new Car(8784, "KIA", 200);
		cars[4] = new Car(4657, "Nissan", 250);

		int speed1 = 300;
		int speed2 = 450;
		int speed3 = 150;
		int speed4 = 200;
		int sum = speed + speed1 + speed2 + speed3 + speed4;
System.out.println(sum);
	}
}
