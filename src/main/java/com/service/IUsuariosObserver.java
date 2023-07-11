/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.model.Usuario;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public interface IUsuariosObserver {
    
    public void atualizarUsuarios(List<Usuario> usuarios);
}
