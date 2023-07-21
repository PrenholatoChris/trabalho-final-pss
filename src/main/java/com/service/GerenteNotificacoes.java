/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.command.gerente_notificacoes.EnviarNotificacaoCommand;
import com.command.gerente_notificacoes.GerenteNotificacoesCommand;
import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
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
    private List<UsuarioNotificacao> notificacoesUsuarioLogado;
    
    public static GerenteNotificacoes getInstance(){
        if(instance == null){
            instance = new GerenteNotificacoes();
            GerenteSessao.getInstance().addObserver(instance);
        }
        return instance;
    }
    
    public List<UsuarioNotificacao> getNotificacoesUsuarioLogado(){
        return notificacoesUsuarioLogado;
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
        if(usuarioLogado != null){
            notificacoesUsuarioLogado = UsuarioNotificacao.getNotificationsOfUser(usuarioLogado.getUsrCod());
            notificarObservers();
        }
    }
    
    public void enviarNotificacao(Notificacao notificacao, List<Usuario> usuariosAlvo){
        EnviarNotificacaoCommand comando = (EnviarNotificacaoCommand)comandos.get("Enviar");
        UsuarioNotificacao notUsuarioLogado;
        comando.setNotificacao(notificacao);
        comando.setUsuariosAlvo(usuariosAlvo);
        comando.executar();
        notUsuarioLogado = comando.getNotificacaoUsuarioLogado();
        if(notUsuarioLogado != null){
            notificacoesUsuarioLogado.add(notUsuarioLogado);
            notificarObservers();
        }
    }
    
    public void lerNotificacao(int indexNotificacao){
        UsuarioNotificacao usrNot = notificacoesUsuarioLogado.get(indexNotificacao);
        usrNot.setWasRead(true);
        usrNot.update();
        notificarObservers();
    }
    
    private void notificarObservers(){
        for(INotificacoesCarregadasObserver observer : observers){
            observer.atualizarNotificacoesCarregadas(notificacoesUsuarioLogado);
        }
    }
}
