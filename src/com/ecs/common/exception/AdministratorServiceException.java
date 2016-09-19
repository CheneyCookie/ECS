package com.ecs.common.exception;

public class AdministratorServiceException extends Exception{

	private static final long serialVersionUID = 1L;
	//Generate Constructor from superclass
	public AdministratorServiceException() {
		super();
	}

	public AdministratorServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdministratorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdministratorServiceException(String message) {
		super(message);
	}

	public AdministratorServiceException(Throwable cause) {
		super(cause);
	}
	
}
