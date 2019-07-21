package com.rest.utils;

import com.rest.exception.BadRequestException;
import com.rest.exception.EntityAlreadyExistException;


public class ExceptionUtils {

	public static void throwBadRequestException(String message) {
	    throw new BadRequestException(message);
	  }
	public static void throwEntityAlreadyEistException(String message){
		throw new EntityAlreadyExistException(message);
	}
}
