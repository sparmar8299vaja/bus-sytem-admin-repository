package com.sp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TicketBookingSystemAdminApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingSystemAdminApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(environment.getProperty("env"));
		System.out.println(environment.getProperty("test"));
	}
}
