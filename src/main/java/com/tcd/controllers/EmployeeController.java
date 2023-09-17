/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.controllers;

import com.tcd.service.EmployeeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author duytr
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class EmployeeController {
    @Autowired
    private EmployeeService eplService;
    @Autowired
    private Environment env;
    
     @RequestMapping("/employee")
    public String employee(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("eployee", this.eplService.getEmployee(params));
        
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE"));
        int count = this.eplService.countEmployee();
        model.addAttribute("counter", Math.ceil(count*1.0/pageSize));
        return "employee";
}
}
   
