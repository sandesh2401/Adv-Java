package com.cruddemo.dao;

import java.util.List;

import com.cruddemo.model.Student;

public interface StudentDAO {
		int save(Student student);
		List<Student> getAll();
		Student getById(int id);
		int update(Student student, int id);
		int remove(int id);
}
