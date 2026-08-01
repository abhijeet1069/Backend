package com.demo.jpa.manytoOne.repository;

import com.demo.jpa.manytoOne.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
