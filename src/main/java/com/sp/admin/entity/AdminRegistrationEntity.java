package com.sp.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sp.admin.dtos.AdminRegistrationDto;

@Entity
@Table(name = "ADMIN_REG")
public class AdminRegistrationEntity {

	@Id
	@GenericGenerator(name = "ADMIN_REG_GEN", strategy = "com.sp.admin.generator.AdminIdGenerator")
	@GeneratedValue(generator = "ADMIN_REG_GEN")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "password")
	private String password;

	public AdminRegistrationEntity() {

	}

	public AdminRegistrationEntity(final AdminRegEntityBuilder builder) {
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

	public int getId() {
		return id;
	}

	public static class AdminRegEntityBuilder {
		private String name;
		private String mobileNo;
		private String password;

		public AdminRegEntityBuilder setName(final String name) {
			this.name = name;
			return this;
		}

		public AdminRegEntityBuilder setMobileNo(final String mobileNo) {
			this.mobileNo = mobileNo;
			return this;
		}

		public AdminRegEntityBuilder setPassword(final String password) {
			this.password = password;
			return this;
		}

		public AdminRegistrationEntity build() {
			return new AdminRegistrationEntity(this);
		}
	}

	public AdminRegistrationDto convertEntityToDto(final AdminRegistrationEntity entity) {
		return new AdminRegistrationDto.AdminRegBuilder()
				.setMobileNo(entity.getMobileNo())
				.setName(entity.getName())
				.setPassword(entity.getPassword())
				.build();
	}

	public AdminRegistrationEntity convertDtoToEntity(final AdminRegistrationDto dto) {
		return new AdminRegistrationEntity.AdminRegEntityBuilder()
				.setMobileNo(
						dto.getMobileNo().startsWith("+91") ? dto.getMobileNo() : "+91".concat(dto.getMobileNo()))
				.setName(dto.getName())
				.setPassword(dto.getPassword())
				.build();

	}
}
