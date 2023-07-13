/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_notificacoes;

import com.command.factory.lista_notificacoes.ListaNotificacoesCommandFactory;
import com.presenter.ListaNotificacoesPresenter;

/**
 *
 * @author Vanderson
 */
public abstract class ListaNotificacoesState {
    protected ListaNotificacoesPresenter listaNotificacoes;
    
    public void buscar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado de Busca.");
    }
    
    public void visualizar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado de Visualizacao.");
    }
    
    public void executar(){
        ListaNotificacoesCommandFactory.getFactory(this).criar().executar();
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
