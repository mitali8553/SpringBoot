package com.example.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootDemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
