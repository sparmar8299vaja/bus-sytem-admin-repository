package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Bad Request Name Must Not Be Null")
	@NotBlank(message = "Bad Request Name Must Not Be Empty")
	private String name;
	@NotNull(message = "Bad Request Mobile Number Must Not Be Null")
	@NotBlank(message = "Bad Request Mobile Number Must Not Be Empty")
	@Size(max = 13,min = 10,message = "Mobile Number Must Contains Minimum 10 Or Maximum 13 Digits With Contry Code")
	private String mobileNo;
	@NotNull(message = "Bad Request Password Must Not Be Null")
	@NotBlank(message = "Bad Request Password Must Not Be Empty")
	@Size(max = 10,min = 8,message = "Password Must Contains Maximum 10 Or Minimum 8 Characters")
	private String password;

	public AdminRegistrationDto() {
		super();
	}
	
	public AdminRegistrationDto(final AdminRegBuilder builder) {
		this.name = builder.name;
		this.mobileNo = builder.mobileNo;
		this.password = builder.password;
	}

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public static class AdminRegBuilder {

		private String name;
		private String mobileNo;
		private String password;

		public AdminRegBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public AdminRegBuilder setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
			return this;
		}

		public AdminRegBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public AdminRegistrationDto build() {
			return new AdminRegistrationDto(this);
		}
	}
}
