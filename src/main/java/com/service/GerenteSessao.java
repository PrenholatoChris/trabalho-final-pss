/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Usuario;
import com.service.observer.ISessaoObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class GerenteSessao {
    private static GerenteSessao instance = null;
    private List<ISessaoObserver> observers;
    private Usuario usuarioLogado;
    
    private GerenteSessao(){
        observers = new ArrayList<>();
    }
    
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
        notificarObservers();
    }
    
    public void addObserver(ISessaoObserver observer){
        observers.add(observer);
    }
    
    public void removeObserver(ISessaoObserver observer){
        observers.remove(observer);
    }
    
    private void notificarObservers(){
        for(ISessaoObserver observer : observers){
            observer.atualizarSessao(usuarioLogado);
        }
    }
}
