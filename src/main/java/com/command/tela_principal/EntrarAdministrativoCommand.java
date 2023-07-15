/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.presenter.ListaNotificacoesPresenter;
import com.presenter.ListaUsuariosPresenter;
import com.service.GerenteUsuarios;
import com.state.tela_principal.LoginAdministrativoState;

/**
 *
 * @author Vanderson
 */
public class EntrarAdministrativoCommand implements ITelaPrincipalCommand {
    private LoginAdministrativoState estado;

    public EntrarAdministrativoCommand(LoginAdministrativoState estado) {
        this.estado = estado;
    }
    
    @Override
    public final void executar(){
        new ListaNotificacoesPresenter(estado.getPainelConteudo());
        GerenteUsuarios.getInstance().addObserver(new ListaUsuariosPresenter(estado.getPainelConteudo()));
    }
}
