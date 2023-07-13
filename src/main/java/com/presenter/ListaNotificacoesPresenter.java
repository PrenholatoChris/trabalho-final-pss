/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.lista_notificacoes.ListaNotificacoesState;
import com.view.ListaNotificacoesView;

/**
 *
 * @author Vanderson
 */
public class ListaNotificacoesPresenter {
    private ListaNotificacoesState estado;
    private ListaNotificacoesView view;

    public void setEstado(ListaNotificacoesState estado) {
        this.estado = estado;
    }
    
    public ListaNotificacoesPresenter(){
        this.view = new ListaNotificacoesView();
    }
}
