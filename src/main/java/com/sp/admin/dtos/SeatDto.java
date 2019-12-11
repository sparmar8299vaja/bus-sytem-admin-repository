package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SeatDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int seatNo;
	@NotNull(message = "Bad Request Seat Type Must Not Be Null")
	@NotBlank(message = "Bad Request Seat Type Must Not Be Empty")
	private String seatType;
	private boolean available;

	public SeatDto() {
		super();
	}

	public SeatDto(final SeatDtoBuilder builder) {
		this.seatNo = builder.seatNo;
		this.seatType = builder.seatType;
		this.available = builder.available;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public String getSeatType() {
		return seatType;
	}

	public boolean isAvailable() {
		return available;
	}

	public static class SeatDtoBuilder {

		private int seatNo;
		private String seatType;
		private boolean available;

		public SeatDtoBuilder setSeatNo(final int seatNo) {
			this.seatNo = seatNo;
			return this;
		}

		public SeatDtoBuilder setSeatType(final String seatType) {
			this.seatType = seatType;
			return this;
		}

		public SeatDtoBuilder setAvailable(final boolean available) {
			this.available = available;
			return this;
		}

		public SeatDto build() {
			return new SeatDto(this);
		}
	}
}
