package com.student.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Checked Exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StudentCourseExceptionDetails> StudentCourseExceptionHadler(Exception exception, WebRequest request){
		
		StudentCourseExceptionDetails courseExceptionDetails  = new StudentCourseExceptionDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<StudentCourseExceptionDetails>(courseExceptionDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	// No Handler Found Exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<StudentCourseExceptionDetails> noHandlerFoundException(NoHandlerFoundException exception,WebRequest request){
		
		StudentCourseExceptionDetails courseExceptionDetails = new StudentCourseExceptionDetails(
				LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<StudentCourseExceptionDetails>(courseExceptionDetails,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	// Method Arguments Not Valid Exception 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StudentCourseExceptionDetails> methodArgumentsNotValidException(MethodArgumentNotValidException exception,
			WebRequest request){
		
		StudentCourseExceptionDetails courseExceptionDetails =  new StudentCourseExceptionDetails(LocalDateTime.now(), 
				exception.getBindingResult().getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return new ResponseEntity<StudentCourseExceptionDetails>(courseExceptionDetails,HttpStatus.NOT_ACCEPTABLE);

		
		
	}
	
}
