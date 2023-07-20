/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class RodapeView {
    private JButton botaoNotificacoes;
    private JButton botaoAlterarSenha;
    private JLabel informacoesUsuarioLabel;

    public JButton getBotaoAlterarSenha() {
        return botaoAlterarSenha;
    }
    
    public JButton getBotaoNotificacoes() {
        return botaoNotificacoes;
    }

    public JLabel getInformacoesUsuarioLabel() {
        return informacoesUsuarioLabel;
    }
    
    public RodapeView(JPanel painelRodape){
        informacoesUsuarioLabel = new JLabel("");
        painelRodape.add(informacoesUsuarioLabel);
        
        botaoNotificacoes = new JButton("");
        painelRodape.add(botaoNotificacoes);
        
        botaoAlterarSenha = new JButton("Alterar Senha");
        painelRodape.add(botaoAlterarSenha);
    }
}
