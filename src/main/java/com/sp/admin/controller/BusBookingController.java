package com.sp.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.BusBookingRequestDto;
import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.service.BusBookingService;

@RestController
@RequestMapping(value = "/booking/v1")
public class BusBookingController {
      
	@Resource
	private BusBookingService service;
	
	@PostMapping(value = "/getBusInfo")
	public List<BusRegistrationDto> getBusInfo(@Valid @RequestBody final BusBookingRequestDto requestDto){
		return service.getBusByFromLocToLocAndDate(requestDto);
	}
}
