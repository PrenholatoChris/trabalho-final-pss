/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.model.Usuario;
import com.presenter.ListaUsuariosPresenter;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class BuscaState extends ListaUsuariosState {
    private List<Usuario> usuariosEncontrados;
    
    public BuscaState(ListaUsuariosPresenter listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public void autorizar(){
        listaUsuarios.setEstado(new AutorizacaoState(listaUsuarios));
    }
}
