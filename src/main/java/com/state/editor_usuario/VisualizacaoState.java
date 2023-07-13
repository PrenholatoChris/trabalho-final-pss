/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.presenter.EditorUsuarioPresenter;

/**
 *
 * @author Vanderson
 */
public class VisualizacaoState extends EditorUsuarioState{
    
    public VisualizacaoState(EditorUsuarioPresenter editorUsuario){
        super.editorUsuario = editorUsuario;
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
