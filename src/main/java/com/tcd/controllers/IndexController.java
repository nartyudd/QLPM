/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.controllers;

import com.tcd.service.MedicineService;
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
public class IndexController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private Environment env;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("medicine", this.medicineService.getMedicine(params));
        
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE"));
        int count = this.medicineService.countMedicine();
        model.addAttribute("counter", Math.ceil(count*1.0/pageSize));
        
        return "index";
    }
}
