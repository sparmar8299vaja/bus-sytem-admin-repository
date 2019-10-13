package com.sp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.admin.commons.JwtTokenUtil;
import com.sp.admin.dtos.UserAuthenticationDto;
import com.sp.admin.exceptions.UsernamePasswordInvailidException;

@RestController
@RequestMapping(value = "/authenticate/v1")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@PostMapping(value = "/createtocken")
	public String createAuthenticationToken(@RequestBody UserAuthenticationDto authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getName(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getName());

		return JwtTokenUtil.generateToken(userDetails);

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException | BadCredentialsException e) {
			throw new UsernamePasswordInvailidException("USER_DISABLED_OR_INVAILID_CREDENTIAL", e);
		}
	}
}
