/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class BuscarUsuariosCommand extends GerenteUsuariosCommand{
    private List<Usuario> usuariosEncontrados;
    private List<Integer> codsBusca;

    public List<Usuario> getUsuariosEncontrados() {
        return usuariosEncontrados;
    }

    public void setCodsBusca(List<Integer> codsBusca) {
        this.codsBusca = codsBusca;
    }
    
    public BuscarUsuariosCommand(List<Usuario> usuarios){
        super.usuarios = usuarios;
        this.usuariosEncontrados = new ArrayList<>();
    }
    
    @Override
    public void executar(){
        usuariosEncontrados.clear();
        for(Usuario usuario : usuarios){
            Integer codigoUsado = null;
            for(int codigo : codsBusca){
                if(usuario.getUsrCod() == codigo){
                    usuariosEncontrados.add(usuario);
                    codigoUsado = codigo;
                    break;
                }
            }
            if(codigoUsado != null){
                codsBusca.remove(codigoUsado);
            }
        }
    }
}
