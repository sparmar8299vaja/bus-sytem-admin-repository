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
import com.sp.admin.service.EncryptDecryptService;

@RestController
public class AdminRegistrationController {

	@Resource
	private AdminRegistrationService registrationService;
	
	@Resource
	private EncryptDecryptService encryptDecryptService;

	@PostMapping(value = "/register")
	public String registerAdmin(@Valid @RequestBody final AdminRegistrationDto registrationDto) {
		return registrationService.registerAdmin(new AdminRegistrationDto.AdminRegBuilder()
                .setPassword(encryptDecryptService.encrypt(registrationDto.getPassword(), registrationDto.getName()))
                .setMobileNo(registrationDto.getMobileNo())
                .setName(registrationDto.getName())
                .build());
	}

	@GetMapping(value = "/showadminlist")
	public List<AdminRegistrationDto> showAllAdmin() {
		return registrationService.getAllAdmin();
	}

	@GetMapping(value = "/showadmin/{id}")
	public AdminRegistrationDto showSingleAdmin(@PathVariable final int id) {
		return registrationService.getAdminById(id);
	}
}
