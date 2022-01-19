package com.sp.admin.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TemplateCommons {
     
	private TemplateCommons() {
		super();
	}
	
	@Bean
	public static RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
