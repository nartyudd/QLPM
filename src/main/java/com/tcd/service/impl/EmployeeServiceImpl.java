/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tcd.pojo.Employees;
import com.tcd.repository.EmployeeRepository;
import com.tcd.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeService eplRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Employees> getEmployee(Map<String, String> params) {
        return this.eplRepo.getEmployee(params);
    }

    @Override
    public int countEmployee() {
        return this.eplRepo.countEmployee();
    }

    @Override
    public boolean addOrUpdateEmployee (Employees e){
        return this.eplRepo.addOrUpdateEmployee(e);
    }

    @Override
    public Employees getEmployeeById(int employeesId) {
        return this.eplRepo.getEmployeeById(employeesId);
    }

    @Override
    public boolean deleteEmployee(int employeesId) {
        return this.eplRepo.deleteEmployee(employeesId);
    }
    
}
