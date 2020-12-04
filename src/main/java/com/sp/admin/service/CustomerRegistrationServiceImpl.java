package com.sp.admin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sp.admin.commons.SMSSenderCommons;
import com.sp.admin.dtos.CustomerRegistrationDto;
import com.sp.admin.dtos.UserRegistrationDto;
import com.sp.admin.entity.CustomerRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.CustomerRegistrationRepository;

@Service
@Qualifier(value = "custservice")
public class CustomerRegistrationServiceImpl implements UserRegistrationService {
	
	@Resource
	private CustomerRegistrationRepository registrationRepository;

	@Resource
	private EncryptDecryptService encryptDecryptService;

	@Override
	public String registerUser(final UserRegistrationDto registrationDto) {
		Integer custId = null;
		try {
			custId = registrationRepository
					.save(CustomerRegistrationEntity.convertDtoToEntity(new CustomerRegistrationDto.CustomerRegistrationDtoBuilder()
							.setMobileNo(registrationDto.getMobileNo()).setName(registrationDto.getName())
							.setPassword(encryptDecryptService.encrypt(registrationDto.getPassword(),
									registrationDto.getName()))
							.setMailId(registrationDto.getMailId()).setGender(registrationDto.getGender())
							.build()))
					.getId();
			
			  SMSSenderCommons.sendMessage(registrationDto.getMobileNo(),
			  "congratulations you registred successfully on mybus");
			 
		} catch (Exception e) {
			throw new ConstraintsVoilationException(
					"problem while register customer (may be customer name or mobile no already exist)", e);
		}
		return "customer registered successfully having id " + custId;
	}

	@Override
	public List<UserRegistrationDto> getAllUser() {
		List<CustomerRegistrationEntity> custList = registrationRepository.findAll();
		if (custList.isEmpty()) {
			throw new DataNotFoundException("Empty Data Set");
		}
		return custList.stream().map(CustomerRegistrationEntity::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public CustomerRegistrationDto getUserById(final int id) {
		Optional<CustomerRegistrationEntity> custEntity = registrationRepository.findById(id);
		if (!custEntity.isPresent()) {
			throw new DataNotFoundException("required id based customer not present in data base");
		}
		return CustomerRegistrationEntity.convertEntityToDto(custEntity.get());
	}

	@Override
	public String forgotPassword(final String userName) {
		Optional<CustomerRegistrationEntity> custEntity = registrationRepository.findByName(userName);
		if (!custEntity.isPresent()) {
			throw new DataNotFoundException("user name does not exist");
		}
		CustomerRegistrationEntity custRegistrationEntity = custEntity.get();

		
		  SMSSenderCommons.sendMessage(custRegistrationEntity.getMobileNo(), "hi " +
		  custRegistrationEntity.getName() + " your password is " +
		  encryptDecryptService .decrypt(custRegistrationEntity.getPassword(),
		  custRegistrationEntity.getName()));
		 

		return "password send on your registered mobile number via sms";
	}
}
