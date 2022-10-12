package com.sp.admin.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class BusSystemClient {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
