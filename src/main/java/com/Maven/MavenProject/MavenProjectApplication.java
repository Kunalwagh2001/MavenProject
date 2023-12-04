package com.Maven.MavenProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Maven")
public class MavenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenProjectApplication.class, args);
		System.out.println("Maven is running");
	}

}
