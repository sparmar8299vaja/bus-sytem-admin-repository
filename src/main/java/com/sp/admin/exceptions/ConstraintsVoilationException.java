package com.sp.admin.exceptions;

public class ConstraintsVoilationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConstraintsVoilationException(final String message){
		super(message);
	}
	
    public ConstraintsVoilationException(final String message, final Throwable th){
		super(message,th);
	}
}
