package pl.ryestarter;

import org.springframework.boot.SpringApplication;

public class TestBreadApplication {

	public static void main(String[] args) {
		SpringApplication.from(RyeStarterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
