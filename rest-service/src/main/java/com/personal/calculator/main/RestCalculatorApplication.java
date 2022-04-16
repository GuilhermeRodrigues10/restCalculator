package com.personal.calculator.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.personal")
public class RestCalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestCalculatorApplication.class, args);
	}
}
