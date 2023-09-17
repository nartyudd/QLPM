/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.controllers;

import com.tcd.pojo.Employees;
import com.tcd.service.EmployeeService;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiEmployeeController {
    @Autowired
    private EmployeeService eplService;
    
    @DeleteMapping("/employee/{employeesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "employeesId") int employeesId) {
        this.eplService.deleteEmployee(employeesId);
    }
    
    @GetMapping("/employee/")
    @CrossOrigin
    public ResponseEntity<List<Employees>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.eplService.getEmployee(params), HttpStatus.OK);
    }
}
