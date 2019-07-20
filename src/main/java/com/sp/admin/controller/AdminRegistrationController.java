package com.sp.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.service.AdminRegistrationService;

@RestController
public class AdminRegistrationController {

	@Resource
	private AdminRegistrationService registrationService;

	@PostMapping(value = "/register")
	public String registerAdmin(@Valid @RequestBody final AdminRegistrationDto registrationDto) {
		return registrationService.registerAdmin(registrationDto);
	}

	@GetMapping(value = "/show")
	public List<AdminRegistrationDto> showAllAdmin() {
		return registrationService.getAllAdmin();
	}

	@GetMapping(value = "/show/{id}")
	public AdminRegistrationDto showSingleAdmin(@PathVariable final int id) {
		return registrationService.getAdminById(id);
	}
}
