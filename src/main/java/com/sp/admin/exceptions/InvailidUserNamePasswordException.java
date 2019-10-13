package com.sp.admin.exceptions;

public class InvailidUserNamePasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvailidUserNamePasswordException(final String message) {
		super(message);
	}

	public InvailidUserNamePasswordException(final String message, final Throwable th) {
		super(message, th);
	}
}
