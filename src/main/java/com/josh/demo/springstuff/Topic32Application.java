package com.josh.demo.springstuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.josh"})
@SpringBootApplication
public class Topic32Application {
	//changed 
	public static void main(String[] args) {
		SpringApplication.run(Topic32Application.class, args);
	}

}
