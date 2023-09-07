/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.configs;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
/**
 *
 * @author duytr
 */
public class CloudinaryConfig {
   Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
  "cloud_name", "dmte2cgrt",
  "api_key", "948821221637452",
  "api_secret", "***************************"));
}
