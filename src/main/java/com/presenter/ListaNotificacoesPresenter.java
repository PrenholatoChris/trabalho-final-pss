/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.lista_notificacoes.ListaNotificacoesState;
import com.view.ListaNotificacoesView;

import com.model.Notificacao;
import com.model.Usuario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vanderson
 */
public class ListaNotificacoesPresenter {
    private ListaNotificacoesState estado;
    private ListaNotificacoesView view;
    Usuario usuarioLogado;

    public void setEstado(ListaNotificacoesState estado) {
        this.estado = estado;
    }
    
    public ListaNotificacoesPresenter(){
        //Supondo que o usuario Cod 1 esta logado
        usuarioLogado = Usuario.getUser(1);
        
        this.view = new ListaNotificacoesView();
        view.setVisible(true);

        atualizar();
    }

    public ListaNotificacoesView getView(){
        return view;
    }
    
    private void atualizar(){
        JTable tabela = view.getNotificationTable();
        DefaultTableModel model;//= (DefaultTableModel) tabela.getModel();
        List<Notificacao> notificacoes  = usuarioLogado.getNotifications();
        String[] columns = {"msgCod", "Titulo", "Mensagem", "Lida"};
        Object[][] data = new Object[notificacoes.size()][4];
        Integer totalNotificacoes = notificacoes.size();
        Integer qtdNotificacoesNaoLidas = 0;
        for(int i = 0; i< totalNotificacoes; i++){
            Boolean wasRead =notificacoes.get(i).getWasRead();
            if(!wasRead){
                qtdNotificacoesNaoLidas++;
            }
            data[i][0] = notificacoes.get(i).getNotCod();
           data[i][1] = notificacoes.get(i).getTitulo();
           data[i][2] = notificacoes.get(i).getMensagem();
           data[i][3] = wasRead;
        }
        model = new DefaultTableModel(data, columns);
        tabela.setModel(model);
        
        view.getNotCaixaField().setText(totalNotificacoes+" notificações na caixa");
        view.getNaoLidasField().setText(qtdNotificacoesNaoLidas+" notificações não lidas");
    }
    
    
    
}
