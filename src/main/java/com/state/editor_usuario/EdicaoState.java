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

/**
 *
 * @author Vanderson
 */
public class EdicaoState extends DependenteUsuarioState{
    private JCheckBox ehAdminBox;
    private JCheckBox ehAuthBox;

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
        return usuarioProvido;
    }
    
    public EdicaoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioAEditar){
        super(editorUsuario, view, usuarioAEditar);
        
        carregarBotoes();
        carregarDetalhesUsuario();
        view.update();
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(new VisualizacaoState(editorUsuario, view, usuarioProvido));
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
        view.getNomeTextField().setText(usuarioProvido.getNome());
        view.getNomeTextField().setEditable(true);
        
        view.getSenhaTextField().setText(usuarioProvido.getSenha());
        view.getSenhaTextField().setEditable(true);
        
        view.getPainelAuxiliar().removeAll();
        
        ehAdminBox = new JCheckBox("É Administrador", usuarioProvido.getIsAdmin());
        view.getPainelAuxiliar().add(ehAdminBox);
        
        ehAuthBox = new JCheckBox("Está Autorizado", usuarioProvido.getIsAutorizado());
        view.getPainelAuxiliar().add(ehAuthBox);
    }
}
