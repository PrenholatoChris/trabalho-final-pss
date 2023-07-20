/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

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
        if(estado.getListaUsuarios() == null){
            ListaUsuariosPresenter listaUsuarios = new ListaUsuariosPresenter(estado.getPainelConteudo());
            GerenteUsuarios.getInstance().addObserver(listaUsuarios);
            estado.setListaUsuarios(listaUsuarios);
        }
    }
}
