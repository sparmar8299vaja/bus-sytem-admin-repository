package com.sp.admin.exceptions;

public class InvailidDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvailidDataException(final String messsage) {
		super(messsage);
	}

	public InvailidDataException(final String messsage, final Throwable th) {
		super(messsage, th);
	}
}
