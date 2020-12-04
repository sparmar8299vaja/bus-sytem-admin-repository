package com.sp.admin.service;

import java.util.List;

import com.sp.admin.dtos.UserRegistrationDto;

public interface UserRegistrationService{
    
	public String registerUser(final UserRegistrationDto registrationDto);
	public List<UserRegistrationDto> getAllUser();
	public UserRegistrationDto getUserById(final int id);
	public String forgotPassword(final String userName);
}
