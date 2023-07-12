/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.tela_principal;

import com.command.factory.tela_principal.TelaPrincipalCommandFactory;
import com.presenter.TelaPrincipalPresenter;
import javax.swing.JPanel;

/**
 *
 * @author Vanderson
 */
public abstract class TelaPrincipalState {
    protected TelaPrincipalPresenter telaPrincipal;
    protected JPanel painelConteudo;
    
    public void alterarSenha() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Alteração de Senha.");
    }
    
    public void entrarNormal() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Login Normal.");
    }
    
    public void entrarAdministrativo() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Login Administrativo.");
    }
    
    public void sair() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Não é possível passar do estado " + getEstado() + " para o estado Inicialização.");
    }
    
    public void executar(){
        TelaPrincipalCommandFactory.getFactory(this).criar().executar();
    }
    
    private String getEstado(){
        return this.getClass().getSimpleName();
    }
}
