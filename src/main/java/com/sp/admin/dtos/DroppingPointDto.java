package com.sp.admin.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroppingPointDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Bad Request Dropping Point Must Not Be Null")
	@NotBlank(message = "Bad Request Dropping Point Must Not Be Empty")
	private String name;

	public DroppingPointDto() {
		super();
	}

	public DroppingPointDto(final DroppingPointDtoBuilder builder) {
		this.name = builder.name;
	}

	public String getName() {
		return name;
	}

	public static class DroppingPointDtoBuilder {
		private String name;

		public DroppingPointDtoBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public DroppingPointDto build() {
			return new DroppingPointDto(this);
		}
	}
}
