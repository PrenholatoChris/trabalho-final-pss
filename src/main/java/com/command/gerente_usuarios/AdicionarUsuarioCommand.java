/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class AdicionarUsuarioCommand extends GerenteUsuariosCommand{
    private Usuario usuarioAdicao;
    private UsuarioDAO dao;
    
    public void setUsuarioAdicao(Usuario usuarioAdicao) {
        this.usuarioAdicao = usuarioAdicao;
    }
    
    public AdicionarUsuarioCommand(List<Usuario> usuarios, UsuarioDAO dao){
        super.usuarios = usuarios;
        this.dao = dao;
    }
    
    @Override
    public void executar(){
        usuarios.add(usuarioAdicao);
        dao.insert(usuarioAdicao);
        usuarioAdicao.setUsrCod(dao.getLastRegister());
    }
}
