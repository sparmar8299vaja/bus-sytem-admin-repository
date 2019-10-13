package com.sp.admin.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.commons.DateFormatterClass;
import com.sp.admin.dtos.BusBookingRequestDto;
import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.BusRegistrationRepository;

@Service
public class BusBookingServiceImpl implements BusBookingService {

	@Resource
	private BusRegistrationRepository repository;

	@Override
	public List<BusRegistrationDto> getBusByFromLocToLocAndDate(final BusBookingRequestDto requestDto) {
		List<BusRegistrationEntity> busRegistrationEntities = null;
		Date date = new Date(System.currentTimeMillis());

		busRegistrationEntities = !requestDto.getLeaveDate().equals(DateFormatterClass.getFormattedDate(date)) ?
				repository.findByFromLocationAndToLocationAndDateOfLeave(
				requestDto.getFromLocation(), requestDto.getToLocation(), requestDto.getLeaveDate()) : 
				repository.findByFromLocationAndToLocationAndDateOfLeaveAndLeaveTimeGreaterThan(
				requestDto.getFromLocation(), requestDto.getToLocation(), requestDto.getLeaveDate(),
				DateFormatterClass.getFormattedTime(date));
		if(busRegistrationEntities.isEmpty()) {
			throw new DataNotFoundException("empty data set");
		}
		return busRegistrationEntities.stream().map(BusRegistrationEntity::convertEntityToDto)
				.collect(Collectors.toList());
	}
}