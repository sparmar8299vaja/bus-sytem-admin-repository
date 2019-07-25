package com.sp.admin.exceptions;

public class UserNameNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameNotExistException(final String message) {
		super(message);
	}
}
