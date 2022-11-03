package az.developia.springrestayaan.prod;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import az.developia.springrestayaan.db.DBConfig;

@Component
@Profile(value = "prod")
public class MyDBconfig implements DBConfig {

	@PostConstruct
	void init() {
		System.out.println("db config for prod environment");
	}

	@Override
	public void connect() {
		System.out.println("connected prod environment");
	}
}
