/*package com.blueharvest.exception;

import javax.servlet.http.HttpServletRequest;


import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.blueharvest.model.ErrorResponse;

@ControllerAdvice
public class AccountServiceHandlerController {
	
	
	
	@Value ("${Account.service.common.errorMessage}")
	private String commonErrorMessage;

	@Value ("${Account.service.error.argument.mismatch}")
	private String argumentMismatch;
	
	/**
	 * Handler for http bad request
	 *
	 * @param req
	 * @param ex
	 * @return
	 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { TypeMismatchException.class, MissingServletRequestParameterException.class,
			HttpMediaTypeNotAcceptableException.class })
	@ResponseBody
	public ErrorResponse handleBadRequestException(HttpServletRequest req, Exception ex)
	{
		System.out.println("Error occured ..... "+ex.getMessage());
		return this.createErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), commonErrorMessage);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
	@ResponseBody
	public ErrorResponse handleArgumentMismatchException(HttpServletRequest req, Exception ex)
	{
		System.out.println("Error occured ..... "+ex.getMessage());
		return this.createErrorMessage(HttpStatus.BAD_REQUEST.value(), argumentMismatch);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { AccountServiceException.class })
	@ResponseBody
	public ErrorResponse handleCustomException(HttpServletRequest req, AccountServiceException ex)
	{
		System.out.println("Error occured ..... "+ex.getMessage());
		return this.createErrorMessage(ex.getErrorCode(), commonErrorMessage);
	}

	/**
	 * Handler for for any un-handled exception.
	 *
	 * @param req
	 * @param ex
	 * @return
	 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public ErrorResponse handleUnhandledException(HttpServletRequest req, Exception ex)
	{
		System.out.println("Error occured ..... "+ex.getMessage());
		return this.createErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), commonErrorMessage);
	}
	
	private ErrorResponse createErrorMessage(int errorCode, String errorMessage)
	{
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("ERROR");
		errorResponse.setErrorCode(errorCode);
		errorResponse.setMessage(errorMessage);
		System.out.println("Sending error Response ..... "+errorResponse);
		return errorResponse;
	}

}
*/