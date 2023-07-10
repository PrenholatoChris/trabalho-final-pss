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
import java.util.List;


/**
 *
 * @author chris
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        SQLite sqlite = new SQLite("./banco.db");
         sqlite.conectar();
         
         
//         
//        UsuarioDAO usuarioDAO = new UsuarioDAO(sqlite.getConnection());
//        usuarioDAO.deletarTabelaUsuario();
//        usuarioDAO.criarTabelaUsuario();
//        usuarioDAO.insert(new Usuario("Affonso", "965"));
//        usuarioDAO.insert(new Usuario("Vanderson", "543"));
//        
//        List<Usuario> usuarios = usuarioDAO.findAll();
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario);
//        }
//
//        sqlite.desconectar();
//        String teste = usuarioDAO.findById(1).toString();
//        System.out.println(teste);
//        UsuarioNotificacaoDAO usuarioNotificacoesDAO;
//        
//        sqlite.conectar();
//        NotificacaoDAO notificacaoDAO = new NotificacaoDAO(sqlite.getConnection());
//        notificacaoDAO.criarTabelaNotificao();
//        Notificacao not1 = new Notificacao("Segunda Notificacao", "ESTE EH UM TESTE, MUITO CUIDADO COM ISSO");;;;
//        notificacaoDAO.insert(not1);
//        List<Notificacao> notificacoes = notificacaoDAO.findAll();
//        for(Notificacao notificacao : notificacoes){
//            System.out.println(notificacao);
//        }
//        sqlite.desconectar();
//        
//        
//        
//        sqlite.conectar();
//        UsuarioNotificacaoDAO usrNotDAO = new UsuarioNotificacaoDAO(sqlite.getConnection());
//        usrNotDAO.deletarTabelaNotificacao();
//        usrNotDAO.criarTabelaUsuarioNotificacao();
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
        sqlite.desconectar();
        
    }
}
