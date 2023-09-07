/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.repository;

import com.tcd.pojo.Userlogin;

/**
 *
 * @author admin
 */
public interface UserRepository {
    Userlogin getUserByUsername(String username);
}
