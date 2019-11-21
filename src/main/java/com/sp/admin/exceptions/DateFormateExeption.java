package com.sp.admin.exceptions;

public class DateFormateExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateFormateExeption(final String message) {
		super(message);
	}

	public DateFormateExeption(final String message, final Throwable th) {
		super(message, th);
	}
}
