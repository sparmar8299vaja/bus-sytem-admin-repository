package com.sp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TicketBookingSystemAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingSystemAdminApplication.class, args);
	}
}
