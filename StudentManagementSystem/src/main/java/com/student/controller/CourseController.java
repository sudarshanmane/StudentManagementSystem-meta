package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.Exception.StudentCourseException;
import com.student.model.InstituteCourses;
import com.student.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	// Register new course
	@PostMapping("/createNewCourse")
	public ResponseEntity<String> createNewCourseHandler(@RequestBody InstituteCourses course) throws StudentCourseException {	
		
		System.out.println(course.getStudents());
		String message = courseService.createNewCourseService(course); 
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
}
