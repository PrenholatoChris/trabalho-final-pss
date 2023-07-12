/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class TelaPrincipalView {
    private JPanel painelConteudo;
    
    public JPanel getPainelConteudo(){
        return painelConteudo;
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
        
        frame.setVisible(true);
    }
}
