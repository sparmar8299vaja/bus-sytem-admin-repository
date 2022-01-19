package com.sp.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.sp.admin.dtos.BusRegistrationIdDto;


@Embeddable
public class BusRegistrationEntityId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "bus_no")
	private String busNo;
	@Column(name = "date_of_leave")
	private String dateOfLeave;

	public BusRegistrationEntityId() {
		super();
	}
	
	public BusRegistrationEntityId(final BusRegistrationEntityIdBuilder builder){
		this.busNo = builder.busNo;
		this.dateOfLeave = builder.dateOfLeave;
	}
	
	public String getBusNo() {
		return busNo;
	}

	public String getDateOfLeave() {
		return dateOfLeave;
	}

	public static class BusRegistrationEntityIdBuilder{
		private String busNo;
		private String dateOfLeave;
		
		public BusRegistrationEntityIdBuilder setBusNo(final String busNo) {
			this.busNo = busNo;
			return this;
		}
		
		public BusRegistrationEntityIdBuilder setDateOfLeave(final String dateOfLeave) {
			this.dateOfLeave = dateOfLeave;
			return this;
		}
		
		public BusRegistrationEntityId build() {
			return new BusRegistrationEntityId(this);
		}

	}
	
	public static BusRegistrationEntityId convertDtoToEntity(final BusRegistrationIdDto dto) { 
		return new BusRegistrationEntityId.BusRegistrationEntityIdBuilder()
				.setBusNo(dto.getBusNo())
				.setDateOfLeave(dto.getDateOfLeave())
				.build();
	}
	
	public static BusRegistrationIdDto convertDtoToEntity(final BusRegistrationEntityId entity) { 
		return new BusRegistrationIdDto.BusRegistrationIdDtoBuilder()
				.setBusNo(entity.getBusNo())
				.setDateOfLeave(entity.getDateOfLeave())
				.build();
	}
}
