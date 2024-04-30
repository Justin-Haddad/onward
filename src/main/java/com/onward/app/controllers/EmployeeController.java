package com.onward.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onward.app.entities.Employee;
import com.onward.app.services.EmployeeService;

// Made by Jack Turk
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create
    @PostMapping(value = "/newemployee", consumes = "application/json")
    @CrossOrigin
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeService.saveEmployee(emp);
    }

    // Read
    @GetMapping("/getemployees")
    public List<Employee> fetchEmployees(){
        return employeeService.fetchEmployees();
    }

    //TODO implement update and delete
}
