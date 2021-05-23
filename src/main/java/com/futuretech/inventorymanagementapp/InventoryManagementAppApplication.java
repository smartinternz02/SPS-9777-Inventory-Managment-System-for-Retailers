package com.futuretech.inventorymanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
//@ComponentScan("com.futuretech.inventorymanagementapp.UserRepository")

public class InventoryManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementAppApplication.class, args);
	}

}
