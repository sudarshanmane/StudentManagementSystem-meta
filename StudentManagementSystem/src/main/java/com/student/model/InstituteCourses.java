package com.student.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class InstituteCourses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer course_id;
	
	@Size(min = 3, max = 20, message = "course_name length shall be between 3 to 20.")
	@NotEmpty(message = "course_name may Empty.")
	private String course_name;
	
	@Size(min = 3, max = 20, message = "course_fee length shall be between 3 to 20.")
	@NotEmpty(message = "course_fee may Empty.")
	private String course_fee;
	
	@Embedded
	private InstituteAddress address;
	
	@ManyToMany(cascade =  CascadeType.ALL,mappedBy = "courses")
	private List<Student> students = new LinkedList<>();
	
}
