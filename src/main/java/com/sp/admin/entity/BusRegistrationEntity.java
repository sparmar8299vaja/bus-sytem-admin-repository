package com.sp.admin.entity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sp.admin.dtos.BusRegistrationDto;

@Entity
@Table(name = "BUS_INFO")
public class BusRegistrationEntity {

	@Id
	@Column(name = "bus_no")
	private String busNo;
	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "from_loc")
	private String fromLocation;
	@Column(name = "to_loc")
	private String toLocation;
	@Column(name = "no_of_seat")
	private int noOfSeat;
	@Column(name = "type_of_seat")
	private String typeOfSeat;
	@Column(name = "bus_type")
	private String typeOfBus;
	@Column(name = "driver_name")
	private String driverName;
	@Column(name = "driver_mo_no")
	private String driverMobileNo;
	@Column(name = "brand_mo_no")
	private String brandMobileNo;
	@Column(name = "date_of_leave")
	private String dateOfLeave;
	@Column(name = "date_of_reach")
	private String dateOfReach;
	@Column(name = "brand_mail_id")
	private String brandMailId;
	@Column(name = "fare")
	private int fare;
	@OneToMany(targetEntity = DroppingPointEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "fk_bus_no", referencedColumnName = "bus_no")
	private Set<DroppingPointEntity> droppingPointEntity;
	@OneToMany(targetEntity = BoardingPointEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "fk_bus_no", referencedColumnName = "bus_no")
	private Set<BoardingPointEntity> boardingPointEntity;
	@Column(name = "start_loc")
	private String startLoc;
	@Column(name = "end_loc")
	private String endLoc;
	@Column(name = "leave_time")
	private String leaveTime;
	@Column(name = "reach_time")
	private String reachTime;
	
	public BusRegistrationEntity() {
		super();
	}

	public BusRegistrationEntity(final BusRegistrationEntityBuilder builder) {
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
		this.boardingPointEntity = builder.boardingPointEntity;
		this.droppingPointEntity = builder.droppingPointEntity;
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

	public Set<DroppingPointEntity> getDroppingPointEntity() {
		return droppingPointEntity;
	}

	public Set<BoardingPointEntity> getBoardingPointEntity() {
		return boardingPointEntity;
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

	public static class BusRegistrationEntityBuilder {
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
		private Set<DroppingPointEntity> droppingPointEntity;
		private Set<BoardingPointEntity> boardingPointEntity;
		private String startLoc;
		private String endLoc;
		private String leaveTime;
		private String reachTime;

		public BusRegistrationEntityBuilder setBusNo(final String busNo) {
			this.busNo = busNo;
			return this;
		}

		public BusRegistrationEntityBuilder setBrandName(final String brandName) {
			this.brandName = brandName;
			return this;
		}

		public BusRegistrationEntityBuilder setFromLocation(final String fromLocation) {
			this.fromLocation = fromLocation;
			return this;
		}

		public BusRegistrationEntityBuilder setToLocation(final String toLocation) {
			this.toLocation = toLocation;
			return this;
		}

		public BusRegistrationEntityBuilder setNoOfSeat(final int noOfSeat) {
			this.noOfSeat = noOfSeat;
			return this;
		}

		public BusRegistrationEntityBuilder setTypeOfSeat(final String typeOfSeat) {
			this.typeOfSeat = typeOfSeat;
			return this;
		}

		public BusRegistrationEntityBuilder setTypeOfBus(final String typeOfBus) {
			this.typeOfBus = typeOfBus;
			return this;
		}

		public BusRegistrationEntityBuilder setDriverName(final String driverName) {
			this.driverName = driverName;
			return this;
		}

		public BusRegistrationEntityBuilder setDriverMobileNo(final String driverMobileNo) {
			this.driverMobileNo = driverMobileNo;
			return this;
		}

		public BusRegistrationEntityBuilder setBrandMobileNo(final String brandMobileNo) {
			this.brandMobileNo = brandMobileNo;
			return this;
		}

		public BusRegistrationEntityBuilder setDateOfLeave(final String dateOfLeave) {
			this.dateOfLeave = dateOfLeave;
			return this;
		}

		public BusRegistrationEntityBuilder setDateOfReach(final String dateOfReach) {
			this.dateOfReach = dateOfReach;
			return this;
		}

		public BusRegistrationEntityBuilder setBrandMailId(final String brandMailId) {
			this.brandMailId = brandMailId;
			return this;
		}

		public BusRegistrationEntityBuilder setFare(final int fare) {
			this.fare = fare;
			return this;
		}

		public BusRegistrationEntityBuilder setDroppingPointEntity(final Set<DroppingPointEntity> droppingPointEntity) {
			this.droppingPointEntity = droppingPointEntity;
			return this;
		}

		public BusRegistrationEntityBuilder setBoardingPointEntity(final Set<BoardingPointEntity> boardingPointEntity) {
			this.boardingPointEntity = boardingPointEntity;
			return this;
		}

		public BusRegistrationEntityBuilder setStartLoc(String startLoc) {
			this.startLoc = startLoc;
			return this;
		}

		public BusRegistrationEntityBuilder setEndLoc(String endLoc) {
			this.endLoc = endLoc;
			return this;
		}

		public BusRegistrationEntityBuilder setLeaveTime(String leaveTime) {
			this.leaveTime = leaveTime;
			return this;
		}

		public BusRegistrationEntityBuilder setReachTime(String reachTime) {
			this.reachTime = reachTime;
			return this;
		}

		public BusRegistrationEntity build() {
			return new BusRegistrationEntity(this);
		}
	}

	public static BusRegistrationEntity convertDtoToEntity(final BusRegistrationDto dto) {
		return new BusRegistrationEntity.BusRegistrationEntityBuilder()
				.setBusNo(dto.getBusNo())
				.setBrandName(dto.getBrandName())
				.setToLocation(dto.getToLocation())
				.setNoOfSeat(dto.getNoOfSeat())
				.setTypeOfSeat(dto.getTypeOfSeat())
				.setTypeOfBus(dto.getTypeOfBus())
				.setDriverName(dto.getDriverName())
				.setDriverMobileNo(dto.getDriverMobileNo().startsWith("91") ? dto.getDriverMobileNo() : "91".concat(dto.getDriverMobileNo()))
				.setBrandMobileNo(dto.getBrandMobileNo().startsWith("91") ? dto.getBrandMobileNo() : 
					                                 "91".concat(dto.getBrandMobileNo()))
				.setBrandMailId(dto.getBrandMailId())
				.setDateOfLeave(dto.getDateOfLeave())
				.setDateOfReach(dto.getDateOfReach())
				.setFare(dto.getFare())
				.setFromLocation(dto.getFromLocation())
				.setBoardingPointEntity(dto.getBoardingPointDtos().stream()
						    .map(BoardingPointEntity::converDtoToEntity).collect(Collectors.toSet()))
				.setDroppingPointEntity(dto.getDroppingPointDtos().stream()
						    .map(DroppingPointEntity::convertDtoToEntity).collect(Collectors.toSet()))
				.setEndLoc(dto.getEndLoc())
				.setStartLoc(dto.getStartLoc())
				.setLeaveTime(dto.getLeaveTime())
				.setReachTime(dto.getReachTime())
				.build();
	}
	
	public static BusRegistrationDto convertEntityToDto(final BusRegistrationEntity entity) {
		return new BusRegistrationDto.BusRegistrationDtoBuilder()
				.setBusNo(entity.getBusNo())
				.setBrandName(entity.getBrandName())
				.setToLocation(entity.getToLocation())
				.setNoOfSeat(entity.getNoOfSeat())
				.setTypeOfSeat(entity.getTypeOfSeat())
				.setTypeOfBus(entity.getTypeOfBus())
				.setDriverName(entity.getDriverName())
				.setDriverMobileNo(entity.getDriverMobileNo())
				.setBrandMobileNo(entity.getBrandMobileNo())
				.setBrandMailId(entity.getBrandMailId())
				.setDateOfLeave(entity.getDateOfLeave())
				.setDateOfReach(entity.getDateOfReach())
				.setFare(entity.getFare())
				.setFromLocation(entity.getFromLocation())
				.setBoardingPointDtos(entity.getBoardingPointEntity().stream()
						.map(BoardingPointEntity::converEntityToDto).collect(Collectors.toSet()))
				.setDroppingPointDtos(entity.getDroppingPointEntity().stream()
						.map(DroppingPointEntity::convertEntityToDto).collect(Collectors.toSet()))
				.setEndLoc(entity.getEndLoc())
				.setStartLoc(entity.getStartLoc())
				.setLeaveTime(entity.getLeaveTime())
				.setReachTime(entity.getReachTime())
				.build();
	}
}
