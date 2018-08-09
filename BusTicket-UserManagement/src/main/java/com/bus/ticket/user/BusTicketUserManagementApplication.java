package com.bus.ticket.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses={UserController.class,UserService.class})
public class BusTicketUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketUserManagementApplication.class, args);
	}
}
