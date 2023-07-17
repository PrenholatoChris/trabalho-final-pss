/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.presenter.ListaUsuariosPresenter;
import com.view.ListaUsuariosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Vanderson
 */
public class AutorizacaoState extends ListaUsuariosState {
    
//    public ListaUsuariosView getView(){
//        return view;
//    }
    
    public JTable getTabelaDados(){
        return view.getTabelaDados();
    }
    
    public AutorizacaoState(ListaUsuariosPresenter listaUsuarios, ListaUsuariosView view){
        super.listaUsuarios = listaUsuarios;
        super.view = view;
        
        removerBotoesEstado();
        
        JButton autenticarBotao = new JButton("Autenticar Todos");
        autenticarBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
            }
        });
        view.getPainelBotoes().add(autenticarBotao);
        
        view.getPainelBotoes().revalidate();
        view.getPainelBotoes().repaint();
    }
    
    @Override
    public void retornar(){
        listaUsuarios.setEstado(new BaseState(listaUsuarios, view));
    }
    
    @Override
    public void enviarNotificacao(){
        listaUsuarios.setEstado(new EnvioNotificacaoState(listaUsuarios, view));
    }
}
