package com.sp.admin.exceptions;

public class TockenExpirationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TockenExpirationException(final String messsage) {
		super(messsage);
	}

	public TockenExpirationException(final String messsage, final Throwable th) {
		super(messsage, th);
	}
}
