package com.student.service;


import com.student.Exception.StudentCourseException;
import com.student.model.InstituteCourses;

public interface CourseService {

	public String createNewCourseService(InstituteCourses courses) throws StudentCourseException;
	
}
