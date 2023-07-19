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
public abstract class DependenteUsuarioState extends EditorUsuarioState{
    protected Usuario usuarioProvido;
    
    public DependenteUsuarioState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioProvido){
        super(editorUsuario, view);
        this.usuarioProvido = usuarioProvido;
    }
}
