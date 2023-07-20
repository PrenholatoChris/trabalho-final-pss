/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.model.Usuario;
import com.service.GerenteNotificacoes;
import com.service.GerenteSessao;
import com.service.observer.ISessaoObserver;
import com.state.tela_principal.AlteracaoSenhaState;
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
    private ListaUsuariosPresenter listaUsuarios;

    public ListaUsuariosPresenter getListaUsuarios() {
        return listaUsuarios;
    }

    public void setEstado(TelaPrincipalState estado) {
        this.estado = estado;
    }

    public void setListaUsuarios(ListaUsuariosPresenter listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public TelaPrincipalPresenter(){
        this.view = new TelaPrincipalView();
        this.estado = new InicializacaoState(this, view.getPainelConteudo());
        
        RodapePresenter rodape = new RodapePresenter(view.getPainelRodape(), view.getPainelConteudo(), this);
        GerenteSessao.getInstance().addObserver(rodape);
        GerenteNotificacoes.getInstance().addObserver(rodape);
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
    
    public void alterarSenha(){
        estado = new AlteracaoSenhaState(this, view.getPainelConteudo());
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
