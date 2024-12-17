package pl.starter.bread;

import org.springframework.boot.SpringApplication;

public class TestBreadApplication {

	public static void main(String[] args) {
		SpringApplication.from(BreadApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
