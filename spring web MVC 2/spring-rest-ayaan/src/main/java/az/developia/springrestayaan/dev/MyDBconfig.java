package az.developia.springrestayaan.dev;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import az.developia.springrestayaan.db.DBConfig;

@Component
@Profile(value = "dev")
public class MyDBconfig implements DBConfig {

	@PostConstruct
	void init() {
		System.out.println("db config for dev environment");
	}

	@Override
	public void connect() {
		System.out.println("connected dev environment");
	}
}
