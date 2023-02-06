package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;

public interface StundentDao extends JpaRepository<Student, Integer>{

}
