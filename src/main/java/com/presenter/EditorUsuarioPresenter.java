/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.editor_usuario.EditorUsuarioState;
import com.view.EditorUsuarioView;

/**
 *
 * @author Vanderson
 */
public class EditorUsuarioPresenter {
    private EditorUsuarioView view;
    private EditorUsuarioState estado;
    
    public void setEstado(EditorUsuarioState estado){
        this.estado = estado;
    }
    
    public EditorUsuarioPresenter(){
        this.view = new EditorUsuarioView();
    }
}
