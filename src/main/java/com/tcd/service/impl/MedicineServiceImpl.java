/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tcd.pojo.Medicine;
import com.tcd.repository.MedicineRepository;
import com.tcd.service.MedicineService;
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
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Medicine> getMedicine(Map<String, String> params) {
        return this.medicineRepo.getMedicine(params);
    }

    @Override
    public int countMedicine() {
        return this.medicineRepo.countMedicine();
    }

    @Override
    public boolean addOrUpdateMedicine (Medicine p){
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(MedicineServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.medicineRepo.addOrUpdateMedicine(p);
        
    }

    @Override
    public Medicine getMedicineById(int id) {
        return this.medicineRepo.getMedicineById(id);
    }

    @Override
    public boolean deleteMedicine(int id) {
        return this.medicineRepo.deleteMedicine(id);
    }
    
}
