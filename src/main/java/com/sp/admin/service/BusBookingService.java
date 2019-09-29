package com.sp.admin.service;

import java.util.List;

import com.sp.admin.dtos.BusBookingRequestDto;
import com.sp.admin.dtos.BusRegistrationDto;

public interface BusBookingService {
      
	public List<BusRegistrationDto> getBusByFromLocToLocAndDate(final BusBookingRequestDto responseDto);
}
