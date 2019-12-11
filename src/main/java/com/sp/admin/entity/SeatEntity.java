package com.sp.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sp.admin.dtos.SeatDto;

@Entity
@Table(name = "SEAT_DETAILS")
public class SeatEntity {

	@Id
	@Column(name = "seat_id")
	@GenericGenerator(name = "SEAT_GEN", strategy = "increment")
	@GeneratedValue(generator = "SEAT_GEN")
	private int seatId;
	@Column(name = "seat_no")
	private int seatNo;
	@Column(name = "seat_type")
	private String seatType;
	@Column(name = "seat_availability")
	private boolean available;

	public SeatEntity() {
		super();
	}
	
	public SeatEntity(final SeatEntityBuilder builder) {
		this.seatId = builder.seatId;
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

	public int getSeatId() {
		return seatId;
	}

	public static class SeatEntityBuilder{
		
		private int seatId;
		private int seatNo;
		private String seatType;
		private boolean available;
		
		public SeatEntityBuilder setSeatNo(final int seatNo) {
			this.seatNo = seatNo;
			return this;
		}
		
		public SeatEntityBuilder setSeatType(final String seatType) {
			this.seatType = seatType;
			return this;
		}
		
		public SeatEntityBuilder setAvailable(final boolean available) {
			this.available = available;
			return this;
		}

		public SeatEntityBuilder setSeatId(final int seatId) {
			this.seatId = seatId;
			return this;
		}

		public SeatEntity build() {
			return new SeatEntity(this);
		}
	}
	
	public static SeatEntity convertDtoToEntity(final SeatDto dto) {
		return new SeatEntity.SeatEntityBuilder()
				.setSeatNo(dto.getSeatNo())
				.setAvailable(dto.isAvailable())
				.setSeatType(dto.getSeatType())
				.build();
	}
	
	public static SeatDto convertEntityToDto(final SeatEntity dto) {
		return new SeatDto.SeatDtoBuilder()
				.setSeatNo(dto.getSeatNo())
				.setAvailable(dto.isAvailable())
				.setSeatType(dto.getSeatType())
				.build();
	}
}
