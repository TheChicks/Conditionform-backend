package com.thechicks.conditionform;

import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;



@SpringBootApplication
public class ConditionformApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConditionformApplication.class, args);
		System.out.println("Server Run");
	}
}