/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.commands.gerente_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class RemoverUsuarioCommand extends GerenteUsuariosCommand{
    private int usuarioCod;
    private UsuarioDAO dao;
    
    public void setUsuarioCod(int usuarioCod){
        this.usuarioCod = usuarioCod;
    }
    
    public RemoverUsuarioCommand(List<Usuario> usuarios, UsuarioDAO dao){
        super.usuarios = usuarios;
        this.dao = dao;
    }
    
    @Override
    public void executar(){
        int index;
        for(index = 0; index < usuarios.size(); index++){
            if(usuarios.get(index).getUsrCod() == usuarioCod){
                break;
            }
        }
        usuarios.remove(index);
        dao.remove(usuarioCod);
    }
}
