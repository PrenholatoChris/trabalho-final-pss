/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Notificacao;
import com.model.Usuario;
import com.model.UsuarioNotificacao;
import com.service.GerenteNotificacoes;
import com.service.GerenteSessao;
import com.service.observer.INotificacoesCarregadasObserver;
import com.service.observer.ISessaoObserver;
import com.view.ChangeLogView;
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
    private ChangeLogView trocarLog = null;
    
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
        
        view.getBotaoSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        view.getBotaoTrocarLog().addActionListener((e) -> {
            if(trocarLog == null){
                trocarLog = new ChangeLogView("Trocar Log");
                painelConteudo.add(trocarLog);
                trocarLog.setVisible(true);
            }else{
                if(trocarLog.isVisible())
                    trocarLog.setVisible(false);
                else
                    trocarLog.setVisible(true);
            }
        });
    }
    
    @Override
    public void atualizarNotificacoesCarregadas(List<UsuarioNotificacao> notificacoesUsuario){
        view.getBotaoNotificacoes().setText(String.format("Notificações - %d", notificacoesUsuario.size()));
    }
    
    @Override
    public final void atualizarSessao(Usuario usuarioLogado){
        if(usuarioLogado != null){
            view.getInformacoesUsuarioLabel().setText(String.format("%s - %s", usuarioLogado.getNome(), usuarioLogado.getIsAdmin() ? "Administrador" : "Comum"));
            mudarVisibilidadeBotao(Boolean.TRUE);
        }else{
            view.getInformacoesUsuarioLabel().setText("Nenhum Usuário Logado");
            mudarVisibilidadeBotao(Boolean.FALSE);
        }
    }
    
    private void mudarVisibilidadeBotao(Boolean ehVisivel){
        view.getBotaoAlterarSenha().setVisible(ehVisivel);
        view.getBotaoNotificacoes().setVisible(ehVisivel);
        view.getBotaoSair().setVisible(ehVisivel);
    }
}
