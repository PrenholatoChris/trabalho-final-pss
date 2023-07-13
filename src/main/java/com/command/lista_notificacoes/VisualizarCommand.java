/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_notificacoes;

import com.state.lista_notificacoes.VisualizacaoState;

/**
 *
 * @author Vanderson
 */
public class VisualizarCommand implements IListaNotificacoesCommand {
    private VisualizacaoState estado;
    
    public VisualizarCommand(VisualizacaoState estado){
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
