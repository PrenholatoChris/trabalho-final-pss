/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vanderson
 */
public class ListaUsuariosView {
    public static final int QTD_BOTOES_FIXOS = 2;
    
    private JButton adicionarUsuarioBotao;
    private JButton enviarNotificacaoBotao;
    private JPanel painelBotoes;
    private JPanel painelConteudo;
    private JTable tabelaDados;

    public JButton getAdicionarUsuarioBotao() {
        return adicionarUsuarioBotao;
    }

    public JButton getEnviarNotificacaoBotao(){
        return enviarNotificacaoBotao;
    }
    
    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public JPanel getPainelConteudo() {
        return painelConteudo;
    }
    
    public JTable getTabelaDados(){
        return tabelaDados;
    }
    
    public ListaUsuariosView(JPanel painelConteudo){
        this.painelConteudo = painelConteudo;
        
        JInternalFrame tela = new JInternalFrame();
        tela.setTitle("Lista de Usuários");
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
        tela.add(painelPrincipal);
        
        JPanel painelTabela = new JPanel();
        painelTabela.setBorder(new EmptyBorder(10, 10, 10, 10));
        painelTabela.setLayout(new GridLayout(0, 1, 15, 15));
        painelPrincipal.add(painelTabela);
        
        tabelaDados = new JTable(new ModeloVisualTabela(Arrays.asList(
            "Código", "Nome", "É Admin", "É Autorizado", "Data de Cadastro"
        )));
        tabelaDados.setFillsViewportHeight(false);
        painelTabela.add(new JScrollPane(tabelaDados));
        
        painelBotoes = new JPanel();
        painelBotoes.setBorder(new EmptyBorder(0, 15, 10, 15));
        painelBotoes.setLayout(new GridLayout(0, 3, 10, 10));
        painelPrincipal.add(painelBotoes);
        
        adicionarUsuarioBotao = new JButton("Adicionar Usuário");
        painelBotoes.add(adicionarUsuarioBotao);
        
        enviarNotificacaoBotao = new JButton("Enviar Notificação");
        painelBotoes.add(enviarNotificacaoBotao);
        
        tela.pack();
        tela.show();
        painelConteudo.add(tela);
    }
}
