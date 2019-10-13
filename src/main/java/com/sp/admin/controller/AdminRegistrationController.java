package com.sp.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.service.AdminRegistrationService;

@RestController
@RequestMapping(value = "/registration/v1")
public class AdminRegistrationController {

	@Resource
	private AdminRegistrationService registrationService;

	@PostMapping(value = "/registeradmin")
	public String registerAdmin(@Valid @RequestBody final AdminRegistrationDto registrationDto) {
		return registrationService.registerAdmin(registrationDto);
	}
      
	@GetMapping(value = "/showadminlist")
	public List<AdminRegistrationDto> showAllAdmin() {
		return registrationService.getAllAdmin();
	}

	@GetMapping(value = "/showadmin/{id}")
	public AdminRegistrationDto showSingleAdmin(@PathVariable final int id) {
		return registrationService.getAdminById(id);
	}
	
	@GetMapping(value = "/forgot_password/{name}")
	public String forgotPassword(@PathVariable final String name) {
		return registrationService.forgotPassword(name);
	}
}
