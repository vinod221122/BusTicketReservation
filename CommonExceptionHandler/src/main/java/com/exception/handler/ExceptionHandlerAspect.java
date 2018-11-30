/**
 * 
 */
package com.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exception.BadRequestException;
import com.exception.BaseException;
import com.exception.CommonException;
import com.exception.UserExistException;
import com.exception.bean.ErrorResponse;

/**
 * @author VinodHoney Kusuma
 *
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerAspect extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleBadRequest(final BadRequestException error) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "plese provide valied details");
	}

	@ExceptionHandler(CommonException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleCommonError(CommonException error) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "plese provide valied details");
	}
	
	@ExceptionHandler(UserExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleCommonError(UserExistException error) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "user already exists");
	}
	
	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleBaseException(BaseException error) {
		ErrorResponse errorResponse=new ErrorResponse(error.getErrCode(),error.getErrMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
