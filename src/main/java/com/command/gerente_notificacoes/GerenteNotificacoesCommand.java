/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.model.Notificacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public abstract class GerenteNotificacoesCommand {
    protected List<Notificacao> notificacoesUsuarioLogado;
    
    public abstract void executar();
}
