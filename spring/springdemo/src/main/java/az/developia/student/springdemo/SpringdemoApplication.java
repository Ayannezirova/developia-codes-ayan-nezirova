package az.developia.student.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext p = SpringApplication.run(SpringdemoApplication.class, args);
		Computer c = p.getBean(Computer.class);
		System.out.println(c.brand);
		
		Computer c2 = p.getBean(Computer.class);
		System.out.println(c2.speed);

	}

}
