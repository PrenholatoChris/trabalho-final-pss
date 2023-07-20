/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.model.Notificacao;
import com.model.Usuario;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class EnviarNotificacaoCommand extends GerenteNotificacoesCommand{
    private Notificacao notificacao;
    private List<Usuario> usuariosAlvo;

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void setUsuariosAlvo(List<Usuario> usuariosAlvo) {
        this.usuariosAlvo = usuariosAlvo;
    }
    
    public EnviarNotificacaoCommand(List<Notificacao> notificacoesUsuarioLogado){
        super(notificacoesUsuarioLogado);
    }
    
    public void executar(){
        
    }
}
