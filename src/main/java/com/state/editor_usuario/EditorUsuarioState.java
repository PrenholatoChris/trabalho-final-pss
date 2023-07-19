/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.command.factory.editor_usuario.EditorUsuarioCommandFactory;
import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Vanderson
 */
public abstract class EditorUsuarioState {
    protected EditorUsuarioPresenter editorUsuario;
    protected EditorUsuarioView view;
    
    public String getNomeInserido(){
        return view.getNomeTextField().getText();
    }
    
    public String getSenhaInserida(){
        return view.getSenhaTextField().getText();
    }
    
    public EditorUsuarioState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view){
        this.editorUsuario = editorUsuario;
        this.view = view;
    }
    
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
    
    protected void adicionarBotaoCancelarPadrao(){
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.close();
            }
        });
        view.getPainelBotoes().add(botaoCancelar);
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
