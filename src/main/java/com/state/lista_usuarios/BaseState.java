/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.presenter.ListaUsuariosPresenter;
import com.service.GerenteUsuarios;
import com.view.ListaUsuariosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

/**
 *
 * @author Vanderson
 */
public class BaseState extends ListaUsuariosState {
    
    public BaseState(ListaUsuariosPresenter listaUsuarios, ListaUsuariosView view){
        super.listaUsuarios = listaUsuarios;
        super.view = view;
        
        removerBotoesEstado();
        
        JButton autenticarBotao = new JButton("Autenticar");
        autenticarBotao.addActionListener(new ActionListener(){ // <- Esta porra não tá funcionando.
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
        visualizarBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(view.getTabelaDados().getSelectedRowCount() == 1){
                    Usuario usuarioSelecionado = GerenteUsuarios.getInstance().buscarUsuario(getCodsUsuariosSelecionados().get(0));
                    new EditorUsuarioPresenter(view.getPainelConteudo(), usuarioSelecionado);
                }
            }
        });
        view.getPainelBotoes().add(visualizarBotao);
        
        view.getPainelBotoes().revalidate();
        view.getPainelBotoes().repaint();
    }
    
    @Override
    public void autorizar(){
        listaUsuarios.setEstado(new AutorizacaoState(listaUsuarios, view));
    }
}
