/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.tela_principal.InicializacaoState;
import com.state.tela_principal.TelaPrincipalState;
import com.view.TelaPrincipalView;
import javax.swing.JDesktopPane;

/**
 *
 * @author Vanderson
 */
public class TelaPrincipalPresenter {
    private TelaPrincipalView view;
    private TelaPrincipalState estado;
    
    private ListaNotificacoesPresenter notPresenter;
    private ListaUsuariosPresenter usrPresenter;
//    private CriarUsuarioNotificacaoPresenter usrNotPresenter;

    public void setEstado(TelaPrincipalState estado) {
        this.estado = estado;
    }
    
    public TelaPrincipalPresenter(){
        this.view = new TelaPrincipalView();
        this.estado = new InicializacaoState(this, view.getPainelConteudo());
        addViews();
        estado.executar();
    }
    
   private void addViews(){
       JDesktopPane desktop = this.view.getDesktopPane();
       notPresenter = new ListaNotificacoesPresenter();
       usrPresenter = new ListaUsuariosPresenter();
       desktop.add( notPresenter.getView());
       desktop.add( usrPresenter.getView());
       
//       desktop.add( new CriarUsuarioNotificacaoPresenter().getView());
//       desktop.add( new ListaUsuariosPresenter().getView());
//       desktop.add( new ListaNotificacoesPresenter().getView());
   }
   
}
