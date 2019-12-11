package com.sp.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.entity.BusRegistrationEntityId;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.BusRegistrationRepository;

@Service
public class BusRegistrationServiceImpl implements BusRegistrationService {

	@Resource
	private BusRegistrationRepository busRegistrationRepository;

	@Override
	public String addBusInfo(final BusRegistrationDto registrationDto) {
		String result = null;
		BusRegistrationEntity busRegEntity = BusRegistrationEntity.convertDtoToEntity(registrationDto);
		BusRegistrationEntityId busId = busRegEntity.getBusId();
		if (busRegistrationRepository.existsByBusIdBusNoAndBusIdDateOfLeave(busId.getBusNo(), busId.getDateOfLeave()))
			throw new ConstraintsVoilationException("Bus No Already Exist");
		try {
			result = busRegistrationRepository.save(busRegEntity).getBusId().getBusNo();

			/*
			 * SMSSenderCommons.sendMessage(registrationDto.getBrandMobileNo(),
			 * "congratulations your bus addded for date" + " " +
			 * registrationDto.getDateOfLeave() + " from " +
			 * registrationDto.getFromLocation() + " to " + registrationDto.getToLocation()
			 * + " successfully on mybus ");
			 */
			 
		} catch (Exception e) {
			throw new ConstraintsVoilationException("Problem While Registring Bus Please Check Details One", e);
		}
		return "Bus Added Successfully Having No "+result;
	}

	@Override
	public List<BusRegistrationDto> getAllBusInfo() {
		List<BusRegistrationEntity> busList = busRegistrationRepository.findAll();
		if (busList.isEmpty()) {
			throw new DataNotFoundException("Empty Data Set");
		}
		return 	busList.stream().map(BusRegistrationEntity::convertEntityToDto).collect(Collectors.toList());
	}
}
