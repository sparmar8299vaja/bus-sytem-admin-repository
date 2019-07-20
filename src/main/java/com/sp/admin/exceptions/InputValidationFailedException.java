package com.sp.admin.exceptions;

public class InputValidationFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputValidationFailedException(final String messsage) {
		super(messsage);
	}

	public InputValidationFailedException(final String messsage, final Throwable th) {
		super(messsage, th);
	}
}
