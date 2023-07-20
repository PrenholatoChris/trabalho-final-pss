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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Integer> codsUsuarioBuscar = estado.getCodsUsuariosSelecionados();
        List<Usuario> usuariosParaAutorizar = GerenteUsuarios.getInstance().buscarUsuarios(codsUsuarioBuscar);
        Map<String, Object> novosDados = new HashMap<>();
        novosDados.put("ehAutorizado", Boolean.TRUE);
        for(Usuario usuario : usuariosParaAutorizar){
            GerenteUsuarios.getInstance().atualizarUsuario(usuario, novosDados);
        }
    }
}
