/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.tela_principal;

import com.command.tela_principal.ITelaPrincipalCommand;
import com.state.tela_principal.AlteracaoSenhaState;
import com.state.tela_principal.InicializacaoState;
import com.state.tela_principal.LoginAdministrativoState;
import com.state.tela_principal.LoginNormalState;
import com.state.tela_principal.TelaPrincipalState;

/**
 *
 * @author Vanderson
 */
public abstract class TelaPrincipalCommandFactory {
    
    static public TelaPrincipalCommandFactory getFactory(TelaPrincipalState estado){
        if(estado.getClass() == LoginNormalState.class){
            return new EntrarNormalCommandFactory((LoginNormalState)estado);
        }else if(estado.getClass() == LoginAdministrativoState.class){
            return new EntrarAdministrativoCommandFactory((LoginAdministrativoState)estado);
        }else if(estado.getClass() == InicializacaoState.class){
            return new InicializarCommandFactory((InicializacaoState)estado);
        }else if(estado.getClass() == AlteracaoSenhaState.class){
            return new AlterarSenhaCommandFactory((AlteracaoSenhaState)estado);
        }else{
            return null;
        }
    }
    
    public abstract ITelaPrincipalCommand criar();
}
