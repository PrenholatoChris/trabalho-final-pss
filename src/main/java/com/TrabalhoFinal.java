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
import com.sistemalogger.SistemaLogger;
import com.sistemalogger.TipoOperacao;



/**
 *
 * @author chris
 */
public class TrabalhoFinal {

    public static void main(String[] args) {

        SistemaLogger.trocarLog(SistemaLogger.csvLog);
        new UsuarioDAO().criarTabelaUsuario();
        new NotificacaoDAO().criarTabelaNotificao();
        new UsuarioNotificacaoDAO().criarTabelaUsuarioNotificacao();
        GerenteSessao.getInstance().addObserver(new TelaPrincipalPresenter());
    }
}
