package com.example.fescardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FescarDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(FescarDemo1Application.class, args);
	}

}
