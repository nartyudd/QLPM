/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tcd.service;


import com.tcd.pojo.Employees;
import java.util.List;
import java.util.Map;
/**
 *
 * @author duytr
 */
public interface EmployeeService {
    List<Employees> getEmployee(Map<String, String> params);
    int countEmployee();
    boolean addOrUpdateEmployee(Employees e);
    Employees getEmployeeById(int employeesId);
    boolean deleteEmployee(int employeesId);
}
