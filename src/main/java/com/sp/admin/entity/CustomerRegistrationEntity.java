package com.sp.admin.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sp.admin.dtos.CustomerRegistrationDto;

@Entity
@Table(name = "CUST_REG")
@PrimaryKeyJoinColumn(name = "ID")
public class CustomerRegistrationEntity extends UserRegistrationEntity {

	public CustomerRegistrationEntity() {
		super();
	}
	
	public CustomerRegistrationEntity(final CustomerRegistrationEntityBuilder builder) {
		super(builder);
	}
	
	public static class CustomerRegistrationEntityBuilder extends UserRegistrationEntity.UserRegistrationEntityBuilder<CustomerRegistrationEntityBuilder>{
		
		@Override
		public CustomerRegistrationEntity build() {
			return new CustomerRegistrationEntity(this);
		}
	}
	
	public static CustomerRegistrationEntity convertDtoToEntity(final CustomerRegistrationDto dto) {
		return new CustomerRegistrationEntity.CustomerRegistrationEntityBuilder()
				   .setGender(dto.getGender())
				   .setMailId(dto.getMailId())
				   .setMobileNo(dto.getMobileNo())
				   .setName(dto.getName())
				   .setPassword(dto.getPassword())
				   .build();
	}
	
	public static CustomerRegistrationDto convertEntityToDto(final CustomerRegistrationEntity entity) {
		return new CustomerRegistrationDto.CustomerRegistrationDtoBuilder()
				   .setGender(entity.getGender())
				   .setMailId(entity.getMailId())
				   .setMobileNo(entity.getMobileNo())
				   .setName(entity.getName())
				   .setPassword(entity.getPassword())
				   .build();
	}
}
