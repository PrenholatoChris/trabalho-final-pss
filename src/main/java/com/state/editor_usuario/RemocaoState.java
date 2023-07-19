/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;

/**
 *
 * @author Vanderson
 */
public class RemocaoState extends EditorUsuarioState{
    private Usuario usuarioARemover;
    
    public RemocaoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioARemover){
        super.editorUsuario = editorUsuario;
        super.view = view;
        this.usuarioARemover = usuarioARemover;
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(this);
    }
}
