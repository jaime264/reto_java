package com.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
	}

}
