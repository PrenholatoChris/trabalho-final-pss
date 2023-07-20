/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.command.gerente_notificacoes.EnviarNotificacaoCommand;
import com.command.gerente_notificacoes.GerenteNotificacoesCommand;
import com.model.Notificacao;
import com.model.Usuario;
import com.service.observer.INotificacoesCarregadasObserver;
import com.service.observer.ISessaoObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class GerenteNotificacoes implements ISessaoObserver {
    private static GerenteNotificacoes instance;
    private Map<String, GerenteNotificacoesCommand> comandos;
    private List<INotificacoesCarregadasObserver> observers;
    private List<Notificacao> notificacoesUsuarioLogado;
    
    public static GerenteNotificacoes getInstance(){
        if(instance == null){
            instance = new GerenteNotificacoes();
            GerenteSessao.getInstance().addObserver(instance);
        }
        return instance;
    }
    
    private GerenteNotificacoes(){
        comandos = new HashMap<>();
        observers = new ArrayList<>();
        notificacoesUsuarioLogado = new ArrayList<>();
        
        comandos.put("Enviar", new EnviarNotificacaoCommand(notificacoesUsuarioLogado));
    }
    
    public void addObserver(INotificacoesCarregadasObserver observer){
        observers.add(observer);
    }
    
    public void removeObserver(INotificacoesCarregadasObserver observer){
        observers.remove(observer);
    }
    
//    public List<Notificacao> buscarNotificacoes(List<Integer> codsBusca){
//        BuscarNotificacoesCommand comando = (BuscarNotificacoesCommand)comandos.get("Buscar");
//        comando.setCodsBusca(codsBusca);
//        comando.executar();
//        return comando.getNotificacoesEncontradas();
//    }

    @Override
    public void atualizarSessao(Usuario usuarioLogado){
        carregarNotificacoesUsuario(usuarioLogado);
    }
    
    public void enviarNotificacao(Notificacao notificacao, List<Usuario> usuariosAlvo){
        EnviarNotificacaoCommand comando = (EnviarNotificacaoCommand)comandos.get("Enviar");
        comando.setNotificacao(notificacao);
        comando.setUsuariosAlvo(usuariosAlvo);
        comando.executar();
        if(usuariosAlvo.contains(GerenteSessao.getInstance().getUsuarioLogado())){
            notificarObservers();
        }
    }
    
    private void carregarNotificacoesUsuario(Usuario usuario){
        notificacoesUsuarioLogado = new ArrayList<>();
        notificarObservers();
    }
    
    private void notificarObservers(){
        for(INotificacoesCarregadasObserver observer : observers){
            observer.atualizarNotificacoesCarregadas(notificacoesUsuarioLogado);
        }
    }
}
