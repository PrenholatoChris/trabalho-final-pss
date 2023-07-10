/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.commands.gerente_usuarios;

import com.model.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class BuscarUsuariosCommand extends GerenteUsuariosCommand{
    private List<Usuario> usuariosEncontrados;
    private Map<String, Object> valoresPorAtributo;

    public List<Usuario> getUsuariosEncontrados() {
        return usuariosEncontrados;
    }

    public void setValoresPorAtributo(Map<String, Object> valoresPorAtributo) {
        this.valoresPorAtributo = valoresPorAtributo;
    }
    
    public BuscarUsuariosCommand(List<Usuario> usuarios){
        super.usuarios = usuarios;
    }
    
    @Override
    public void executar(){
        int index = 0;
        ArrayList<Usuario> usuariosRemovidos = new ArrayList<>();
        usuariosEncontrados = new ArrayList<>(usuarios);
        for(Usuario usuario : usuarios){
            boolean foiAdicionado = false;
            index = 0;
            while(index < valoresPorAtributo.size() && !foiAdicionado){
                String atributo = (String)valoresPorAtributo.keySet().toArray()[index];
                switch(atributo){
                    case "nome":
                        if(usuario.getNome().compareTo((String)valoresPorAtributo.get(atributo)) != 0){
                            usuariosRemovidos.add(usuario);
                            foiAdicionado = true;
                        }
                        break;
                    case "senha":
                        if(usuario.getSenha().compareTo((String)valoresPorAtributo.get(atributo)) != 0){
                            usuariosRemovidos.add(usuario);
                            foiAdicionado = true;
                        }
                        break;
                    case "isAdmin":
                        if(!usuario.getIsAdmin().equals((Boolean)valoresPorAtributo.get(atributo))){
                            usuariosRemovidos.add(usuario);
                            foiAdicionado = true;
                        }
                        break;
                }
            }
        }
        for(Usuario usuarioRemovido : usuariosRemovidos){
            usuariosEncontrados.remove(usuarioRemovido);
        }
    }
}
