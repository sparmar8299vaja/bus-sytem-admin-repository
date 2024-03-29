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

import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.dtos.UserRegistrationDto;
import com.sp.admin.service.UserRegistrationService;

@RestController
@RequestMapping(value = "/registration/admin/v1")
public class AdminRegistrationController{

	@Resource
	@Qualifier(value = "adminservice")
	private UserRegistrationService registrationService;

	@PostMapping(value = "/registeradmin")
	public String registerAdmin(@Valid @RequestBody final AdminRegistrationDto registrationDto) {
		return registrationService.registerUser(registrationDto);
	}
      
	@GetMapping(value = "/showadminlist")
	public List<UserRegistrationDto> showAllAdmin() {
		return registrationService.getAllUser();
	}

	@GetMapping(value = "/showadmin/{id}")
	public UserRegistrationDto showSingleAdmin(@PathVariable final int id) {
		return registrationService.getUserById(id);
	}
	
	@GetMapping(value = "/forgot_password/{name}")
	public String forgotPassword(@PathVariable final String name) {
		return registrationService.forgotPassword(name);
	}
}
