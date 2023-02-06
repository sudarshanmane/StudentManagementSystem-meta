package com.student.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Exception.StudentCourseException;
import com.student.dao.CourseDao;
import com.student.model.InstituteCourses;
import com.student.model.Student;

@Service
public class CourseServiceImplementatio implements CourseService{
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public String createNewCourseService(InstituteCourses courses) throws StudentCourseException {
		
//		Correcting the course name
		String[] courseNamesArray = courses.getCourse_name().split(" ");
		StringBuilder courseName = new StringBuilder();
		
		for(int i = 0; i < courseNamesArray.length ;i++) {
			courseName.append(courseNamesArray[i].trim());
			courseName.append(" ");
		}
		
		String modifiedCourseName = "" + courseName;
		courses.setCourse_name(modifiedCourseName.trim());
		
		System.out.println(modifiedCourseName);
		
//		-----------------------------------------------------------------------------------------------
		
		List<Student> listOfStudents = courses.getStudents();

//		validation of the student details
		List<Student> nameValidation = listOfStudents.stream().
				filter(i -> (i.getName()==null || i.getName().length() <0 || i.getName().length()>30)).collect(Collectors.toList());
		
		if(nameValidation.size() > 0) {
			throw new StudentCourseException("Please enter a valid student name.");
		}
		
		// Email validation
		
//		 Mobile number validation 
		List<Student> mobileValidation  = listOfStudents.stream().
				filter(i -> !(Pattern.matches("[6789]\\d{9}", i.getMobile_number()))).collect(Collectors.toList());
		
		if(mobileValidation.size() > 0) {
			throw new StudentCourseException("Please enter a valid mobile number of " + mobileValidation.get(0).getName());
		}
		
		//Associating Course Name with the students
		for(Student instituteCourses : listOfStudents) {
			instituteCourses.setEnrolled_course_name(courses.getCourse_name());
			instituteCourses.getCourses().add(courses);
		}
		
		courseDao.save(courses);
		
		return "Course registered successfully with the studets provided along with the course.";
		
		}

}
