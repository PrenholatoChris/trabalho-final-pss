/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.services;

import com.model.Notificacao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class GerenteNotificacoes {
    private List<Notificacao> notificacoesUsuarioLogado;
    
    public GerenteNotificacoes(){
        carregarNotificacoes();
    }
    
    public void BuscaNotificacoes(Map<String, Object> valoresPorAtributo){
        
    }
    
    private void carregarNotificacoes(){
        /*VANDERSON: Aqui seria necessário um método que buscasse todas as notificações de um usuário. Provavelmente vai ser necessário uma classe Facade ou Repository para
        subdividir essa busca em um conjunto de buscas menores nas DAOs especificas.
        */
    }
}
