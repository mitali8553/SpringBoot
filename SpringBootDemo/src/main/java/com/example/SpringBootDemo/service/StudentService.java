package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudent(Long id);
}
