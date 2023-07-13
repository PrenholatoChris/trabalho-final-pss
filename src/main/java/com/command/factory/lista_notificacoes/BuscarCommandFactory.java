/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_notificacoes;

import com.command.lista_notificacoes.BuscarCommand;
import com.command.lista_notificacoes.IListaNotificacoesCommand;
import com.state.lista_notificacoes.BuscaState;

/**
 *
 * @author Vanderson
 */
public class BuscarCommandFactory extends ListaNotificacoesCommandFactory {
    private BuscaState estado;

    public BuscarCommandFactory(BuscaState estado) {
        this.estado = estado;
    }
    
    public IListaNotificacoesCommand criar(){
        return new BuscarCommand(estado);
    }
}
