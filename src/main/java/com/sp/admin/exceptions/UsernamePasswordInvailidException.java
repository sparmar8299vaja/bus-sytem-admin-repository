package com.sp.admin.exceptions;

public class UsernamePasswordInvailidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernamePasswordInvailidException(final String messsage) {
		super(messsage);
	}

	public UsernamePasswordInvailidException(final String messsage, final Throwable th) {
		super(messsage, th);
	}
}
