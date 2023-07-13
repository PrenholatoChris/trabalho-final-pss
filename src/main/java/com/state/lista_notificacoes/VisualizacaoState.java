/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_notificacoes;

import com.presenter.ListaNotificacoesPresenter;

/**
 *
 * @author Vanderson
 */
public class VisualizacaoState extends ListaNotificacoesState{
    
    public VisualizacaoState(ListaNotificacoesPresenter listaNotificacoes){
        super.listaNotificacoes = listaNotificacoes;
    }
    
    @Override
    public void buscar(){
        listaNotificacoes.setEstado(new BuscaState(listaNotificacoes));
    }
}
