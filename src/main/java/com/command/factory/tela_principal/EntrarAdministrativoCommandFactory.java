/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.tela_principal;

import com.command.tela_principal.EntrarAdministrativoCommand;
import com.command.tela_principal.ITelaPrincipalCommand;
import com.state.tela_principal.LoginAdministrativoState;

/**
 *
 * @author Vanderson
 */
public class EntrarAdministrativoCommandFactory extends TelaPrincipalCommandFactory {
    private LoginAdministrativoState estado;

    public EntrarAdministrativoCommandFactory(LoginAdministrativoState estado) {
        this.estado = estado;
    }
    
    @Override
    public ITelaPrincipalCommand criar(){
        return new EntrarAdministrativoCommand(estado);
    }
}
