/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.service.GerenteUsuarios;
import com.state.editor_usuario.CadastroGenericoState;
import com.state.editor_usuario.CadastroInicialState;
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
        
        if(GerenteUsuarios.getInstance().getQtdUsuarios() > 0){
            estado = new CadastroGenericoState(this, view);
        }else{
            estado = new CadastroInicialState(this, view);
        }
        
    }
    
    public EditorUsuarioPresenter(JPanel painelConteudo, Usuario usuario){
        estado = new VisualizacaoState(this, usuario);
        
        this.view = new EditorUsuarioView(painelConteudo);
    }
}
