/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.service.observer.IUsuariosObserver;
import com.state.lista_usuarios.AutorizacaoState;
import com.state.lista_usuarios.BaseState;
import com.state.lista_usuarios.EnvioNotificacaoState;
import com.state.lista_usuarios.ListaUsuariosState;
import com.view.ListaUsuariosView;
import com.view.ModeloVisualTabela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vanderson
 */
public class ListaUsuariosPresenter implements IUsuariosObserver {
    private ListaUsuariosState estado;
    private ListaUsuariosView view;
    
    public void setEstado(ListaUsuariosState estado){
        this.estado = estado;
    }
    
    public ListaUsuariosPresenter(JPanel painelConteudo){
        view = new ListaUsuariosView(painelConteudo);
        estado = new BaseState(this, view);
        
        view.getAdicionarUsuarioBotao().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new EditorUsuarioPresenter(painelConteudo);
            }
        });
        
        view.getEnviarNotificacaoBotao().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                enviarNotificacao();
            }
        });
        
        view.getTabelaDados().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(e.getValueIsAdjusting()){
                    updateTableRowSelection();
                }
            }
        });
    }
    
    @Override
    public void atualizarUsuarios(List<Usuario> usuarios){
        ModeloVisualTabela modeloTabela = (ModeloVisualTabela) view.getTabelaDados().getModel();
        modeloTabela.clearRows();
        for(Usuario usuario : usuarios){
            List<Object> entrada = Arrays.asList(
                usuario.getUsrCod(), usuario.getNome(), usuario.getIsAdmin(), usuario.getIsAutorizado()
            );
            modeloTabela.addRow(entrada);
        }
    }
    
    private void enviarNotificacao(){
        if(view.getTabelaDados().getSelectedRowCount() > 0){
            estado = new EnvioNotificacaoState(this, view);
        }
    }
    
    private void updateTableRowSelection(){
        if(view.getTabelaDados().getSelectedRowCount() < 2 && estado.getClass() != BaseState.class){
            estado = new BaseState(this, view);
        }else if(view.getTabelaDados().getSelectedRowCount() >= 2 && estado.getClass() != AutorizacaoState.class){
            estado = new AutorizacaoState(this, view);
        }
    }
}
