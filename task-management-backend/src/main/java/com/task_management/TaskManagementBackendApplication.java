package com.task_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementBackendApplication.class, args);
		System.out.println("It is Working...");
	}

}
