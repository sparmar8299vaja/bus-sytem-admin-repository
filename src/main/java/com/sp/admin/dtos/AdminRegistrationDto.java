package com.sp.admin.dtos;

public class AdminRegistrationDto extends UserRegistrationDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminRegistrationDto() {
		super();
	}
	
	public AdminRegistrationDto(final AdminRegBuilder builder) {
		super(builder);
	}

	public static class AdminRegBuilder extends UserRegistrationDto.UserRegDtoBuilder<AdminRegBuilder>{

		@Override
		public AdminRegistrationDto build() {
			return new AdminRegistrationDto(this);
		}
	}

}
