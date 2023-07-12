/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.state.tela_principal.InicializacaoState;

/**
 *
 * @author Vanderson
 */
public class InicializarCommand implements ITelaPrincipalCommand {
    private InicializacaoState estado;

    public InicializarCommand(InicializacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
