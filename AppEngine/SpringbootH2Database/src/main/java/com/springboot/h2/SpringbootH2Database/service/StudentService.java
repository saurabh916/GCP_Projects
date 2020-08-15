package com.springboot.h2.SpringbootH2Database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.SpringbootH2Database.repository.StudentRepository;
import com.springboot.h2.SpringbootH2Database.model.StudentModel;

@Service
public class StudentService {
	@Autowired
    StudentRepository repository;
 
    // Save student entity in the h2 database.
    public void save(final StudentModel student) {
        repository.save(student);
    }
 
    // Get all students from the h2 database.
    public List<StudentModel> getAll() {
        final List<StudentModel> students = new ArrayList<>();
        repository.findAll().forEach(student -> students.add(student));
        return students;
    }
	
}
