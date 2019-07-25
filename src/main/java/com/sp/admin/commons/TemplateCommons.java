package com.sp.admin.commons;

import org.springframework.web.client.RestTemplate;

public class TemplateCommons {
     
	private TemplateCommons() {
		super();
	}
	
	public static RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
