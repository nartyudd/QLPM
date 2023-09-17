/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.controllers;

import com.tcd.pojo.Medicine;
import com.tcd.service.MedicineService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/medicine")
    public String list(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine";
    }

    @RequestMapping("/medicine/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("medicine", this.medicineService.getMedicineById(id));
        return "medicine";
    }

    @PostMapping("/medicine")
    public String add(@ModelAttribute(value = "medicine") @Valid Medicine p,
            BindingResult rs) {

        if (this.medicineService.addOrUpdateMedicine(p) == true) {

            return "redirect:/";
        }

        return "medicine";
    }
}
