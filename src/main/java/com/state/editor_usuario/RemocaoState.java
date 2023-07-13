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
public class RemocaoState extends EditorUsuarioState{
    
    public RemocaoState(EditorUsuarioPresenter editorUsuario){
        super.editorUsuario = editorUsuario;
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(this);
    }
}
