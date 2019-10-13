package com.sp.admin.exceptions;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(final String message) {
		super(message);
	}

	public DataNotFoundException(final String message, final Throwable th) {
		super(message, th);
	}
}
