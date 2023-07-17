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
public class EdicaoState extends EditorUsuarioState{
    private Usuario usuarioEditado;
    
    public EdicaoState(EditorUsuarioPresenter editorUsuario, Usuario usuarioVisualizado){
        super.editorUsuario = editorUsuario;
        this.usuarioEditado = usuarioVisualizado;
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(this);
    }
}
