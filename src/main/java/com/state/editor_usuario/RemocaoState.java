/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.editor_usuario;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.view.EditorUsuarioView;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class RemocaoState extends DependenteUsuarioState{

    public Usuario getUsuarioARemover() {
        return usuarioProvido;
    }
    
    public RemocaoState(EditorUsuarioPresenter editorUsuario, EditorUsuarioView view, Usuario usuarioARemover){
        super(editorUsuario, view, usuarioARemover);
        
        exibirAvisoExclusao();
    }
    
    @Override
    public void visualizar(){
        editorUsuario.setEstado(new VisualizacaoState(editorUsuario, view, usuarioProvido));
    }
    
    private void exibirAvisoExclusao(){
        JDialog avisoExclusao = new JDialog(view.getTela(), "Aviso Exclusão");
        avisoExclusao.setResizable(false);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        avisoExclusao.add(painelPrincipal);
        
        JPanel painelLabel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 5));
        painelPrincipal.add(painelLabel);
        
        JLabel avisoLabel = new JLabel(String.format("Você está prestes a excluir o usuário %s. Tem certeza que deseja continuar?", usuarioProvido.getNome()));
        painelLabel.add(avisoLabel);
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 5));
        painelPrincipal.add(painelBotoes);
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
                avisoExclusao.dispose();
                view.close();
            }
        });
        painelBotoes.add(botaoConfirmar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                avisoExclusao.dispose();
                visualizar();
            }
        });
        painelBotoes.add(botaoCancelar);
        
        avisoExclusao.pack();
        avisoExclusao.setVisible(true);
    }
}
