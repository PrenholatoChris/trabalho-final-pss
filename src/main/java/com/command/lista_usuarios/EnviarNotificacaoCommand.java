/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_usuarios;

import com.model.Notificacao;
import com.service.GerenteNotificacoes;
import com.state.lista_usuarios.EnvioNotificacaoState;

/**
 *
 * @author Vanderson
 */
public class EnviarNotificacaoCommand implements IListaUsuariosCommand{
    private EnvioNotificacaoState estado;

    public EnviarNotificacaoCommand(EnvioNotificacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        Notificacao notificacao = new Notificacao(estado.getTitulo(), estado.getMensagem());
        GerenteNotificacoes.getInstance().enviarNotificacao(notificacao, estado.getUsuariosAlvo());
    }
}
