package com.sp.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.CustomerRegistrationDto;
import com.sp.admin.dtos.UserRegistrationDto;
import com.sp.admin.service.UserRegistrationService;

@RestController
@RequestMapping(value = "/registration/cust/v1")
public class CustomerRegistrationController {

	@Resource
	@Qualifier(value = "custservice")
	private UserRegistrationService registrationService;

	@PostMapping(value = "/registercust")
	public String registerCustomer(@Valid @RequestBody final CustomerRegistrationDto registrationDto) {
		return registrationService.registerUser(registrationDto);
	}
      
	@GetMapping(value = "/showcustlist")
	public List<UserRegistrationDto> showAllCustomer() {
		return registrationService.getAllUser();
	}

	@GetMapping(value = "/showcust/{id}")
	public UserRegistrationDto showSingleAdmin(@PathVariable final int id) {
		return registrationService.getUserById(id);
	}
	
	@GetMapping(value = "/forgot_password/{name}")
	public String forgotPassword(@PathVariable final String name) {
		return registrationService.forgotPassword(name);
	}
}
