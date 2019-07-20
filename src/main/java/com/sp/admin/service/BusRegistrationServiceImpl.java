package com.sp.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.repo.BusRegistrationRepository;

@Service
public class BusRegistrationServiceImpl implements BusRegistrationService {

	@Resource
	private BusRegistrationRepository busRegistrationRepository;

	@Override
	public String addBusInfo(final BusRegistrationDto registrationDto) {
		String result = null;
		BusRegistrationEntity convertDtoToEntity = new BusRegistrationEntity().convertDtoToEntity(registrationDto);
		if (busRegistrationRepository.existsById(convertDtoToEntity.getBusNo()))
			throw new ConstraintsVoilationException("Bus No Already Exist");
		try {
			result = busRegistrationRepository.save(convertDtoToEntity).getBusNo();
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
			busList.forEach(busEntity -> dtos.add(new BusRegistrationEntity().convertEntityToDto(busEntity)));
		}
		return dtos;
	}
}
