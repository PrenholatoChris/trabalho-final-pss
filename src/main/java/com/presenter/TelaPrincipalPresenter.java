/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.service.observer.ISessaoObserver;
import com.state.tela_principal.InicializacaoState;
import com.state.tela_principal.TelaPrincipalState;
import com.view.TelaPrincipalView;

/**
 *
 * @author Vanderson
 */
public class TelaPrincipalPresenter implements ISessaoObserver{
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
//        addViews();

        new EditorUsuarioPresenter(view.getPainelConteudo());
    }
    
    @Override
    public void atualizarSessao(Usuario usuarioLogado){
        if(usuarioLogado != null){
            if(usuarioLogado.getIsAdmin()){
                estado.entrarAdministrativo();
            }else{
                estado.entrarNormal();
            }
        }else{
            estado.sair();
        }
    }
    
//   private void addViews(){
//       JPanel painelCounteudo = this.view.getPainelConteudo();
//       notPresenter = new ListaNotificacoesPresenter();
//       usrPresenter = new ListaUsuariosPresenter();
//       painelCounteudo.add( notPresenter.getView());
//       painelCounteudo.add( usrPresenter.getView());
//       
//       desktop.add( new CriarUsuarioNotificacaoPresenter().getView());
//       desktop.add( new ListaUsuariosPresenter().getView());
//       desktop.add( new ListaNotificacoesPresenter().getView());
//   }
}
