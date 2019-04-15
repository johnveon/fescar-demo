package com.example.fescardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FescarDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(FescarDemo3Application.class, args);
	}

}
