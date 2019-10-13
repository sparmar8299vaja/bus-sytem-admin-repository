package com.sp.admin.dtos;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(max = 12,min = 10,message = "Driver Mobile Number Must Contains Minimum 10 Or Maximum 12 Digits With Contry Code")
	private String driverMobileNo;
	@NotNull(message = "Bad Request Brand Mobile No Must Not Be Null")
	@NotBlank(message = "Bad Request Brand Mobile No Must Not Be Empty")
	@Size(max = 12,min = 10,message = "Brand Mobile Number Must Contains Minimum 10 Or Maximum 12 Digits With Contry Code")
	private String brandMobileNo;
	@NotNull(message = "Bad Request Date Of Leave Must Not Be Null")
	@NotBlank(message = "Bad Request Date Of Leave Must Not Be Empty")
	private String dateOfLeave;
	@NotNull(message = "Bad Request Date Of Reach Must Not Be Null")
	@NotBlank(message = "Bad Request Date Of Reach Must Not Be Empty")
	private String dateOfReach;
	@NotNull(message = "Bad Request Brand MailId Must Not Be Null")
	@NotBlank(message = "Bad Request Brand MailId Must Not Be Empty")
	private String brandMailId;
	@NotNull(message = "Bad Request Fare Must Not Be Null")
	private Integer fare; 
	@NotNull(message = "Bad Request Dropping Point List Must Not Be Null")
	private Set<@NotNull(message = "Bad Request Dropping Point Must Not Be Null") DroppingPointDto> droppingPointDtos;
	@NotNull(message = "Bad Request BoardingPoin Point List Must Not Be Null")
	private Set<@NotNull(message = "Bad Request BoardingPoin Point Must Not Be Null") BoardingPointDto> boardingPointDtos;
	@NotNull(message = "Bad Request start location Must Not Be Null")
	@NotBlank(message = "Bad Request start location Must Not Be Empty")
	private String startLoc;
	@NotNull(message = "Bad Request end location Must Not Be Null")
	@NotBlank(message = "Bad Request end location Must Not Be Empty")
	private String endLoc;
	@NotNull(message = "Bad Request start time Must Not Be Null")
	@NotBlank(message = "Bad Request start time Must Not Be Empty")
	private String leaveTime;
	@NotNull(message = "Bad Request end time Must Not Be Null")
	@NotBlank(message = "Bad Request end time Must Not Be Empty")
	private String reachTime;
	
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
		this.startLoc = builder.startLoc;
		this.endLoc = builder.endLoc;
		this.leaveTime = builder.leaveTime;
		this.reachTime = builder.reachTime;
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

	public String getDateOfLeave() {
		return dateOfLeave;
	}

	public String getDateOfReach() {
		return dateOfReach;
	}

	public String getBrandMailId() {
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

	public String getStartLoc() {
		return startLoc;
	}

	public String getEndLoc() {
		return endLoc;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public String getReachTime() {
		return reachTime;
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
		private String dateOfLeave;
		private String dateOfReach;
		private String brandMailId;
		private int fare;
		private Set<DroppingPointDto> droppingPointDtos;
		private Set<BoardingPointDto> boardingPointDtos;
		private String startLoc;
		private String endLoc;
		private String leaveTime;
		private String reachTime;
		
		public BusRegistrationDtoBuilder setBusNo(final String busNo) {
			this.busNo = busNo;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandName(final String brandName) {
			this.brandName = brandName;
			return this;
		}
		public BusRegistrationDtoBuilder setFromLocation(final String fromLocation) {
			this.fromLocation = fromLocation;
			return this;
		}
		public BusRegistrationDtoBuilder setToLocation(final String toLocation) {
			this.toLocation = toLocation;
			return this;
		}
		public BusRegistrationDtoBuilder setNoOfSeat(final int noOfSeat) {
			this.noOfSeat = noOfSeat;
			return this;
		}
		public BusRegistrationDtoBuilder setTypeOfSeat(final String typeOfSeat) {
			this.typeOfSeat = typeOfSeat;
			return this;
		}
		public BusRegistrationDtoBuilder setTypeOfBus(final String typeOfBus) {
			this.typeOfBus = typeOfBus;
			return this;
		}
		public BusRegistrationDtoBuilder setDriverName(final String driverName) {
			this.driverName = driverName;
			return this;
		}
		public BusRegistrationDtoBuilder setDriverMobileNo(final String driverMobileNo) {
			this.driverMobileNo = driverMobileNo;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandMobileNo(final String brandMobileNo) {
			this.brandMobileNo = brandMobileNo;
			return this;
		}
		public BusRegistrationDtoBuilder setDateOfLeave(final String dateOfLeave) {
			this.dateOfLeave = dateOfLeave;
			return this;
		}
		public BusRegistrationDtoBuilder setDateOfReach(final String dateOfReach) {
			this.dateOfReach = dateOfReach;
			return this;
		}
		public BusRegistrationDtoBuilder setBrandMailId(final String brandMailId) {
			this.brandMailId = brandMailId;
			return this;
		}
		public BusRegistrationDtoBuilder setFare(final int fare) {
			this.fare = fare;
			return this;
		}
		
		public BusRegistrationDtoBuilder setDroppingPointDtos(final Set<DroppingPointDto> droppingPointDtos) {
			this.droppingPointDtos = droppingPointDtos;
			return this;
		}
		public BusRegistrationDtoBuilder setBoardingPointDtos(final Set<BoardingPointDto> boardingPointDtos) {
			this.boardingPointDtos = boardingPointDtos;
			return this;
		}
		public BusRegistrationDtoBuilder setStartLoc(final String startLoc) {
			this.startLoc = startLoc;
			return this;
		}
		public BusRegistrationDtoBuilder setEndLoc(final String endLoc) {
			this.endLoc = endLoc;
			return this;
		}
		public BusRegistrationDtoBuilder setLeaveTime(final String leaveTime) {
			this.leaveTime = leaveTime;
			return this;
		}
		public BusRegistrationDtoBuilder setReachTime(final String reachTime) {
			this.reachTime = reachTime;
			return this;
		}
		public BusRegistrationDto build() {
			return new BusRegistrationDto(this);
		}
	}
}
