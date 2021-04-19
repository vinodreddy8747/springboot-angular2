package com.abc.xyz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.xyz.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	  List<Employee> findByNameContaining(String title);
}
