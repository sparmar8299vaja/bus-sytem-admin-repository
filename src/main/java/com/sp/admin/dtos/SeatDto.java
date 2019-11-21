package com.sp.admin.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SeatDto {

	@NotNull(message = "Bad Request Seat Number Must Not Be Null")
	private Integer seatNo;
	@NotNull(message = "Bad Request Seat Type Must Not Be Null")
	@NotBlank(message = "Bad Request Seat Type Must Not Be Empty")
	private String seatType;
	@NotNull(message = "Bad Request Seat Availability Must Not Be Null")
	private Boolean available;

	public SeatDto() {
		super();
	}

	public SeatDto(final SeatDtoBuilder builder) {
		this.seatNo = builder.seatNo;
		this.seatType = builder.seatType;
		this.available = builder.available;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public String getSeatType() {
		return seatType;
	}

	public boolean isAvailable() {
		return available;
	}

	public static class SeatDtoBuilder {

		private Integer seatNo;
		private String seatType;
		private Boolean available;

		public SeatDtoBuilder setSeatNo(final Integer seatNo) {
			this.seatNo = seatNo;
			return this;
		}

		public SeatDtoBuilder setSeatType(final String seatType) {
			this.seatType = seatType;
			return this;
		}

		public SeatDtoBuilder setAvailable(final Boolean available) {
			this.available = available;
			return this;
		}

		public SeatDto build() {
			return new SeatDto(this);
		}
	}
}
