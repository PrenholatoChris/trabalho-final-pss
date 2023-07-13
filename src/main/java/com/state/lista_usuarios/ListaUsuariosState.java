/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.command.factory.lista_usuarios.ListaUsuariosCommandFactory;
import com.presenter.ListaUsuariosPresenter;

/**
 *
 * @author Vanderson
 */
public abstract class ListaUsuariosState {
    protected ListaUsuariosPresenter listaUsuarios;
    
    public void autorizar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Autorizacao.");
    }
    
    public void buscar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Busca.");
    }
    
    public void enviarNotificacao() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Envio Notificação.");
    }
    
    public void executar(){
        ListaUsuariosCommandFactory.getFactory(this).criar().executar();
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
