package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserAuthenticationDto implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Bad Request Name Must Not Be Null")
	@NotBlank(message = "Bad Request Name Must Not Be Empty")
	private String name;
	@NotNull(message = "Bad Request Password Must Not Be Null")
	@NotBlank(message = "Bad Request Password Must Not Be Empty")
	private String password;

	public UserAuthenticationDto() {
		super();
	}

	public UserAuthenticationDto(final UserDtoBuilder builder) {
		this.name = builder.name;
		this.password = builder.password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public static class UserDtoBuilder {

		private String name;
		private String password;

		public UserDtoBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public UserDtoBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public UserAuthenticationDto build() {
			return new UserAuthenticationDto(this);
		}
	}
}
