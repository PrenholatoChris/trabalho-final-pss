/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class TelaPrincipalView {
    final private JPanel painelConteudo;
    final private JPanel painelRodape;
    
    public JPanel getPainelConteudo(){
        return painelConteudo;
    }

    public JPanel getPainelRodape() {
        return painelRodape;
    }
    
    public TelaPrincipalView(){
        JDesktopPane desktop = new JDesktopPane();
        desktop.setLayout(new BorderLayout(0, 10));
        
        JFrame frame = new JFrame();
        frame.setTitle("Tela Principal");
        frame.setSize(1500, 1000);
        frame.setContentPane(desktop);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        painelConteudo = new JPanel();
        desktop.add(painelConteudo, BorderLayout.CENTER);
        
        painelRodape = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        painelRodape.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        desktop.add(painelRodape, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
}
