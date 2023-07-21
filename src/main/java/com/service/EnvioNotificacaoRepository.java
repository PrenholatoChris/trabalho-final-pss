/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.UsuarioNotificacaoDAO;
import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
import com.sistemalogger.SistemaLogger;
import com.sistemalogger.TipoOperacao;
import java.util.List;

/**
 *
 * @author chris
 */
public class EnvioNotificacaoRepository {
    Integer notCod;
    Notificacao notificacao;
    List<Usuario> usuarios;
    
    public UsuarioNotificacao getNotificacaoUsuarioLogado(){
        Usuario usuarioLogado = GerenteSessao.getInstance().getUsuarioLogado();
        if(usuarios.contains(usuarioLogado)){
            return new UsuarioNotificacao(new UsuarioNotificacaoDAO().getLastRegister(), usuarioLogado.getUsrCod(), notCod, false,
                    notificacao.getMensagem(), notificacao.getTitulo());
        }
        return null;
    }
    
    public EnvioNotificacaoRepository(List<Usuario> usuarios, Notificacao not){
        this.usuarios = usuarios;
        this.notificacao = not;
    }
    
    public void registrarNoBanco(){
        notCod = Notificacao.criar(this.notificacao);
        for (Usuario usuario : usuarios) {
            UsuarioNotificacao userNot = new UsuarioNotificacao(usuario.getUsrCod(), notCod);
            UsuarioNotificacao.criar(userNot);
            SistemaLogger.makeInfoLog(TipoOperacao.ENVIANDO_NOTIFICACAO, usuario.getNome(),GerenteSessao.getInstance().getUsuarioLogado().getNome());
        }
    }
}
