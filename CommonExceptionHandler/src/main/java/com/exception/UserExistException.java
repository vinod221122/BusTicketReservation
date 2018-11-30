/**
 * 
 */
package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author VinodHoney Kusuma
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="user already exists")
public class UserExistException extends RuntimeException {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 5687345437505975033L;
	
}
