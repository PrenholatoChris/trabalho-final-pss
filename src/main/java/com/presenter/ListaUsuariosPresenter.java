/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.service.observer.IUsuariosObserver;
import com.state.lista_usuarios.ListaUsuariosState;
import com.view.ListaUsuariosView;
import com.view.ListaUsuariosView2;
import com.view.ModeloVisualTabela;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class ListaUsuariosPresenter implements IUsuariosObserver {
    private ListaUsuariosState estado;
    private ListaUsuariosView2 view;
    
    public void setEstado(ListaUsuariosState estado){
        this.estado = estado;
    }
    
    public ListaUsuariosPresenter(JPanel painelConteudo){
        view = new ListaUsuariosView2(painelConteudo);
    }
    
    @Override
    public void atualizarUsuarios(List<Usuario> usuarios){
        ModeloVisualTabela modeloTabela = (ModeloVisualTabela) view.getTabelaDados().getModel();
        modeloTabela.clearRows();
        for(Usuario usuario : usuarios){
            List<Object> entrada = Arrays.asList(
                usuario.getUsrCod(), usuario.getNome(), usuario.getIsAdmin(), true
            );
            modeloTabela.addRow(entrada);
        }
    }
}
