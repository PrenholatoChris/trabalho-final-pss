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
import com.presenter.EditorUsuarioPresenter;
import com.presenter.TelaPrincipalPresenter;
import com.service.GerenteSessao;
import com.service.ListaUsuarioRepository;
import java.text.SimpleDateFormat;
//import com.sistemalogger.SistemaLogger;
//import com.sistemalogger.TipoOperacao;


/**
 *
 * @author chris
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
//        ValidadorSenha validador = new ValidadorSenha();
//    List<String> lista = validador.validador("alisuhdlashd");
//        for (String string : lista) {
//            System.out.println(string);
//        }

    
    
//    UsuarioDAO udao = new UsuarioDAO();
//    udao.deletarTabelaUsuario();
//    udao.criarTabelaUsuario();
//    
//    Usuario userChris = new Usuario("Christian", "A3f@jfas", Boolean.TRUE, Boolean.TRUE);
//    Usuario.criar(userChris);
//    Usuario.criar(new Usuario("VandersonRei", "Tug@Pt!",Boolean.FALSE,Boolean.FALSE));
//    Usuario.criar(userChris);
//    Usuario.criar(new Usuario("Vanderson", "Tug4!ss", Boolean.FALSE, Boolean.FALSE));
    
//    NotificacaoDAO ndao = new NotificacaoDAO();
//
//    
//    UsuarioNotificacaoDAO undao = new UsuarioNotificacaoDAO();

//    Usuario u2 = Usuario.getUser(2);
//    Usuario u3 = Usuario.getUser(3);
//    
//    List<Usuario> usuarios = new ArrayList<>();
//    usuarios.add(u1);
//    usuarios.add(u2);
//    usuarios.add(u3);
//    
//    Notificacao not = new Notificacao("3 primeiros usuarios", "Os 3 primeiros usuarios tomarao ban ano que vem!");
//    new ListaUsuarioRepository(usuarios, not);

//    SistemaLogger.trocarLog(SistemaLogger.jsonLog);
//    SistemaLogger.makeInfoLog(TipoOperacao.ALTERANDO_SENHA,"Christian", "admin");
//    Exception e = new Exception("foase");

//        SQLite sqlite = SQLite.getInstance();

//        Usuario u1 = new Usuario("Ronaldo","asdasdiavbu35", false);
//        u1.validarSenha(u1.getSenha());



        
        GerenteSessao.getInstance().addObserver(new TelaPrincipalPresenter());
        System.out.println(new UsuarioDAO().findAll());
//        
        
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
