package com.laptrinhjavaweb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

// hàm này để chạy spring boot

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class Application {
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}

