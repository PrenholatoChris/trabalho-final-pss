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
public class AlteracaoSenhaState extends TelaPrincipalState{
    
    public AlteracaoSenhaState(TelaPrincipalPresenter telaPrincipal, JPanel painelConteudo){
        super.telaPrincipal = telaPrincipal;
        super.painelConteudo = painelConteudo;
    }
    
    @Override
    public void entrarAdministrativo(){
        telaPrincipal.setEstado(new LoginAdministrativoState(telaPrincipal, painelConteudo));
    }
    
    @Override
    public void entrarNormal(){
        telaPrincipal.setEstado(new LoginNormalState(telaPrincipal, painelConteudo));
    }
}
