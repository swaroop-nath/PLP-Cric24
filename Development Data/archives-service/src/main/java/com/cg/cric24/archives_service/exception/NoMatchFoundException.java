package com.cg.cric24.archives_service.exception;

public class NoMatchFoundException extends Exception {

	public NoMatchFoundException() {
		super();
	}

	public NoMatchFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoMatchFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoMatchFoundException(String message) {
		super(message);
	}

	public NoMatchFoundException(Throwable cause) {
		super(cause);
	}

}
