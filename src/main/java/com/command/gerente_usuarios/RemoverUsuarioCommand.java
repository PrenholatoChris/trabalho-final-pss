/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.service.GerenteSessao;
import com.sistemalogger.SistemaLogger;
import com.sistemalogger.TipoOperacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class RemoverUsuarioCommand extends GerenteUsuariosCommand{
    private Usuario usuario;
    private UsuarioDAO dao;
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public RemoverUsuarioCommand(List<Usuario> usuarios, UsuarioDAO dao){
        super.usuarios = usuarios;
        this.dao = dao;
    }
    
    @Override
    public void executar(){
        usuarios.remove(usuario);
        dao.remove(usuario.getUsrCod());
        SistemaLogger.makeInfoLog(TipoOperacao.EXCLUSAO_USUARIO, usuario.getNome(), GerenteSessao.getInstance().getUsuarioLogado().getNome());
    }
}
