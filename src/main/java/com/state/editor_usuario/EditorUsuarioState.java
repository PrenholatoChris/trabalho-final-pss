/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.command.factory.editor_usuario.EditorUsuarioCommandFactory;
import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;

/**
 *
 * @author Vanderson
 */
public abstract class EditorUsuarioState {
    protected EditorUsuarioPresenter editorUsuario;
    
    public void editar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Edição.");
    }
    
    public void visualizar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Visualização.");
    }
    
    public void remover() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Remoção.");
    }
    
    public void executar(){
        EditorUsuarioCommandFactory.getFactory(this).criar().executar();
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
