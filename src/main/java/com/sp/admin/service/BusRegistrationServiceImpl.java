package com.sp.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.commons.SMSSenderCommons;
import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.repo.BusRegistrationRepository;

@Service
public class BusRegistrationServiceImpl implements BusRegistrationService {

	@Resource
	private BusRegistrationRepository busRegistrationRepository;

	@Resource
	private SMSSenderCommons sender;

	@Override
	public String addBusInfo(final BusRegistrationDto registrationDto) {
		String result = null;
		BusRegistrationEntity convertDtoToEntity = BusRegistrationEntity.convertDtoToEntity(registrationDto);
		if (busRegistrationRepository.existsById(convertDtoToEntity.getBusNo()))
			throw new ConstraintsVoilationException("Bus No Already Exist");
		try {
			result = busRegistrationRepository.save(convertDtoToEntity).getBusNo();

			/*
			 * sender.sendMessage(registrationDto.getBrandMobileNo(),
			 * "congratulations your bus addded for date" + " " +
			 * registrationDto.getDateOfLeave() + " from " +
			 * registrationDto.getFromLocation() + " to " + registrationDto.getToLocation()
			 * + " successfully on mybus ");
			 */
		} catch (Exception e) {
			throw new ConstraintsVoilationException("Driver Mobile No Already Exist", e);
		}
		return result != null ? "Bus Added Successfully" : "Bus Not Added Successfully";
	}

	@Override
	public List<BusRegistrationDto> getAllBusInfo() {
		List<BusRegistrationDto> dtos = new ArrayList<>();
		List<BusRegistrationEntity> busList = busRegistrationRepository.findAll();
		if (!busList.isEmpty()) {
			busList.forEach(busEntity -> dtos.add(BusRegistrationEntity.convertEntityToDto(busEntity)));
		}
		return dtos;
	}

	@Override
	public BusRegistrationDto getBusById(final String busNo) {
		Optional<BusRegistrationEntity> busInfo = busRegistrationRepository.findById(busNo);
		return busInfo.isPresent() ? BusRegistrationEntity.convertEntityToDto(busInfo.get()) : null;
	}

}
