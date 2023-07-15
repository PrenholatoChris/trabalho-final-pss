/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.presenter.ListaUsuariosPresenter;
import com.view.ListaUsuariosView2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Vanderson
 */
public class BaseState extends ListaUsuariosState {
    
    public BaseState(ListaUsuariosPresenter listaUsuarios, ListaUsuariosView2 view){
        super.listaUsuarios = listaUsuarios;
        super.view = view;
        
        removerBotoesEstado();
        
        JButton autenticarBotao = new JButton("Autenticar");
        autenticarBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(view.getTabelaDados().getSelectedRowCount() > 0){
                    AutorizacaoState autorizacaoState = new AutorizacaoState(listaUsuarios, view);
                    listaUsuarios.setEstado(autorizacaoState);
                    autorizacaoState.executar();
                }
            }
        });
        view.getPainelBotoes().add(autenticarBotao);
        
        JButton visualizarBotao = new JButton("Visualizar");
        view.getPainelBotoes().add(visualizarBotao);
        
        JButton editarBotao = new JButton("Editar");
        view.getPainelBotoes().add(editarBotao);
        
        view.getPainelBotoes().revalidate();
        view.getPainelBotoes().repaint();
    }
    
    @Override
    public void autorizar(){
        listaUsuarios.setEstado(new AutorizacaoState(listaUsuarios, view));
    }
}
