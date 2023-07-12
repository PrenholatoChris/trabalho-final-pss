/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.tela_principal;

import com.command.tela_principal.EntrarNormalCommand;
import com.command.tela_principal.ITelaPrincipalCommand;
import com.state.tela_principal.LoginNormalState;

/**
 *
 * @author Vanderson
 */
public class EntrarNormalCommandFactory extends TelaPrincipalCommandFactory{
    private LoginNormalState estado;

    public EntrarNormalCommandFactory(LoginNormalState estado) {
        this.estado = estado;
    }
    
    @Override
    public ITelaPrincipalCommand criar(){
        return new EntrarNormalCommand(estado);
    }
}
