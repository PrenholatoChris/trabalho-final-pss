/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.command.factory.lista_usuarios.ListaUsuariosCommandFactory;
import com.presenter.ListaUsuariosPresenter;
import com.view.ListaUsuariosView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public abstract class ListaUsuariosState {
    protected ListaUsuariosPresenter listaUsuarios;
    protected ListaUsuariosView view;
    
    public void autorizar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Autorizacao.");
    }
    
    public void retornar() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Base.");
    }
    
    public void enviarNotificacao() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Envio Notificação.");
    }
    
    public void executar(){
        ListaUsuariosCommandFactory.getFactory(this).criar().executar();
    }
    
//    public int[] getIndicesLinhasUsuarioSelecionadas(){
//        return view.getTabelaDados().getSelectedRows();
//    }
//    
//    public Integer getCodUsuarioPorLinha(int index){
//        return (Integer)view.getTabelaDados().getModel().getValueAt(index, 0);
//    }
    
    public List<Integer> getCodsUsuariosSelecionados(){
        List<Integer> codsUsuarios = new ArrayList<>();
        for(int index : view.getTabelaDados().getSelectedRows()){
            codsUsuarios.add((Integer)view.getTabelaDados().getModel().getValueAt(index, 0));
        }
        return codsUsuarios;
    }
    
    protected void removerBotoesEstado(){
        while(view.getPainelBotoes().getComponentCount() > ListaUsuariosView.QTD_BOTOES_FIXOS){
            int index = view.getPainelBotoes().getComponentCount() - 1;
            view.getPainelBotoes().remove(index);
        }
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
