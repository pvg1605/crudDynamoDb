package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * class for scenarios where a resource is requested by it’s ID,
 *  and resource is not found in the system
 * 
 * @author praveenv
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message){
        super(message);
    }

}
