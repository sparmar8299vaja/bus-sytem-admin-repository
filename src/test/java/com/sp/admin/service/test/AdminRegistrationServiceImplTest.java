package com.sp.admin.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sp.admin.dtos.AdminRegistrationDto;
import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.AdminRegistrationRepository;
import com.sp.admin.service.AdminRegistrationServiceImpl;
import com.sp.admin.service.EncryptDecryptService;
import com.sp.admin.service.UserRegistrationService;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class AdminRegistrationServiceImplTest {
	
	private static final int ADMIN_ID = 101;
	private static final String NAME = "suresh";
	private static final String PASSWORD = "abcd1234";
	private static final String MOBILE_NO = "8839511184";

	@InjectMocks
	private UserRegistrationService adminRegistrationService = new AdminRegistrationServiceImpl();

	@Mock
	private AdminRegistrationRepository regRepository;
	
	@Mock
	private EncryptDecryptService encDecService;

	@Test
	public void registerAdminTest() {
		//test cases
		AdminRegistrationEntity adminRegEntity = getAdminRegEntity();
		AdminRegistrationDto adminRegDto = getAdminRegDto();
		when(regRepository.save(any(AdminRegistrationEntity.class)))
		                 .thenReturn(adminRegEntity);
		when(encDecService.encrypt(Mockito.anyString(),Mockito.anyString())).thenReturn(PASSWORD);
		assertEquals("admin registered successfully having id "+ ADMIN_ID, adminRegistrationService.registerUser(adminRegDto));
	}

	@Test(expected = ConstraintsVoilationException.class)
	public void registerAdminThrowExceptionWhenAdminIdNullTest() {
		AdminRegistrationDto adminDto = new AdminRegistrationDto();
		AdminRegistrationEntity adminEntity = new AdminRegistrationEntity();
		when(regRepository.save(any(AdminRegistrationEntity.class))).thenReturn(adminEntity);
		when(encDecService.encrypt(Mockito.anyString(),Mockito.anyString())).thenReturn(PASSWORD);
		adminRegistrationService.registerUser(adminDto);
	}
	
	@Test
	public void getAllAdminTest(){
		when(regRepository.findAll()).thenReturn(Arrays.asList(getAdminRegEntity(),
				getAdminRegEntity()));
		adminRegistrationService.getAllUser();
		verify(regRepository,times(1)).findAll();
	}
	
	@Test(expected = DataNotFoundException.class)
	public void geAllAdminThrowExceptionWhenDataNotExistTest(){
		when(regRepository.findAll()).thenReturn(Collections.emptyList());
		adminRegistrationService.getAllUser();
		verify(regRepository,times(1)).findAll();
	}
	
	
	@Test
	public void getAdminByIdTest(){
		when(regRepository.findById(101)).thenReturn(Optional.of(getAdminRegEntity()));
		adminRegistrationService.getUserById(ADMIN_ID);
		verify(regRepository,times(1)).findById(ADMIN_ID);
	}
	
	@Test(expected = DataNotFoundException.class)
	public void getAdminByIdThrowExceptionWhenDataNotExistTest() {
		when(regRepository.findById(ADMIN_ID)).thenReturn(Optional.empty());
		adminRegistrationService.getUserById(ADMIN_ID);
		verify(regRepository,times(1)).findById(ADMIN_ID);
	}
	
	@Test
	public void forgotPasswordTest() {
		when(regRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(getAdminRegEntity()));
		adminRegistrationService.forgotPassword(NAME);
		verify(regRepository,times(1)).findByName(NAME);
	}
	
	
	@Test(expected = DataNotFoundException.class)
	public void forgotPasswordTestThrowExceptionWhenUserNotFound() {
		when(regRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
		adminRegistrationService.forgotPassword(NAME);
		verify(regRepository,times(1)).findByName(NAME);
	}
	
	
	private AdminRegistrationEntity getAdminRegEntity() {
		AdminRegistrationEntity adminEntity = new AdminRegistrationEntity
				                             .AdminRegEntityBuilder()
				                             .setMobileNo(MOBILE_NO)
				                             .setName(NAME)
				                             .setPassword(PASSWORD).build();
		                                     adminEntity.setId(ADMIN_ID);
		return adminEntity;
	}

	private AdminRegistrationDto getAdminRegDto() {
		AdminRegistrationDto adminDto = new AdminRegistrationDto.AdminRegBuilder()
				                     .setMobileNo(MOBILE_NO)
				                     .setName(NAME)
				                     .setPassword(PASSWORD).build();
		                              adminDto.setId(ADMIN_ID);
		return adminDto;
	}
}
