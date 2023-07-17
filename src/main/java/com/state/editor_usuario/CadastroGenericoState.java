/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;
import javax.swing.JButton;

/**
 *
 * @author Vanderson
 */
public class CadastroGenericoState extends EditorUsuarioState{
    
    public CadastroGenericoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view){
        super.editorUsuario = editorUsuario;
        
        JButton botaoConfirmar = new JButton("Confirmar");
        view.getPainelBotoes().add(botaoConfirmar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        view.getPainelBotoes().add(botaoCancelar);
    }
}
