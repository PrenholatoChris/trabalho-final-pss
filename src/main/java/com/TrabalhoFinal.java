/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com;

import com.dao.SQLite;
import com.dao.NotificacaoDAO;
import com.dao.UsuarioDAO;
import com.dao.UsuarioNotificacaoDAO;
import com.model.Notificacao;

import com.model.Usuario;
import com.model.UsuarioNotificacao;
import com.presenter.TelaPrincipalPresenter;
import com.service.GerenteSessao;
import java.util.List;


/**
 *
 * @author chris
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
        
        SQLite sqlite = SQLite.getInstance();
//        sqlite.conectar();
        

//        for(Usuario usuario : new UsuarioDAO().findAll()){
//            System.out.println(usuario);
//        }
        
        GerenteSessao.getInstance().addObserver(new TelaPrincipalPresenter());
//        
//        //Código de Inicialização Rápida. Remover para parar de pular a tela de login.
        GerenteSessao.getInstance().setUsuarioLogado(new UsuarioDAO().findById(1));
        
//         
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        usuarioDAO.deletarTabelaUsuario();
//        usuarioDAO.criarTabelaUsuario();
//        usuarioDAO.insert(new Usuario("Christian","1",true,true));
//        usuarioDAO.insert(new Usuario("Vanderson","2",false,true));
//        usuarioDAO.insert(new Usuario("Matheus","3",false,true));
//        usuarioDAO.insert(new Usuario("josoares","4",false,false));
     
//
//        List<Usuario> usuarios = usuarioDAO.findAll();
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario);
//        } System.out.println();
//
//        sqlite.desconectar();
//        String teste = usuarioDAO.findById(1).toString();
//        System.out.println(teste);
//        UsuarioNotificacaoDAO usuarioNotificacoesDAO;
//        
//        sqlite.conectar();
//        NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
//        notificacaoDAO.criarTabelaNotificao();
//        Notificacao not1 = new Notificacao("Segunda Notificacao", "ESTE EH UM TESTE, MUITO CUIDADO COM ISSO");;;;
//        notificacaoDAO.insert(not1);
//        List<Notificacao> notificacoes = notificacaoDAO.findAll();
//        for(Notificacao notificacao : notificacoes){
//            System.out.println(notificacao);
//        }System.out.println();
//        sqlite.desconectar();
//        
//        
//        
//        sqlite.conectar();
//        UsuarioNotificacaoDAO usrNotDAO = new UsuarioNotificacaoDAO();
//        usrNotDAO.deletarTabelaNotificacao();
//        usrNotDAO.criarTabelaUsuarioNotificacao();
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        usuarioDAO.deletarTabelaUsuario();
//        usuarioDAO.criarTabelaUsuario();
//
//        List<Usuario> usuarios = usuarioDAO.findAll();
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario);
//        } System.out.println();
//
//        sqlite.desconectar();
//        String teste = usuarioDAO.findById(1).toString();
//        System.out.println(teste);
//        UsuarioNotificacaoDAO usuarioNotificacoesDAO;
//        
//        sqlite.conectar();
//        NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
//        notificacaoDAO.criarTabelaNotificao();
//        Notificacao not1 = new Notificacao("Segunda Notificacao", "ESTE EH UM TESTE, MUITO CUIDADO COM ISSO");;;;
//        notificacaoDAO.insert(not1);
//        List<Notificacao> notificacoes = notificacaoDAO.findAll();
//        for(Notificacao notificacao : notificacoes){
//            System.out.println(notificacao);
//        }System.out.println();
//        sqlite.desconectar();
//        
//        
//        
//        sqlite.conectar();
//        UsuarioNotificacaoDAO usrNotDAO = new UsuarioNotificacaoDAO();
//        usrNotDAO.deletarTabelaNotificacao();
//        UsuarioNotificacao usrNot1 = new UsuarioNotificacao(3, 2);
//        usrNotDAO.insert(usrNot1);
//        
//        usrNot1 = new UsuarioNotificacao(2, 2);
//        usrNotDAO.insert(usrNot1);
//        usrNot1 = new UsuarioNotificacao(3,2);
//        usrNotDAO.insert(usrNot1);
//
//
//        
//        List<UsuarioNotificacao> notsDeUsuarios = usrNotDAO.findAll();
//        for(UsuarioNotificacao usrNot : notsDeUsuarios){
//            System.out.println(usrNot);
//        }
//        sqlite.desconectar();
        
    }
}
