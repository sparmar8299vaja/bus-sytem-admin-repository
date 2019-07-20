package com.sp.admin.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.UserDto;
import com.sp.admin.service.AdminLoginService;

@RestController
public class AdminLoginController {
    
	@Resource
	private AdminLoginService adminLoginService; 
	
	@PostMapping(value = "/login")
	public Boolean logIn(@Valid @RequestBody final UserDto user) {
		return adminLoginService.adminLogin(user.getName(), user.getPassword());
	}
}
