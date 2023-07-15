/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.command.factory.lista_usuarios.ListaUsuariosCommandFactory;
import com.presenter.ListaUsuariosPresenter;
import com.view.ListaUsuariosView2;

/**
 *
 * @author Vanderson
 */
public abstract class ListaUsuariosState {
    protected ListaUsuariosPresenter listaUsuarios;
    protected ListaUsuariosView2 view;
    
    public void autorizar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Autorizacao.");
    }
    
    public void retornar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Base.");
    }
    
    public void enviarNotificacao() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Envio Notificação.");
    }
    
    public void executar(){
        ListaUsuariosCommandFactory.getFactory(this).criar().executar();
    }
    
    protected void removerBotoesEstado(){
        while(view.getPainelBotoes().getComponentCount() > 1){
            int index = view.getPainelBotoes().getComponentCount() - 1;
            view.getPainelBotoes().remove(index);
        }
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
