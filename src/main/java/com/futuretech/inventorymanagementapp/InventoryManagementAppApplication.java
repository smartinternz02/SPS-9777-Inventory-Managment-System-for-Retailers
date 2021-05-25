package com.futuretech.inventorymanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
//@ComponentScan("com.futuretech.inventorymanagementapp.UserRepository")

public class InventoryManagementAppApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementAppApplication.class, args);
	}
	
	

}
