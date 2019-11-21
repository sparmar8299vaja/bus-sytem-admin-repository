package com.sp.admin.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
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

	@Scheduled(cron  = "0 0 0 0/15 * *")
	@Transactional
	public void clearPreviousBusListJob() {
		repository.deleteAll(repository.findAll().stream().filter(e -> 
		                              DateFormatterClass.convertStringToDate(e.getBusId().getDateOfLeave())
		                              .compareTo(DateFormatterClass.getPreviousDate(new Date())) <= 0)
				                      .collect(Collectors.toList()));
	}

	@Override
	public List<BusRegistrationDto> getBusByFromLocToLocAndDate(final BusBookingRequestDto requestDto) {
		Date date = new Date(System.currentTimeMillis());
		List<BusRegistrationEntity> listOfBusForRequiredDate = repository.findByFromLocationAndToLocationAndBusIdDateOfLeave(requestDto.getFromLocation(),
				requestDto.getToLocation(), requestDto.getLeaveDate());
		if (listOfBusForRequiredDate.isEmpty()) {
			throw new DataNotFoundException("no bus found for specified date");
		}
		listOfBusForRequiredDate = !requestDto.getLeaveDate().equals(DateFormatterClass.getFormattedDate(date))
				? listOfBusForRequiredDate
				: listOfBusForRequiredDate.stream().filter(e -> e.getLeaveTime().compareTo(DateFormatterClass.getFormattedTime(date)) > 0).collect(Collectors.toList());
		if (listOfBusForRequiredDate.isEmpty()) {
			throw new DataNotFoundException("no bus found for specified date");
		}
		return listOfBusForRequiredDate.stream().map(BusRegistrationEntity::convertEntityToDto)
				.collect(Collectors.toList());
	}

}
