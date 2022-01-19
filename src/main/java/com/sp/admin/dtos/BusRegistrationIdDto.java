package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BusRegistrationIdDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Bad Request Bus No Must Not Be Null")
	@NotBlank(message = "Bad Request Bus No Must Not Be Empty")
	private String busNo;
	@NotNull(message = "Bad Request Date Of Leave Must Not Be Null")
	@NotBlank(message = "Bad Request Date Of Leave Must Not Be Empty")
	private String dateOfLeave;
	
	
	public BusRegistrationIdDto(final BusRegistrationIdDtoBuilder builder) {
		this.busNo = builder.busNo;
		this.dateOfLeave = builder.dateOfLeave;
	}

	public String getBusNo() {
		return busNo;
	}

	public String getDateOfLeave() {
		return dateOfLeave;
	}

    public static class BusRegistrationIdDtoBuilder{
    	
    	private String busNo;
    	private String dateOfLeave;
    	
		public BusRegistrationIdDtoBuilder setBusNo(final String busNo) {
			this.busNo = busNo;
			return this;
		}
		public BusRegistrationIdDtoBuilder setDateOfLeave(final String dateOfLeave) {
			this.dateOfLeave = dateOfLeave;
			return this;
        }
		
		public BusRegistrationIdDto build() {
			return new BusRegistrationIdDto(this);
		}
    }
}
