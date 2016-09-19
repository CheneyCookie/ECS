package com.ecs.common.exception;

public class UserServiceException extends Exception{

	private static final long serialVersionUID = 1L;
	//Generate Constructor from superclass
	public UserServiceException() {
		super();
	}

	public UserServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserServiceException(String arg0) {
		super(arg0);
	}

	public UserServiceException(Throwable arg0) {
		super(arg0);
	}

}
