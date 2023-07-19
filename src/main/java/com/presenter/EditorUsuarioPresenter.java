/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.state.editor_usuario.CadastroGenericoState;
import com.state.editor_usuario.EditorUsuarioState;
import com.state.editor_usuario.VisualizacaoState;
import com.view.EditorUsuarioView;
import javax.swing.JPanel;

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
    
    public EditorUsuarioPresenter(JPanel painelConteudo){
        this.view = new EditorUsuarioView(painelConteudo);
        estado = new CadastroGenericoState(this, view);
    }
    
    public EditorUsuarioPresenter(JPanel painelConteudo, Usuario usuario){
        this.view = new EditorUsuarioView(painelConteudo);
        estado = new VisualizacaoState(this, view, usuario);
    }
}
