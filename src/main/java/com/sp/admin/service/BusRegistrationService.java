package com.sp.admin.service;

import java.util.List;

import com.sp.admin.dtos.BusRegistrationDto;

public interface BusRegistrationService {
   
	public String addBusInfo(final BusRegistrationDto registrationDto);
	public List<BusRegistrationDto> getAllBusInfo();
}
