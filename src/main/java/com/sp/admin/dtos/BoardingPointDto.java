package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BoardingPointDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Bad Request Boarding Point Must Not Be Null")
	@NotBlank(message = "Bad Request Boarding Point Must Not Be Empty")
	private String name;

	public BoardingPointDto() {
		super();
	}

	public BoardingPointDto(final BoardingPointDtoBuilder builder) {
		this.name = builder.name;
	}

	public String getName() {
		return name;
	}

	public static class BoardingPointDtoBuilder {
		private String name;

		public BoardingPointDtoBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public BoardingPointDto build() {
			return new BoardingPointDto(this);
		}
	}
}
