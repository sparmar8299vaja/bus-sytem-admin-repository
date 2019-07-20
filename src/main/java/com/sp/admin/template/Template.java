package com.sp.admin.template;

import org.springframework.web.client.RestTemplate;

public class Template {
     
	private Template() {
		
	}
	
	public static RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
