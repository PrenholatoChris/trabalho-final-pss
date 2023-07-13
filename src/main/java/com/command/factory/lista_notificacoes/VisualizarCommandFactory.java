/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_notificacoes;

import com.command.lista_notificacoes.IListaNotificacoesCommand;
import com.command.lista_notificacoes.VisualizarCommand;
import com.state.lista_notificacoes.VisualizacaoState;

/**
 *
 * @author Vanderson
 */
public class VisualizarCommandFactory extends ListaNotificacoesCommandFactory {
    private VisualizacaoState estado;

    public VisualizarCommandFactory(VisualizacaoState estado) {
        this.estado = estado;
    }
    
    public IListaNotificacoesCommand criar(){
        return new VisualizarCommand(estado);
    }
}
