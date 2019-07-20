package com.sp.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.service.BusRegistrationService;

@RestController
public class BusRegistrationController {

	@Resource
	private BusRegistrationService busRegistrationService;
	

	@PostMapping(value = "/addbus")
	public String registerAdmin(@Valid @RequestBody final BusRegistrationDto registrationDto) {
		return busRegistrationService.addBusInfo(registrationDto);
	}
	
	@GetMapping(value = "/showbuslist")
	public List<BusRegistrationDto> showBusList(){
		return busRegistrationService.getAllBusInfo();
	}
}
