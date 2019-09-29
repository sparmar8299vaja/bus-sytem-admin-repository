package com.sp.admin.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sp.admin.dtos.AdminRegistrationDto;

@Entity
@Table(name = "ADMIN_REG")
@PrimaryKeyJoinColumn(name = "ID")
public class AdminRegistrationEntity extends UserRegistrationEntity {

	public AdminRegistrationEntity() {
		
	}

	public AdminRegistrationEntity(final AdminRegEntityBuilder builder) {
		super(builder);
	}

	public static class AdminRegEntityBuilder extends UserRegistrationEntity.UserRegistrationEntityBuilder<AdminRegEntityBuilder>{
	
		public AdminRegistrationEntity build() {
			return new AdminRegistrationEntity(this);
		}
	}

	public static AdminRegistrationDto convertEntityToDto(final AdminRegistrationEntity entity) {
		return new AdminRegistrationDto.AdminRegBuilder()
				.setMobileNo(entity.getMobileNo())
				.setName(entity.getName())
				.setPassword(entity.getPassword())
				.setMailId(entity.getMailId())
				.setGender(entity.getGender())
				.build();
	}

	public static AdminRegistrationEntity convertDtoToEntity(final AdminRegistrationDto dto) {
		return new AdminRegistrationEntity.AdminRegEntityBuilder()
				.setMobileNo(
						dto.getMobileNo().startsWith("91") ? dto.getMobileNo() : "91".concat(dto.getMobileNo()))
				.setName(dto.getName())
				.setPassword(dto.getPassword())
				.setGender(dto.getGender())
				.setMailId(dto.getMailId())
				.build();
	}
}
