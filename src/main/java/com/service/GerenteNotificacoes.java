/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.command.gerente_notificacoes.BuscarNotificacoesCommand;
import com.command.gerente_notificacoes.GerenteNotificacoesCommand;
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
    
//    public List<Notificacao> buscarNotificacoes(NotificacaoBuscaDTO buscaDto){
//        BuscarNotificacoesCommand comando = (BuscarNotificacoesCommand)comandos.get("Buscar");
//        comando.setBuscaDto(buscaDto);
//        comando.executar();
//        return comando.getNotificacoesEncontradas();
//    }
    
    private void carregarNotificacoes(){
        /*VANDERSON: Aqui seria necessário um método que buscasse todas as notificações de um usuário. Provavelmente vai ser necessário uma classe Facade ou Repository para
        subdividir essa busca em um conjunto de buscas menores nas DAOs especificas.
        */
    }
}
