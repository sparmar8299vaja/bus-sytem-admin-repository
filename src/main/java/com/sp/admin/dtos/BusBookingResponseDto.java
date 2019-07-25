package com.sp.admin.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BusBookingResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brandName;
	private Date leaveDate;
	private Date reachDate;
	private int fare;
	private List<DroppingPointDto> droppingPointList;
	private List<BoardingPointDto> boardingPointList;
	
	public BusBookingResponseDto() {
		super();
	}
	
	public BusBookingResponseDto(final BusBookingDtoBuilder builder) {
		this.brandName = builder.brandName;
		this.leaveDate = builder.leaveDate;
		this.reachDate = builder.reachDate;
		this.fare = builder.fare;
		this.boardingPointList = builder.boardingPointList;
		this.droppingPointList = builder.droppingPointList;
	}

	public String getBrandName() {
		return brandName;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}
	
	public Date getReachDate() {
		return reachDate;
	}

	public int getFare() {
		return fare;
	}

	public List<DroppingPointDto> getDroppingPointList() {
		return droppingPointList;
	}

	public List<BoardingPointDto> getBoardingPointList() {
		return boardingPointList;
	}
	
	public static class BusBookingDtoBuilder {
		private String brandName;
		private Date leaveDate;
		private Date reachDate;
		private int fare;
		private List<DroppingPointDto> droppingPointList;
		private List<BoardingPointDto> boardingPointList;

		public BusBookingDtoBuilder setBrandName(final String brandName) {
			this.brandName = brandName;
			return this;
		}

		public BusBookingDtoBuilder setLeaveDate(final Date leaveDate) {
			this.leaveDate = leaveDate;
			return this;
		}

		public BusBookingDtoBuilder setReachDate(final Date reachDate) {
			this.reachDate = reachDate;
			return this;
		}

		public BusBookingDtoBuilder setFare(int fare) {
			this.fare = fare;
			return this;
		}

		public BusBookingDtoBuilder setDroppingPointList(final List<DroppingPointDto> droppingPointList) {
			this.droppingPointList = droppingPointList;
			return this;
		}

		public BusBookingDtoBuilder setBoardingPointList(final List<BoardingPointDto> boardingPointList) {
			this.boardingPointList = boardingPointList;
			return this;
		}
		
		public BusBookingResponseDto build() {
			return new BusBookingResponseDto(this);
		}
	}
 
}
