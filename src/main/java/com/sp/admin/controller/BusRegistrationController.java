package com.sp.admin.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.exceptions.InputValidationFailedException;
import com.sp.admin.service.BusRegistrationService;

@RestController
public class BusRegistrationController {

	@Resource
	private BusRegistrationService busRegistrationService;

	@PostMapping(value = "/addbus")
	public String registerBus(@Valid @RequestBody final BusRegistrationDto registrationDto) {
		validateBusDto(registrationDto);
		return busRegistrationService.addBusInfo(registrationDto);
	}

	@GetMapping(value = "/showbuslist")
	public List<BusRegistrationDto> showBusList() {
		return busRegistrationService.getAllBusInfo();
	}

	@GetMapping(value = "/busbyid/{busNo}")
	public BusRegistrationDto getBusById(@PathVariable final String busNo) {
		return busRegistrationService.getBusById(busNo);
	}

	private void validateBusDto(final BusRegistrationDto registrationDto) {
		Date dateOfLeave = registrationDto.getDateOfLeave();
		Date dateOfReach = registrationDto.getDateOfReach();
		Date date=new Date(System.currentTimeMillis());
		if(dateOfLeave.compareTo(date) < 0) {
			throw new InputValidationFailedException("invailid leave date");
		}
		if (dateOfLeave.equals(dateOfReach)
				|| dateOfLeave.compareTo(dateOfReach) > 0) {
			throw new InputValidationFailedException(
					"leave and reach date or time must not be same or leave date not greater than reach date");
		}
		if (!registrationDto.getBrandMailId().contains("@")) {
			throw new InputValidationFailedException("email id must contains @");
		}
	}

}
