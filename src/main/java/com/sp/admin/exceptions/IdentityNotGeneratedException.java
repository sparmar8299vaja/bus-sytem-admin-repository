package com.sp.admin.exceptions;

public class IdentityNotGeneratedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentityNotGeneratedException(final String message, final Throwable th) {
		super(message, th);
	}

	public IdentityNotGeneratedException(final String message) {
		super(message);
	}

}
