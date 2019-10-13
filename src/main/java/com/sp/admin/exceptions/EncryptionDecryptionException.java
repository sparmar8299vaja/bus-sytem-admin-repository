package com.sp.admin.exceptions;

public class EncryptionDecryptionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncryptionDecryptionException(final String message) {
		super(message);
	}

	public EncryptionDecryptionException(final String message, final Throwable th) {
		super(message, th);
	}

}
