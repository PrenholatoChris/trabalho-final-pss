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
public class ListaUsuariosView2 {
    JTable tabelaDados;
    
    public JTable getTabelaDados(){
        return tabelaDados;
    }
    
    public ListaUsuariosView2(JPanel painelConteudo){
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
            "Código", "Nome", "É Admin", "É Autorizado"
        )));
        tabelaDados.setFillsViewportHeight(false);
        painelTabela.add(new JScrollPane(tabelaDados));
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(new EmptyBorder(0, 15, 10, 0));
        painelBotoes.setLayout(new GridLayout(0, 3, 10, 10));
        painelPrincipal.add(painelBotoes);
        
        JButton visualizarBotao = new JButton("Visualizar");
        painelBotoes.add(visualizarBotao);
        
        JButton eidtarBotao = new JButton("Editar");
        painelBotoes.add(eidtarBotao);
        
        tela.pack();
        tela.show();
        painelConteudo.add(tela);
    }
}
