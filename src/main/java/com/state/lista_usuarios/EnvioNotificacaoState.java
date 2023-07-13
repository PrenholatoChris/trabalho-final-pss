/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.presenter.ListaUsuariosPresenter;

/**
 *
 * @author Vanderson
 */
public class EnvioNotificacaoState extends ListaUsuariosState {
    
    public EnvioNotificacaoState(ListaUsuariosPresenter listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public void autorizar(){
        listaUsuarios.setEstado(new AutorizacaoState(listaUsuarios));
    }
}
