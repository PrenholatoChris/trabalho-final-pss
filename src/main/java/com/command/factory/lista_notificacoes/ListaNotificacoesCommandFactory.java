/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_notificacoes;

import com.command.lista_notificacoes.IListaNotificacoesCommand;
import com.state.lista_notificacoes.BuscaState;
import com.state.lista_notificacoes.ListaNotificacoesState;
import com.state.lista_notificacoes.VisualizacaoState;

/**
 *
 * @author Vanderson
 */
public abstract class ListaNotificacoesCommandFactory {
    
    static public ListaNotificacoesCommandFactory getFactory(ListaNotificacoesState estado){
        if(estado.getClass() == BuscaState.class){
            return new BuscarCommandFactory((BuscaState)estado);
        }else if(estado.getClass() == VisualizacaoState.class){
            return new VisualizarCommandFactory((VisualizacaoState)estado);
        }else{
            return null;
        }
    } 
    
    public abstract IListaNotificacoesCommand criar();
}
