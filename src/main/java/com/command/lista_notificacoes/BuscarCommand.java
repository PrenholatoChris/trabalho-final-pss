/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_notificacoes;

import com.state.lista_notificacoes.BuscaState;

/**
 *
 * @author Vanderson
 */
public class BuscarCommand implements IListaNotificacoesCommand {
    private BuscaState estado;
    
    public BuscarCommand(BuscaState estado){
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
