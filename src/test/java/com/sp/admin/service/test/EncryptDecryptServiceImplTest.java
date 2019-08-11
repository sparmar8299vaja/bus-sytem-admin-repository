package com.sp.admin.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.sp.admin.service.EncryptDecryptService;
import com.sp.admin.service.EncryptDecryptServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EncryptDecryptServiceImplTest {
  
	private static final String PASSWORD = "suresh";
	private static final String USERNAME = "abc1234";
	private static final String ENCRYTED_PASSWORD = "aP1yzqZmUk6ES0mgdksmYQ==";
	
	@InjectMocks
	private EncryptDecryptService encryptDecryptService = new EncryptDecryptServiceImpl();
	
	@Test
	public void encryptTest() {
		assertEquals(ENCRYTED_PASSWORD,encryptDecryptService.encrypt(PASSWORD, USERNAME));
	}
	
	@Test
	public void decryptTest() {
		assertEquals(PASSWORD,encryptDecryptService.decrypt(ENCRYTED_PASSWORD, USERNAME));
	}
}
