/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
import com.service.GerenteNotificacoes;
import com.service.observer.INotificacoesCarregadasObserver;
import com.service.observer.ISessaoObserver;
import com.view.RodapeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class RodapePresenter implements ISessaoObserver, INotificacoesCarregadasObserver{
    private RodapeView view;
    private JPanel painelRodape;
    private ListaNotificacoesPresenter listaNotificacoes = null;
    
    public RodapePresenter(JPanel painelRodape, JPanel painelConteudo, TelaPrincipalPresenter telaPrincipal){
        this.painelRodape = painelRodape;
        view = new RodapeView(painelRodape);
        atualizarSessao(null);
        
        view.getBotaoNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(listaNotificacoes == null){
                    listaNotificacoes = new ListaNotificacoesPresenter(painelConteudo);
                    GerenteNotificacoes.getInstance().addObserver(listaNotificacoes);
                }else{
                    listaNotificacoes.close();
                    listaNotificacoes = null;
                }
            }
        });
        
        view.getBotaoAlterarSenha().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                telaPrincipal.alterarSenha();
            }
        });
    }
    
    @Override
    public void atualizarNotificacoesCarregadas(List<UsuarioNotificacao> notificacoesUsuario){
        view.getBotaoNotificacoes().setText(String.format("Notificações - %d", notificacoesUsuario.size()));
        painelRodape.revalidate();
        painelRodape.repaint();
    }
    
    @Override
    public final void atualizarSessao(Usuario usuarioLogado){
        if(usuarioLogado != null){
            view.getInformacoesUsuarioLabel().setText(String.format("%s - %s", usuarioLogado.getNome(), usuarioLogado.getIsAdmin() ? "Administrador" : "Comum"));
            view.getBotaoAlterarSenha().setVisible(true);
            view.getBotaoNotificacoes().setVisible(true);
        }else{
            view.getInformacoesUsuarioLabel().setText("Nenhum Usuário Logado");
            view.getBotaoAlterarSenha().setVisible(false);
            view.getBotaoNotificacoes().setVisible(false);
        }
    }
}
