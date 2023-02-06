package com.student.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseExceptionDetails {
	
	private LocalDateTime dateTime;
	private String message;
	private String description;
	
}
