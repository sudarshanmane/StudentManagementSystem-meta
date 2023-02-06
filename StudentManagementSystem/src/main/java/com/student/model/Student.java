package com.student.model;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
			
	private String name;
	
	private String mobile_number;

	private String email;
	
	private String enrolled_course_name;
	
	@Embedded
	private StudentAddress address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<InstituteCourses> courses = new LinkedList<>();
	
}
