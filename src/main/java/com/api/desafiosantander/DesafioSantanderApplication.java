package com.api.desafiosantander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class DesafioSantanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSantanderApplication.class, args);
	}

}
