package com.studentmvc.dao;

import java.util.List;

import com.studentmvc.model.Student;

public interface StudentDAO {
	int save(Student student);
	
	List<Student> getAll();
	
	Student getById(int id);
	
	int remove(int id);
	
	int update(int id, Student student);
}
