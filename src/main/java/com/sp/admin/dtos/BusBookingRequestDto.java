package com.sp.admin.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BusBookingRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Bad Request Start Location Must Not Be Null")
	@NotBlank(message = "Bad Request Start Location Must Not Be Empty")
	private String fromLocation;
	@NotNull(message = "Bad Request To Location Must Not Be Null")
	@NotBlank(message = "Bad Request To Location Must Not Be Empty")
	private String toLocation;
	@NotNull(message = "Bad Request Date Of Leave Must Not Be Null")
	private Date leaveDate;

	public BusBookingRequestDto() {
		super();
	}

	public BusBookingRequestDto(final BusBookingRequestDtoBuilder builder) {
		this.fromLocation = builder.fromLocation;
		this.toLocation = builder.toLocation;
		this.leaveDate = builder.leaveDate;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public static class BusBookingRequestDtoBuilder {
		private String fromLocation;
		private String toLocation;
		private Date leaveDate;

		public BusBookingRequestDtoBuilder setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
			return this;
		}

		public BusBookingRequestDtoBuilder setToLocation(String toLocation) {
			this.toLocation = toLocation;
			return this;
		}

		public BusBookingRequestDtoBuilder setLeaveDate(Date leaveDate) {
			this.leaveDate = leaveDate;
			return this;
		}
		
		public BusBookingRequestDto build() {
			return new BusBookingRequestDto(this);
		}
	}
}
