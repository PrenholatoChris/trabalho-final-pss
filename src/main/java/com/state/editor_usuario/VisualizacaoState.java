/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;

/**
 *
 * @author Vanderson
 */
public class VisualizacaoState extends EditorUsuarioState{
    private Usuario usuarioVisualizado;
    
    public VisualizacaoState(EditorUsuarioPresenter editorUsuario, Usuario usuarioVisualizado){
        super.editorUsuario = editorUsuario;
        this.usuarioVisualizado = usuarioVisualizado;
    }
    
    @Override
    public void editar(){
        editorUsuario.setEstado(this);
    }
    
    @Override
    public void remover(){
        editorUsuario.setEstado(this);
    }
}
