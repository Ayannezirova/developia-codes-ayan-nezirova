package az.developia.student.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

<<<<<<< HEAD
import esas_paket.components.sj;

=======
import az.developia.student.springdemo.esas_paket.components.Employee;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext p = SpringApplication.run(SpringdemoApplication.class, args);

		Employee emp = p.getBean(Employee.class);
		emp.printInfo();

		ApplicationContext a = SpringApplication.run(SpringdemoApplication.class, args);
		sj s = a.getBean(sj.class);
		s.printInfo();
		

		Computer c = p.getBean(Computer.class);
		System.out.println(c.brand);
		System.out.println(c.speed);

		ApplicationContext a = SpringApplication.run(SpringdemoApplication.class, args);
		Employee emp = a.getBean(Employee.class);
		emp.printInfo();

	}

}
