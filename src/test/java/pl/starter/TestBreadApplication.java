package pl.starter;

import org.springframework.boot.SpringApplication;

public class TestBreadApplication {

	public static void main(String[] args) {
		SpringApplication.from(StarterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
