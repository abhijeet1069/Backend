package com.demo.jpa.manytoOne.controller;

import com.demo.jpa.manytoOne.entity.Employee;
import com.demo.jpa.manytoOne.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
}
