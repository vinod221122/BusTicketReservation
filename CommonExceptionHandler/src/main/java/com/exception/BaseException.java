/**
 * 
 */
package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.exception.bean.ErrorResponse;

/**
 * @author VinodHoney Kusuma
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="base exception")
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7812503353431832189L;
	
	private int errCode;
	private String errMessage;

	public BaseException(){
		super();
	}
	
	public BaseException(int errCode,String errMessage){
		this.errCode=errCode;
		this.errMessage=errMessage;
	}
	
	public BaseException(ErrorResponse errorResponse){
		this.errCode=errorResponse.getErrorCode();
		this.errMessage=errorResponse.getErrorMessage();
	}

	/**
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}
	
	
}
