package com.sp.admin.dtos;


public class CustomerRegistrationDto extends UserRegistrationDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerRegistrationDto() {
		super();
	}
	
	public CustomerRegistrationDto(final CustomerRegistrationDtoBuilder builder) {
		super(builder);
	}

	public static class CustomerRegistrationDtoBuilder extends UserRegistrationDto.UserRegDtoBuilder<CustomerRegistrationDtoBuilder>{
         
		@Override
		public CustomerRegistrationDto build() {
			return new CustomerRegistrationDto(this);
		}
	}
}
