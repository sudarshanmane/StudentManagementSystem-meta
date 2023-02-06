package com.student.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentCourseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public StudentCourseException(String message) {
		super(message);
	}
	
}
