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
public class AutenticarUsuarioCommand extends GerenteUsuariosCommand {
    private String nome;
    private String senha;
    private Usuario usuarioEncontrado;

    public Usuario getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public AutenticarUsuarioCommand(List<Usuario> usuarios){
        super.usuarios = usuarios;
    }
    
    @Override
    public void executar(){
        for(Usuario usuario : usuarios){
            if(usuario.getNome() == nome && usuario.getSenha() == senha){
                usuarioEncontrado = usuario;
                return;
            }
        }
        usuarioEncontrado = null;
    }
}
