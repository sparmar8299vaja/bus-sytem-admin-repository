package com.sp.admin.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sp.admin.entity.AdminRegistrationEntity;
import com.sp.admin.repo.AdminRegistrationRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	
	@Resource
	private AdminRegistrationRepository adminRegRepo;

	@Resource
	private EncryptDecryptService encryptDecryptService;
	
	@Resource
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(final String username){

		Optional<AdminRegistrationEntity> findByName = adminRegRepo.findByName(username);
		
		if(findByName.isPresent()) {
			return new User(findByName.get().getName(), passwordEncoder.encode(encryptDecryptService.decrypt(findByName.get().getPassword(), findByName.get().getName())), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}