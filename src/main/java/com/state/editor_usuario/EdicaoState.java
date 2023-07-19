/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Vanderson
 */
public class EdicaoState extends EditorUsuarioState{
    private JCheckBox ehAdminBox;
    private JCheckBox ehAuthBox;
    private Usuario usuarioAEditar;

    public Boolean getStatusAdministrador(){
        return ehAdminBox.isSelected();
    }
    
    public Boolean getStatusAutorizado(){
        return ehAuthBox.isSelected();
    }
    
    public String getNovoNome(){
        return view.getNomeTextField().getText();
    }
    
    public String getNovaSenha(){
        return view.getSenhaTextField().getText();
    }
    
    public Usuario getUsuarioAEditar() {
        return usuarioAEditar;
    }
    
    public EdicaoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioAEditar){
        super.editorUsuario = editorUsuario;
        super.view = view;
        this.usuarioAEditar = usuarioAEditar;
        
        carregarBotoes();
        carregarDetalhesUsuario();
        view.update();
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(new VisualizacaoState(editorUsuario, view, usuarioAEditar));
    }
    
    private void carregarBotoes(){
        view.getPainelBotoes().removeAll();
        
        JButton botaoEditar = new JButton("Confirmar");
        botaoEditar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
            }
        });
        view.getPainelBotoes().add(botaoEditar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                visualizar();
            }
        });
        view.getPainelBotoes().add(botaoCancelar);
    }
    
    private void carregarDetalhesUsuario(){
        view.getNomeTextField().setText(usuarioAEditar.getNome());
        view.getNomeTextField().setEditable(true);
        
        view.getSenhaTextField().setText(usuarioAEditar.getSenha());
        view.getSenhaTextField().setEditable(true);
        
        view.getPainelAuxiliar().removeAll();
        
        ehAdminBox = new JCheckBox("É Administrador", usuarioAEditar.getIsAdmin());
        view.getPainelAuxiliar().add(ehAdminBox);
        
        ehAuthBox = new JCheckBox("Está Autorizado", usuarioAEditar.getIsAutorizado());
        view.getPainelAuxiliar().add(ehAuthBox);
    }
}
