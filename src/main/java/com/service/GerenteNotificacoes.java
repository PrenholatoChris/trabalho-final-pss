/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.command.gerente_notificacoes.BuscarNotificacoesCommand;
import com.command.gerente_notificacoes.GerenteNotificacoesCommand;
import com.dao.NotificacaoDAO;
import com.model.Notificacao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class GerenteNotificacoes {
    private Map<String, GerenteNotificacoesCommand> comandos;
    private List<Notificacao> notificacoesUsuarioLogado;
    
    public GerenteNotificacoes(){
        carregarNotificacoes();
        comandos = new HashMap<>();
        comandos.put("Buscar", new BuscarNotificacoesCommand(notificacoesUsuarioLogado));
    }
    
    public List<Notificacao> buscarNotificacoes(List<Integer> codsBusca){
        BuscarNotificacoesCommand comando = (BuscarNotificacoesCommand)comandos.get("Buscar");
        comando.setCodsBusca(codsBusca);
        comando.executar();
        return comando.getNotificacoesEncontradas();
    }
    
    private void carregarNotificacoes(){
//        notificacoesUsuarioLogado = new NotificacaoDAO(). <- Trocar por método que busca as notificações de um usuário.
    }
}
