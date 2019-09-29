package com.sp.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_REG")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserRegistrationEntity {

	@Id
	@GenericGenerator(name = "USER_REG_GEN", strategy = "com.sp.admin.generator.UserIdGenerator")
	@GeneratedValue(generator = "USER_REG_GEN")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "password")
	private String password;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "MAIL_ID")
    private String mailId;
    
	public UserRegistrationEntity() {
		super();
	}

	public UserRegistrationEntity(final UserRegistrationEntityBuilder<?> builder) {
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

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public String getMailId() {
		return mailId;
	}

	public static class UserRegistrationEntityBuilder<T extends UserRegistrationEntityBuilder<T>> {
		private String name;
		private String mobileNo;
		private String password;
		private String gender;
	    private String mailId;

		public T setName(final String name) {
			this.name = name;
			return (T)this;
		}

		public T setMobileNo(final String mobileNo) {
			this.mobileNo = mobileNo;
			return (T)this;
		}

		public T setPassword(final String password) {
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
		
		public UserRegistrationEntity build() {
			return new UserRegistrationEntity(this);
		}
	}
	
	//this gettter setter methods used for testing only
		public void setId(Integer id) {
			this.id = id;
		}
}
