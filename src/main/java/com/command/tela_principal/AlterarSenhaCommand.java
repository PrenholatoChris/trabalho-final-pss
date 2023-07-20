/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.state.tela_principal.AlteracaoSenhaState;

/**
 *
 * @author Vanderson
 */
public class AlterarSenhaCommand implements ITelaPrincipalCommand {
    private AlteracaoSenhaState estado;

    public AlterarSenhaCommand(AlteracaoSenhaState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        System.out.println("Sei la");
    }
}
