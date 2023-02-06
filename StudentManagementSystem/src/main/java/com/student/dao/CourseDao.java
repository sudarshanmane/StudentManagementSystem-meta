package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.InstituteCourses;

public interface CourseDao extends JpaRepository<InstituteCourses, Integer>{

}
