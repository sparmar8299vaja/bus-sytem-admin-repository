package com.sp.admin.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.commons.SMSSenderCommons;
import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.AdminRegistrationRepository;


@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Resource
	private AdminRegistrationRepository adminRegRepo;

	@Resource
	private SMSSenderCommons smsCommons;

	@Resource
	private EncryptDecryptService encryptDecryptService;

	@Override
	public Boolean adminLogin(final String userName, final String password) {
		return adminRegRepo.findByNameAndPassword(userName, encryptDecryptService.encrypt(password, userName))
				.isPresent();
	}

	@Override
	public String forgotPassword(final String userName) {
		Optional<AdminRegistrationEntity> adminEntity = adminRegRepo.findByName(userName);
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
