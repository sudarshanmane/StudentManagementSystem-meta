package com.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;


@RestController
public class StudentController {
	
	// save student handler
	@PostMapping("/registerStudentInCourse/{courseName}")
	public ResponseEntity<String> registerStudentHandler(@PathVariable String courseName, @RequestBody Student student){
		
		return null;
	}
}
