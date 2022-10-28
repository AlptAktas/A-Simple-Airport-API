package com.finartz.case_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.finartz.case_app.*" })
public class CaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseAppApplication.class, args);
	}

}
