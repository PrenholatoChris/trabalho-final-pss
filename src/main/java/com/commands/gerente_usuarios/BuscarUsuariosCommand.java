/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.commands.gerente_usuarios;

import com.dto.UsuarioBuscaDTO;
import com.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class BuscarUsuariosCommand extends GerenteUsuariosCommand{
    private List<Usuario> usuariosEncontrados;
    private UsuarioBuscaDTO buscaDto;

    public List<Usuario> getUsuariosEncontrados() {
        return usuariosEncontrados;
    }

    public void setBuscaDto(UsuarioBuscaDTO buscaDto) {
        this.buscaDto = buscaDto;
    }
    
    public BuscarUsuariosCommand(List<Usuario> usuarios){
        super.usuarios = usuarios;
        this.usuariosEncontrados = new ArrayList<>();
    }
    
    @Override
    public void executar(){
        usuariosEncontrados.clear();
        for(Usuario usuario : usuarios){
            if(verificarUsuarioValido(usuario)){
                usuariosEncontrados.add(usuario);
            }
        }
    }
    
    private boolean verificarUsuarioValido(Usuario usuario){
        if(buscaDto != null){
            if(buscaDto.getNome() != null && usuario.getNome().compareTo(buscaDto.getNome()) != 0){
                return false;
            }
            return buscaDto.getIsAdmin() == null || usuario.getIsAdmin().equals(buscaDto.getIsAdmin());
        }else
            return true;
    }
}
