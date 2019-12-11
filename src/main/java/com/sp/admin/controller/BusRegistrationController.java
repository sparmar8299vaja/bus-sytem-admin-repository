package com.sp.admin.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.commons.DateFormatterClass;
import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.dtos.SeatDto;
import com.sp.admin.exceptions.InputValidationFailedException;
import com.sp.admin.service.BusRegistrationService;

@RestController
@RequestMapping(value = "/registration/v1")
public class BusRegistrationController {

	@Resource
	private BusRegistrationService busRegistrationService;

	@PostMapping(value = "/addbus")
	public String registerBus(@Valid @RequestBody final BusRegistrationDto registrationDto) {
		validateBusDto(registrationDto);
		prepareSeatList(registrationDto);
		return busRegistrationService.addBusInfo(registrationDto);
	}

	@GetMapping(value = "/showbuslist")
	public List<BusRegistrationDto> showBusList() {
		return busRegistrationService.getAllBusInfo();
	}

	private void validateBusDto(final BusRegistrationDto registrationDto) {
		Date currentDate = new Date(System.currentTimeMillis());
		Date dateOfLeave = DateFormatterClass.getDate(registrationDto.getDateOfLeave(), registrationDto.getLeaveTime());
		Date dateOfReach = DateFormatterClass.getDate(registrationDto.getDateOfReach(), registrationDto.getReachTime());
		if(dateOfLeave.compareTo(dateOfReach)  >= 0) {
			throw new InputValidationFailedException(
					"leave and reach date or time must not be same or leave date not greater than reach date");
		}
		if (dateOfLeave.compareTo(currentDate) <= 0) {
			throw new InputValidationFailedException("leave date or time must greater than today date or time");
		}
		if (!registrationDto.getBrandMailId().contains("@")) {
			throw new InputValidationFailedException("email id must contains @");
		}
	}
	
	private void prepareSeatList(final BusRegistrationDto registrationDto) {
		for(int i=1;i<=registrationDto.getNoOfLowerSeat();i++) {
			registrationDto.getSeatDto().add(new SeatDto
					.SeatDtoBuilder()
					.setAvailable(true)
					.setSeatNo(i)
					.setSeatType("lower").build());
		}
		for(int i=registrationDto.getNoOfLowerSeat()+1;i<=registrationDto.getNoOfSeat();i++) {
			registrationDto.getSeatDto().add(new SeatDto
					.SeatDtoBuilder()
					.setAvailable(true)
					.setSeatNo(i)
					.setSeatType("upper").build());
		}
	}
}
