package com.sp.admin.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sp.admin.exceptions.InputValidationFailedException;

public class BusRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Bad Request Bus No Must Not Be Null")
	@NotBlank(message = "Bad Request Bus No Must Not Be Empty")
	private String busNo;
	@NotNull(message = "Bad Request Bus Brand Name Must Not Be Null")
	@NotBlank(message = "Bad Request Bus Brand Name Must Not Be Empty")
	private String brandName;
	@NotNull(message = "Bad Request Start Location Must Not Be Null")
	@NotBlank(message = "Bad Request Start Location Must Not Be Empty")
	private String fromLocation;
	@NotNull(message = "Bad Request To Location Must Not Be Null")
	@NotBlank(message = "Bad Request To Location Must Not Be Empty")
	private String toLocation;
	@NotNull(message = "Bad Request No Of Seat Must Not Be Null")
	private int noOfSeat;
	@NotNull(message = "Bad Request Type Of Seat Must Not Be Null")
	@NotBlank(message = "Bad Request Type Of Seat Must Not Be Empty")
	private String typeOfSeat;
	@NotNull(message = "Bad Request Type Of Bus Must Not Be Null")
	@NotBlank(message = "Bad Request Type Of Bus Must Not Be Empty")
	private String typeOfBus;
	@NotNull(message = "Bad Request Driver Name Must Not Be Null")
	@NotBlank(message = "Bad Request Driver Name Must Not Be Empty")
	private String driverName;
	@NotNull(message = "Bad Request Driver Mobile No Must Not Be Null")
	@NotBlank(message = "Bad Request Driver Mobile No Must Not Be Empty")
	private String driverMobileNo;
	@NotNull(message = "Bad Request Brand Mobile No Must Not Be Null")
	@NotBlank(message = "Bad Request Brand Mobile No Must Not Be Empty")
	private String brandMobileNo;
	@NotNull(message = "Bad Request Date Of Leave Must Not Be Null")
	private Date dateOfLeave;
	@NotNull(message = "Bad Request Date Of Reach Must Not Be Null")
	private Date dateOfReach;
	@NotNull(message = "Bad Request Brand MailId Must Not Be Null")
	@NotBlank(message = "Bad Request Brand MailId Must Not Be Empty")
	private String brandMailId;
	@NotNull(message = "Bad Request Fare Must Not Be Null")
	private Integer fare; 
	@NotNull(message = "Bad Request Dropping Point List Must Not Be Null")
	private Set<@NotNull(message = "Bad Request Dropping Point Must Not Be Null") DroppingPointDto> droppingPointDtos;
	@NotNull(message = "Bad Request BoardingPoin Point List Must Not Be Null")
	private Set<@NotNull(message = "Bad Request BoardingPoin Point Must Not Be Null") BoardingPointDto> boardingPointDtos;
	
	public BusRegistrationDto() {
		super();
	}
	
	public BusRegistrationDto(final BusRegistrationDtoBuilder builder) {
		this.busNo = builder.busNo;
		this.brandName = builder.brandName;
		this.fromLocation = builder.fromLocation;
		this.toLocation = builder.toLocation;
		this.noOfSeat = builder.noOfSeat;
		this.typeOfBus = builder.typeOfBus;
		this.typeOfSeat = builder.typeOfSeat;
		this.driverName = builder.driverName;
		this.driverMobileNo = builder.driverMobileNo;
		this.brandMobileNo = builder.brandMobileNo;
		this.dateOfLeave = builder.dateOfLeave;
		this.dateOfReach = builder.dateOfReach;
		this.brandMailId = builder.brandMailId;
		this.fare = builder.fare;
		this.droppingPointDtos = builder.droppingPointDtos;
		this.boardingPointDtos = builder.boardingPointDtos;
	}
	

	public String getBusNo() {
		return busNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public String getTypeOfSeat() {
		return typeOfSeat;
	}

	public String getTypeOfBus() {
		return typeOfBus;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getDriverMobileNo() {
		return driverMobileNo;
	}

	public String getBrandMobileNo() {
		return brandMobileNo;
	}

	public Date getDateOfLeave() {
		return dateOfLeave;
	}

	public Date getDateOfReach() {
		if( this.dateOfLeave.equals(this.dateOfReach)) {
			throw new InputValidationFailedException("leave and reach date or time must not be same");
		}
		return dateOfReach;
	}

	public String getBrandMailId() {
		if(!this.brandMailId.contains("@")) {
			throw new InputValidationFailedException("email id must contains @");
		}
		return brandMailId;
	}

	public int getFare() {
		return fare;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<DroppingPointDto> getDroppingPointDtos() {
		return droppingPointDtos;
	}

	public Set<BoardingPointDto> getBoardingPointDtos() {
		return boardingPointDtos;
	}

	public static class BusRegistrationDtoBuilder{
		private String busNo;
		private String brandName;
		private String fromLocation;
		private String toLocation;
		private int noOfSeat;
		private String typeOfSeat;
		private String typeOfBus;
		private String driverName;
		private String driverMobileNo;
		private String brandMobileNo;
		private Date dateOfLeave;
		private Date dateOfReach;
		private String brandMailId;
		private int fare;
		private Set<DroppingPointDto> droppingPointDtos;
		private Set<BoardingPointDto> boardingPointDtos;
		
		public BusRegistrationDtoBuilder setBusNo(String busNo) {
			this.busNo = busNo;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandName(String brandName) {
			this.brandName = brandName;
			return this;
		}
		public BusRegistrationDtoBuilder setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
			return this;
		}
		public BusRegistrationDtoBuilder setToLocation(String toLocation) {
			this.toLocation = toLocation;
			return this;
		}
		public BusRegistrationDtoBuilder setNoOfSeat(int noOfSeat) {
			this.noOfSeat = noOfSeat;
			return this;
		}
		public BusRegistrationDtoBuilder setTypeOfSeat(String typeOfSeat) {
			this.typeOfSeat = typeOfSeat;
			return this;
		}
		public BusRegistrationDtoBuilder setTypeOfBus(String typeOfBus) {
			this.typeOfBus = typeOfBus;
			return this;
		}
		public BusRegistrationDtoBuilder setDriverName(String driverName) {
			this.driverName = driverName;
			return this;
		}
		public BusRegistrationDtoBuilder setDriverMobileNo(String driverMobileNo) {
			this.driverMobileNo = driverMobileNo;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandMobileNo(String brandMobileNo) {
			this.brandMobileNo = brandMobileNo;
			return this;
		}
		public BusRegistrationDtoBuilder setDateOfLeave(Date dateOfLeave) {
			this.dateOfLeave = dateOfLeave;
			return this;
		}
		public BusRegistrationDtoBuilder setDateOfReach(Date dateOfReach) {
			this.dateOfReach = dateOfReach;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandMailId(String brandMailId) {
			this.brandMailId = brandMailId;
			return this;
		}
		public BusRegistrationDtoBuilder setFare(int fare) {
			this.fare = fare;
			return this;
		}
		
		public BusRegistrationDtoBuilder setDroppingPointDtos(Set<DroppingPointDto> droppingPointDtos) {
			this.droppingPointDtos = droppingPointDtos;
			return this;
		}
		public BusRegistrationDtoBuilder setBoardingPointDtos(Set<BoardingPointDto> boardingPointDtos) {
			this.boardingPointDtos = boardingPointDtos;
			return this;
		}
		public BusRegistrationDto build() {
			return new BusRegistrationDto(this);
		}
	}
}
