/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Vanderson
 */
public class CadastroGenericoState extends EditorUsuarioState{
    
    public CadastroGenericoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view){
        super.editorUsuario = editorUsuario;
        super.view = view;
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
            }
        });
        view.getPainelBotoes().add(botaoConfirmar);
        
        adicionarBotaoCancelarPadrao();
    }
}
