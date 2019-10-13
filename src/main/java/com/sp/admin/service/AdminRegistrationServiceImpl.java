package com.sp.admin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.commons.SMSSenderCommons;
import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.AdminRegistrationRepository;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {

	@Resource
	private AdminRegistrationRepository registrationRepository;

	@Resource
	private SMSSenderCommons sender;

	@Resource
	private EncryptDecryptService encryptDecryptService;

	@Override
	public String registerAdmin(final AdminRegistrationDto registrationDto) {
		Integer adminId = null;
		try {
			adminId = registrationRepository.save(AdminRegistrationEntity.convertDtoToEntity(new AdminRegistrationDto.AdminRegBuilder()
					        .setMobileNo(registrationDto.getMobileNo())
							.setName(registrationDto.getName()).setPassword(encryptDecryptService
							.encrypt(registrationDto.getPassword(), registrationDto.getName()))
							.setMailId(registrationDto.getMailId())
							.setGender(registrationDto.getGender())
							.build()))
					.getId();
			//sender.sendMessage(registrationDto.getMobileNo(), "congratulations you registred successfully on mybus");
		} catch (Exception e) {
			throw new ConstraintsVoilationException(
					"problem while register admin (may be admin name or mobile no already exist)", e);
		}
		return "admin registered successfully having id "+ adminId;
	}

	@Override
	public List<AdminRegistrationDto> getAllAdmin() {
		List<AdminRegistrationEntity> adminList = registrationRepository.findAll();
		if (adminList.isEmpty()) {
			throw new DataNotFoundException("Empty Data Set");
		}
		return adminList.stream().map(AdminRegistrationEntity::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public AdminRegistrationDto getAdminById(final int id) {
		Optional<AdminRegistrationEntity> adminEntity = registrationRepository.findById(id);
		if(!adminEntity.isPresent()) {
			throw new DataNotFoundException("required id based admin not present in data base");
		} 
		return AdminRegistrationEntity.convertEntityToDto(adminEntity.get());
	}
	
	@Override
	public String forgotPassword(final String userName) {
		Optional<AdminRegistrationEntity> adminEntity = registrationRepository.findByName(userName);
		if (!adminEntity.isPresent()) {
			throw new DataNotFoundException("user name does not exist");
		}
		AdminRegistrationEntity adminRegistrationEntity = adminEntity.get();

		/*
		 * smsCommons.sendMessage(adminRegistrationEntity.getMobileNo(), "hi " +
		 * adminRegistrationEntity.getName() + " your password is " +
		 * encryptDecryptService .decrypt(adminRegistrationEntity.getPassword(),
		 * adminRegistrationEntity.getName()));
		 */

		return "password send on your registered mobile number via sms";
	}
}
