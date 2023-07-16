/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.lista_notificacoes.ListaNotificacoesState;
import com.view.ListaNotificacoesView;

import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    List<UsuarioNotificacao>  usrNots;

    public void setEstado(ListaNotificacoesState estado) {
        this.estado = estado;
    }
    
    public ListaNotificacoesPresenter(JPanel painelConteudo){
        //Supondo que o usuario Cod 1 esta logado
        usuarioLogado = Usuario.getUser(1);
        
        this.view = new ListaNotificacoesView();
        view.setVisible(true);
        painelConteudo.add(view);
        
        
        configurarTela();
    }
    
    private void configurarTela(){
        //Passar de parametro para ca
        usrNots = UsuarioNotificacao.getNotificationsOfUser(usuarioLogado.getUsrCod());
        JTable tabela = view.getNotificationTable();
        tabela.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        Integer index = tabela.getSelectedRow();
                        UsuarioNotificacao uNot = usrNots.get(index);
                        JOptionPane.showMessageDialog(view, uNot.getMensagem(),uNot.getTitulo(), 1);
                        uNot.setWasRead(true);
                        uNot.update();
                    }
                });
        
        atualizar();
    }
    
    private void atualizar(){
        JTable tabela = view.getNotificationTable();
        DefaultTableModel model;//= (DefaultTableModel) tabela.getModel();
        String[] columns = {"msgCod", "Titulo", "Mensagem", "Lida"};
        Object[][] data = new Object[usrNots.size()][4];
        Integer totalNotificacoes = usrNots.size();
        Integer qtdNotificacoesNaoLidas = 0;
        for(int i = 0; i< totalNotificacoes; i++){
            Boolean wasRead =usrNots.get(i).getWasRead();
            if(!wasRead){
                qtdNotificacoesNaoLidas++;
            }
            data[i][0] = usrNots.get(i).getNotCod();
           data[i][1] = usrNots.get(i).getTitulo();
           data[i][2] = usrNots.get(i).getMensagem();
           data[i][3] = wasRead;
        }
        model = new DefaultTableModel(data, columns);
        tabela.setModel(model);
        
        view.getNotCaixaField().setText(totalNotificacoes+" notificações na caixa");
        view.getNaoLidasField().setText(qtdNotificacoesNaoLidas+" notificações não lidas");
    }
    
    
    
}
