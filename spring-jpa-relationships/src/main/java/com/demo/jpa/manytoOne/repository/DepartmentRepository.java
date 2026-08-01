package com.demo.jpa.manytoOne.repository;

import com.demo.jpa.manytoOne.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
