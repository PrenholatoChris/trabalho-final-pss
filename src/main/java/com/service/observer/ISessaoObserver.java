/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service.observer;

import com.model.Usuario;

/**
 *
 * @author Vanderson
 */
public interface ISessaoObserver {
    
    public void atualizarSessao(Usuario usuarioLogado);
}
