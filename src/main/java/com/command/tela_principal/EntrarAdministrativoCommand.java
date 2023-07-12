/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

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
    public void executar(){
        
    }
}
