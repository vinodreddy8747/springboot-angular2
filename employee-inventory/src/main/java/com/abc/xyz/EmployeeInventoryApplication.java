package com.abc.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
		"com.abc.xyz"})
@EnableJpaRepositories
public class EmployeeInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInventoryApplication.class, args);
	}

}
