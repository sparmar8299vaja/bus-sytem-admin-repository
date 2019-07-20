package com.sp.admin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sp.admin.repo.AdminRegistrationRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Resource
	private AdminRegistrationRepository adminRegRepo;

	@Override
	public Boolean adminLogin(final String userName, final String password) {
		return adminRegRepo.findByNameAndPassword(userName,
				password).isPresent();
	}
}
