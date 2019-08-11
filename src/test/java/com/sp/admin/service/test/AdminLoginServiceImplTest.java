package com.sp.admin.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.AdminRegistrationRepository;
import com.sp.admin.service.AdminLoginService;
import com.sp.admin.service.AdminLoginServiceImpl;
import com.sp.admin.service.EncryptDecryptService;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class AdminLoginServiceImplTest {
	
	private static final String USERNAME = "suresh";
	private static final String PASSWORD = "abc123";
	
	@InjectMocks
    private AdminLoginService loginServiceImpl = new AdminLoginServiceImpl();
    
	@Mock
	private AdminRegistrationRepository adminRegRepo;
	
	@Mock
	private EncryptDecryptService encryptDecryptService;
	
	@Test
	public void adminLoginTest() {
		when(adminRegRepo.findByNameAndPassword(Mockito.anyString(), Mockito.anyString()))
		                         .thenReturn(Optional.of(getAdminRegEntity(USERNAME, PASSWORD)));
		when(encryptDecryptService.encrypt(Mockito.anyString(), Mockito.anyString())).thenReturn(PASSWORD);
		loginServiceImpl.adminLogin(USERNAME, PASSWORD);
		verify(adminRegRepo,times(1)).findByNameAndPassword(USERNAME, PASSWORD);
	}
	
	@Test
	public void adminLoginFailedTest() {
		when(adminRegRepo.findByNameAndPassword(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(Optional.empty());
		when(encryptDecryptService.encrypt(Mockito.anyString(), Mockito.anyString())).thenReturn(PASSWORD);
		loginServiceImpl.adminLogin(USERNAME, PASSWORD);
	    verify(adminRegRepo,times(1)).findByNameAndPassword(USERNAME, PASSWORD);
	}
	
	@Test
	public void forgotPasswordTest() {
		when(adminRegRepo.findByName(Mockito.anyString())).thenReturn(Optional.of(getAdminRegEntity(USERNAME,PASSWORD)));
		loginServiceImpl.forgotPassword(USERNAME);
		verify(adminRegRepo,times(1)).findByName(USERNAME);
	}
	
	
	@Test(expected = DataNotFoundException.class)
	public void forgotPasswordTestThrowExceptionWhenUserNotFound() {
		when(adminRegRepo.findByName(Mockito.anyString())).thenReturn(Optional.empty());
		loginServiceImpl.forgotPassword(USERNAME);
		verify(adminRegRepo,times(1)).findByName(USERNAME);
	}
	
	private AdminRegistrationEntity getAdminRegEntity(String name, String password) {
		AdminRegistrationEntity adminEntity = new AdminRegistrationEntity
				                             .AdminRegEntityBuilder()
				                             .setName(name)
				                             .setPassword(password).build();
		return adminEntity;
	}
}
