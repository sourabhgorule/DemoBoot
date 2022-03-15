package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springboot.model.Employee;

@Repository
@Component
public interface EmployeeRepository extends  JpaRepository<Employee, Long> {
}
