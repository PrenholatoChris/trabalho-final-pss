/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.state.tela_principal.LoginNormalState;

/**
 *
 * @author Vanderson
 */
public class EntrarNormalCommand implements ITelaPrincipalCommand {
    private LoginNormalState estado;
    
    public EntrarNormalCommand(LoginNormalState estado){
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
