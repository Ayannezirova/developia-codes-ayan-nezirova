package az.developia.student.springdemo;

import org.springframework.stereotype.Component;

@Component

public class Employee {

	Integer id;
	String name;
	String surname;
	double salary;
	Integer phone;

	public Employee() {
		id = 2341;
		name = "Tural";
		surname = "Quliyev";
		salary = 1200;
		phone = 055;

	}

	public void printInfo() {
		Employee e = new Employee();
		System.out.println(e.id);
		System.out.println(e.name);
		System.out.println(e.surname);
		System.out.println(e.salary);
		System.out.println(e.phone);
	}
}
