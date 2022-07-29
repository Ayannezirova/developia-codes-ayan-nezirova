package az.developia.student.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public class Computer {

	String brand;
	int speed;

	public Computer() {
		
		brand = "asus";
		speed = 12314;
	
	}

}
