/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.util.List;

/**
 *
 * @author chris
 * @param <T>
 */
public interface IDAO<T> {
    
    List<T> findAll();
    
    T findById(Integer id);
    
    void update(T t);
    
    void remove(Integer id);
    
    void insert(T t);
    
    Integer getLastRegister();
}
