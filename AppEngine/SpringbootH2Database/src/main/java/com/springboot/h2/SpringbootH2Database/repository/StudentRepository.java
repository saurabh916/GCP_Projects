package com.springboot.h2.SpringbootH2Database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.SpringbootH2Database.model.StudentModel;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Integer>{

}
