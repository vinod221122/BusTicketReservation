/**
 * 
 */
package com.exception.bean;

/**
 * @author VinodHoney Kusuma
 *
 */
public class ErrorResponse {

	private int errorCode;
	private String errorMessage;
	
	
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public ErrorResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
