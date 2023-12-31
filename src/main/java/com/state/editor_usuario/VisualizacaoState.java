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
import javax.swing.JLabel;

/**
 *
 * @author Vanderson
 */
public class VisualizacaoState extends DependenteUsuarioState{
    
    public VisualizacaoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioVisualizado){
        super(editorUsuario, view, usuarioVisualizado);
        
        carregarBotoes();
        carregarDetalhesUsuario();
        view.update();
    }
    
    @Override
    public void editar(){
        editorUsuario.setEstado(new EdicaoState(editorUsuario, view, usuarioProvido));
    }
    
    @Override
    public void remover(){
        editorUsuario.setEstado(new RemocaoState(editorUsuario, view, usuarioProvido));
    }
    
    private void carregarBotoes(){
        view.getPainelBotoes().removeAll();
        
        JButton botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
        view.getPainelBotoes().add(botaoEditar);
        
        JButton botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remover();
            }
        });
        view.getPainelBotoes().add(botaoRemover);
        
        adicionarBotaoCancelarPadrao();
    }
    
    private void carregarDetalhesUsuario(){
        view.getNomeTextField().setText(usuarioProvido.getNome());
        view.getNomeTextField().setEditable(false);
        
        view.getSenhaTextField().setText(usuarioProvido.getSenha());
        view.getSenhaTextField().setEditable(false);
        
        view.getPainelAuxiliar().removeAll();
        
        JLabel statusAdminLabel = new JLabel(String.format("É Administrador: %s", usuarioProvido.getIsAdmin() ? "SIM" : "NÃO"));
        view.getPainelAuxiliar().add(statusAdminLabel);
        
        JLabel statusAutorizadoLabel = new JLabel(String.format("Está Autorizado: %s", usuarioProvido.getIsAutorizado() ? "SIM" : "NÃO"));
        view.getPainelAuxiliar().add(statusAutorizadoLabel);
    }
}
