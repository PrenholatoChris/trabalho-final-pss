/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.tela_principal;

import com.presenter.TelaPrincipalPresenter;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public class LoginNormalState extends TelaPrincipalState{
    
    public LoginNormalState(TelaPrincipalPresenter telaPrincipal, JPanel painelConteudo){
        super.telaPrincipal = telaPrincipal;
        super.painelConteudo = painelConteudo;
    }
    
    @Override
    public void alterarSenha(){
        telaPrincipal.setEstado(new AlteracaoSenhaState(telaPrincipal, painelConteudo));
    }
    
    @Override
    public void sair(){
        painelConteudo.removeAll();
        painelConteudo.revalidate();
        painelConteudo.repaint();
        telaPrincipal.setEstado(new InicializacaoState(telaPrincipal, painelConteudo));
    }
}
