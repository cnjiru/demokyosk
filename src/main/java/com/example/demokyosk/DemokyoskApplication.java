package com.example.demokyosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demokyosk" })
public class DemokyoskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemokyoskApplication.class, args);
	}

}
