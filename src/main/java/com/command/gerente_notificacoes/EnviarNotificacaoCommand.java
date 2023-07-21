/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
import com.service.EnvioNotificacaoRepository;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class EnviarNotificacaoCommand extends GerenteNotificacoesCommand{
    private Notificacao notificacao;
    private List<Usuario> usuariosAlvo;
    private UsuarioNotificacao notificacaoUsuarioLogado;

    public UsuarioNotificacao getNotificacaoUsuarioLogado() {
        return notificacaoUsuarioLogado;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void setUsuariosAlvo(List<Usuario> usuariosAlvo) {
        this.usuariosAlvo = usuariosAlvo;
    }
    
    public EnviarNotificacaoCommand(List<UsuarioNotificacao> notificacoesUsuarioLogado){
        super(notificacoesUsuarioLogado);
    }
    
    public void executar(){
        EnvioNotificacaoRepository repositorio = new EnvioNotificacaoRepository(usuariosAlvo, notificacao);
        repositorio.registrarNoBanco();
        notificacaoUsuarioLogado = repositorio.getNotificacaoUsuarioLogado();
    }
}
