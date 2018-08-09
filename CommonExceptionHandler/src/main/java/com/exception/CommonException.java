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
@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="Internal Server Error, please try later")
public class CommonException extends RuntimeException {
	
	private static final long serialVersionUID = -2825202551988158680L;
	
	

}
