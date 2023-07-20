/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.model.Notificacao;
import com.model.UsuarioNotificacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public abstract class GerenteNotificacoesCommand {
    protected List<UsuarioNotificacao> notificacoesUsuarioLogado;
    
    public GerenteNotificacoesCommand(List<UsuarioNotificacao> notificacoesUsuarioLogado){
        this.notificacoesUsuarioLogado = notificacoesUsuarioLogado;
    }
    
    public abstract void executar();
}
