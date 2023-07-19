/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vanderson
 */
public class EditorUsuarioView {
    JInternalFrame tela;
    JPanel painelAuxiliar;
    JPanel painelConteudo;
    JPanel painelPrincipal;
    JPanel painelBotoes;
    JTextField nomeTextField;
    JTextField senhaTextField;

//    public JPanel getPainelConteudo() {
//        return painelConteudo;
//    }

    public JPanel getPainelAuxiliar() {
        return painelAuxiliar;
    }

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public JTextField getSenhaTextField() {
        return senhaTextField;
    }
    
    public EditorUsuarioView(JPanel painelConteudo){
        this.painelConteudo = painelConteudo;
        
        tela = new JInternalFrame();
        tela.setTitle("Editor Usuários");
        
        painelPrincipal = new JPanel();
        painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
        tela.add(painelPrincipal);
        
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        painelPrincipal.add(painelFormulario);
        
        JPanel painelLabels = new JPanel();
        painelLabels.setLayout(new GridLayout(0, 1, 5, 15));
        painelLabels.add(new JLabel("Nome: "));
        painelLabels.add(new JLabel("Senha: "));
        painelFormulario.add(painelLabels);
        
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(0, 1, 5, 15));
        painelFormulario.add(painelCampos);
        
        nomeTextField = new JTextField();
        nomeTextField.setColumns(25);
        painelCampos.add(nomeTextField);
        senhaTextField = new JTextField();
        senhaTextField.setColumns(25);
        painelCampos.add(senhaTextField);
        
        painelAuxiliar = new JPanel();
        painelAuxiliar.setBorder(new EmptyBorder(10, 5, 15, 5));
        painelAuxiliar.setLayout(new GridLayout(0, 2, 10, 10));
        painelPrincipal.add(painelAuxiliar);
        
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(0, 3, 10, 20));
        painelPrincipal.add(painelBotoes);
        
        tela.pack();
        tela.show();
        painelConteudo.add(tela);
    }
    
    public void close(){
        painelConteudo.remove(tela);
        painelConteudo.revalidate();
        painelConteudo.repaint();
    }
    
    public void update(){
        painelPrincipal.revalidate();
        painelPrincipal.repaint();
    }
}
