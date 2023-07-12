/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.tela_principal;

import com.command.tela_principal.AlterarSenhaCommand;
import com.command.tela_principal.ITelaPrincipalCommand;
import com.state.tela_principal.AlteracaoSenhaState;

/**
 *
 * @author Vanderson
 */
public class AlterarSenhaCommandFactory extends TelaPrincipalCommandFactory {
    private AlteracaoSenhaState estado;

    public AlterarSenhaCommandFactory(AlteracaoSenhaState estado) {
        this.estado = estado;
    }
    
    @Override
    public ITelaPrincipalCommand criar(){
        return new AlterarSenhaCommand(estado);
    }
}
