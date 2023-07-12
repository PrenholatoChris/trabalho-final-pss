/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.tela_principal;

import com.command.tela_principal.ITelaPrincipalCommand;
import com.command.tela_principal.InicializarCommand;
import com.state.tela_principal.InicializacaoState;

/**
 *
 * @author Vanderson
 */
public class InicializarCommandFactory extends TelaPrincipalCommandFactory {
    private InicializacaoState estado;

    public InicializarCommandFactory(InicializacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public ITelaPrincipalCommand criar(){
        return new InicializarCommand(estado);
    }
}
