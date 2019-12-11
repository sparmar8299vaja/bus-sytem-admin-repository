package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRegistrationDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private int id;
	@NotNull(message = "Bad Request Name Must Not Be Null")
	@NotBlank(message = "Bad Request Name Must Not Be Empty")
	private String name;
	@NotNull(message = "Bad Request Mobile Number Must Not Be Null")
	@NotBlank(message = "Bad Request Mobile Number Must Not Be Empty")
	@Size(max = 12,min = 10,message = "Mobile Number Must Contains Minimum 10 Or Maximum 12 Digits With Contry Code")
	private String mobileNo;
	@NotNull(message = "Bad Request Password Must Not Be Null")
	@NotBlank(message = "Bad Request Password Must Not Be Empty")
	@Size(max = 10,min = 8,message = "Password Must Contains Maximum 10 Or Minimum 8 Characters")
	private String password;
	@NotNull(message = "Bad Request gender Must Not Be Null")
	@NotBlank(message = "Bad Request gender Must Not Be Empty")
	private String gender;
	@NotNull(message = "Bad Request mailId Must Not Be Null")
	@NotBlank(message = "Bad Request mailId Must Not Be Empty")
	private String mailId;
    
	public UserRegistrationDto() {
		super();
	}
	
	public UserRegistrationDto(final UserRegDtoBuilder<?> builder) {
		this.name = builder.name;
		this.mobileNo = builder.mobileNo;
		this.password = builder.password;
		this.gender = builder.gender;
		this.mailId = builder.mailId;
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

	public String getGender() {
		return gender;
	}

	public String getMailId() {
		return mailId;
	}

	public static class UserRegDtoBuilder<T extends UserRegDtoBuilder<T>> {

		private String name;
		private String mobileNo;
		private String password;
		private String gender;
		private String mailId;

		public T setName(String name) {
			this.name = name;
			return (T)this;
		}

		public T setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
			return (T)this;
		}

		public T setPassword(String password) {
			this.password = password;
			return (T)this;
		}

		public T setGender(String gender) {
			this.gender = gender;
			return (T)this;
		}

		public T setMailId(String mailId) {
			this.mailId = mailId;
			return (T)this;
		}

		public UserRegistrationDto build() {
			return new UserRegistrationDto(this);
		}
	}

	//this gettter setter methods used for testing only
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
