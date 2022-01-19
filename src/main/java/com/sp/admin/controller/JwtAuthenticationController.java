package com.sp.admin.controller;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.commons.JwtTokenUtil;
import com.sp.admin.dtos.UserAuthenticationDto;
import com.sp.admin.exceptions.InvailidDataException;

@RestController
@RequestMapping(value = "/authenticate/v1")
public class JwtAuthenticationController {

	@Resource
	private AuthenticationManager authenticationManager;

	@Resource
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@Resource
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/createtocken")
	public String createAuthenticationToken(@RequestBody final UserAuthenticationDto authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getName(), authenticationRequest.getPassword());

		return jwtTokenUtil.generateToken(jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getName()));

	}

	private void authenticate(final String username, final String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException | BadCredentialsException e) {
			throw new InvailidDataException("USER_DISABLED_OR_INVAILID_CREDENTIAL", e);
		}
	}
}
