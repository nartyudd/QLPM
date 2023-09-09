/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.configs;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;
/**
 *
 * @author duytr
 */
public class CloudinaryConfig {
   Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
  "cloud_name", "dmte2cgrt",
  "api_key", "948821221637452",
  "api_secret", "***************************"));

    public Map toMap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
