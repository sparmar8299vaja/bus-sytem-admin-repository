package com.sp.admin.service;

import java.util.List;

import com.sp.admin.dtos.AdminRegistrationDto;

public interface AdminRegistrationService{
    
	public String registerAdmin(final AdminRegistrationDto registrationDto);
	public List<AdminRegistrationDto> getAllAdmin();
	public AdminRegistrationDto getAdminById(final int id);
	public String forgotPassword(final String userName);
}
