package com.demo.spring_jpa.controller;

import com.demo.spring_jpa.entity.Employee;
import com.demo.spring_jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return service.save(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return service.findById(id);
    }
}