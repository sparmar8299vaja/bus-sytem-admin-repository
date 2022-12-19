package com.sp.admin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.sp.admin.dtos.UserAuthenticationDto;

@SpringBootApplication
@EnableScheduling
public class TicketBookingSystemAdminApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingSystemAdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(environment.getProperty("env"));
		System.out.println(environment.getProperty("test"));
	}

	public void testGetAPI() {
		// PROMISE
		String url = "http://localhost:9090/authenticate/v1/createtocken";
		UserAuthenticationDto dto = new UserAuthenticationDto.UserDtoBuilder().setName("s12").setPassword("ancbdhas")
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserAuthenticationDto> entity = new HttpEntity<UserAuthenticationDto>(dto, headers);
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println(exchange.getBody());
	}
}
