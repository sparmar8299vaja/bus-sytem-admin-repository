package com.sp.admin.service;

import java.util.List;

import com.sp.admin.dtos.BusRegistrationDto;

public interface BusRegistrationService {
   
	public String addBusInfo(final BusRegistrationDto registrationDto);
	public List<BusRegistrationDto> getAllBusInfo();
	public String updateBusInfo(final BusRegistrationDto dto);
	public BusRegistrationDto getBusByNo(final String busNo);
}
