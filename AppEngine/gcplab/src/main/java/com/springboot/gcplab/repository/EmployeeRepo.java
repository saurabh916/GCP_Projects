package com.springboot.gcplab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.gcplab.gcpmodel.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee
, Long>{

}
