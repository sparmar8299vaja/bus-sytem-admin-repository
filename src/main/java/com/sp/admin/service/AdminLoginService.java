package com.sp.admin.service;

public interface AdminLoginService {

	public Boolean adminLogin(final String userName, final String password);

	public String forgotPassword(final String userName);
}
