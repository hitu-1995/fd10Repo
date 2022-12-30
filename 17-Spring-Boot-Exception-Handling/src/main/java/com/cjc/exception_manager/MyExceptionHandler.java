package com.cjc.exception_manager;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cjc.exceptions.NameInvalidException;

@ControllerAdvice
public class MyExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String>  arithmeticException() {
		
		return new ResponseEntity<String>("CID Not Valid",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NameInvalidException.class)
	public ResponseEntity<String> nameInvalidException() {
		
		return new ResponseEntity<String>("Name is Empty or null",HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>("Method Not Suppported",HttpStatus.BAD_GATEWAY);
	}
}
