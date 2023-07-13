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
public class AutorizacaoState extends ListaUsuariosState {
    
    public AutorizacaoState(ListaUsuariosPresenter listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public void buscar(){
        listaUsuarios.setEstado(new BuscaState(listaUsuarios));
    }
    
    @Override
    public void enviarNotificacao(){
        listaUsuarios.setEstado(new EnvioNotificacaoState(listaUsuarios));
    }
}
