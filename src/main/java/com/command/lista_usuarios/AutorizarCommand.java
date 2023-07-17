/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.service.GerenteUsuarios;
import com.state.lista_usuarios.AutorizacaoState;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class AutorizarCommand implements IListaUsuariosCommand{
    private AutorizacaoState estado;

    public AutorizarCommand(AutorizacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        List<Integer> codsUsuarioBuscar = new ArrayList<>();
        for(int rowIndex : estado.getTabelaDados().getSelectedRows()){
            codsUsuarioBuscar.add((Integer)estado.getTabelaDados().getModel().getValueAt(rowIndex, 0));
        }
        List<Usuario> usuariosParaAutorizar = GerenteUsuarios.getInstance().buscarUsuarios(codsUsuarioBuscar);
        for(Usuario usuario : usuariosParaAutorizar){
            usuario.setIsAutorizado(Boolean.TRUE);
            new UsuarioDAO().update(usuario);
        }
    }
}
