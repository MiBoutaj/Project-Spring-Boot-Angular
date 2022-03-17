package com.example.demo.controller;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;



    @GetMapping("/employees")
    public List<Employee> gettAllEmployee(){
        return employeeRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:63843")
    @PostMapping("/employees")
    public Employee createEmployee( @RequestBody  Employee employee){
        return employeeRepository.save(employee);
    }



    @CrossOrigin(origins = "http://localhost:63843")
     @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable  long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id :" +id));
        return ResponseEntity.ok(employee);

    }
    @CrossOrigin(origins = "http://localhost:63843")
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee( @PathVariable  long id, @RequestBody  Employee employeeD){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id :" +id));

        employee.setFirstName(employeeD.getFirstName());
        employee.setLastname(employeeD.getLastname());
        employee.setEmail(employeeD.getEmail());
        employee.setImageUrl(employeeD.getImageUrl());

        Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);

    }


    @CrossOrigin(origins = "http://localhost:63843")
    @DeleteMapping("employees/{id}")
    public  ResponseEntity<Map<String,Boolean>> deleteEmployee( @PathVariable  long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id :" +id));
      employeeRepository.delete(employee);
      Map<String,Boolean> response =new HashMap<>();
      response.put("delete",Boolean.TRUE);
      return ResponseEntity.ok(response);

    }















}
