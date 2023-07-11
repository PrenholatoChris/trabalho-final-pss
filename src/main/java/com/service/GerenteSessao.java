/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Usuario;

/**
 *
 * @author Vanderson
 */
public class GerenteSessao {
    private static GerenteSessao instance = null;
    private Usuario usuarioLogado;
    
    private GerenteSessao(){}
    
    static public GerenteSessao getInstance(){
        if(instance == null)
            instance = new GerenteSessao();
        return instance;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
