package com.CoralieP98.sheets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SheetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SheetsApplication.class, args);
	}

}
