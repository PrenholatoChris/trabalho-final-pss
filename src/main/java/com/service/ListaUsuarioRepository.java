/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

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
public class ListaUsuarioRepository {
    List<Usuario> usuarios;
    Notificacao not;
    Integer notCod;
    
    public ListaUsuarioRepository(List<Usuario> usuarios, Notificacao not){
        this.usuarios = usuarios;
        this.not = not;
        registrarNoBanco();
    }
    
    private void registrarNoBanco(){
        Integer notCod = Notificacao.criar(this.not);
        for (Usuario usuario : usuarios) {
            UsuarioNotificacao userNot = new UsuarioNotificacao(usuario.getUsrCod(), notCod);
            UsuarioNotificacao.criar(userNot);
            SistemaLogger.makeInfoLog(TipoOperacao.ENVIANDO_NOTIFICACAO, usuario.getNome(),GerenteSessao.getInstance().getUsuarioLogado().getNome());
        }
    }
}
