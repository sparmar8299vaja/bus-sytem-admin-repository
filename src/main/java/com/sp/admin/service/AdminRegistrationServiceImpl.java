package com.sp.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.commons.SMSSenderCommons;
import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.repo.AdminRegistrationRepository;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {

	@Resource
	private AdminRegistrationRepository registrationRepository;
	
	@Resource
	private SMSSenderCommons sender;

	@Override
	public String registerAdmin(final AdminRegistrationDto registrationDto) {
		Integer adminId = 0;
		try {
			adminId = registrationRepository.save(new AdminRegistrationEntity().convertDtoToEntity(registrationDto))
					.getId();
			//sender.sendMessage(registrationDto.getMobileNo(), "congratulations you registred successfully on mybus");
		} catch (Exception e) {
			throw new ConstraintsVoilationException("problem while register admin (may be admin name or mobile no already exist)", e);
		}
		return adminId != null ? "admin registered successfully" : "admin not registered successfully";
	}

	@Override
	public List<AdminRegistrationDto> getAllAdmin() {
		List<AdminRegistrationDto> dtos = new ArrayList<>();
		List<AdminRegistrationEntity> adminList = registrationRepository.findAll();
		if (!adminList.isEmpty()) {
			adminList.forEach(adminEntity -> dtos.add(new AdminRegistrationEntity().convertEntityToDto(adminEntity)));
		}
		return dtos;
	}

	@Override
	public AdminRegistrationDto getAdminById(final int id) {
		Optional<AdminRegistrationEntity> adminEntity = registrationRepository.findById(id);
		return adminEntity.isPresent() ? new AdminRegistrationEntity().convertEntityToDto(adminEntity.get()) : null;
	}
}
