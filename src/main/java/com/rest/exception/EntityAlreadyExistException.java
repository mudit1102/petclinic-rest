package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExistException extends RuntimeException{

	public EntityAlreadyExistException(String message) {
		super(message);
	}

	public EntityAlreadyExistException() {
		super();
	}

	public EntityAlreadyExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityAlreadyExistException(Throwable cause) {
		super(cause);
	}
}
