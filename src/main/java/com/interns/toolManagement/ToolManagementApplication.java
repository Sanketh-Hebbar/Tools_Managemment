package com.interns.toolManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class ToolManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolManagementApplication.class, args);
	}

}
