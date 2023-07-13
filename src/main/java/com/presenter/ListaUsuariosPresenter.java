/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.lista_usuarios.ListaUsuariosState;
import com.view.ListaUsuariosView;

/**
 *
 * @author Vanderson
 */
public class ListaUsuariosPresenter {
    private ListaUsuariosState estado;
    private ListaUsuariosView view;
    
    public void setEstado(ListaUsuariosState estado){
        this.estado = estado;
    }
    
    public ListaUsuariosPresenter(){
        view = new ListaUsuariosView();
    }
}