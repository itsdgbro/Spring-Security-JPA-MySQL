package com.mysqlsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJpaMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaMySqlApplication.class, args);
		System.out.println("Spring Security JPA MySQL");
	}

}
