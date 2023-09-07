/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tcd.repository;

import com.tcd.pojo.Medicine;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface MedicineRepository {
    List<Medicine> getMedicine(Map<String, String> params);
    int countMedicine();
    boolean addOrUpdateMedicine(Medicine p);
    Medicine getMedicineById(int id);
    boolean deleteMedicine(int id);

    
}

