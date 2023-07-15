/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_usuarios;

import com.command.lista_usuarios.IListaUsuariosCommand;
import com.state.lista_usuarios.AutorizacaoState;
import com.state.lista_usuarios.BaseState;
import com.state.lista_usuarios.EnvioNotificacaoState;
import com.state.lista_usuarios.ListaUsuariosState;
import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author Vanderson
 */
public abstract class ListaUsuariosCommandFactory {
    
    static public ListaUsuariosCommandFactory getFactory(ListaUsuariosState estado){
        try{
            if(estado.getClass() == AutorizacaoState.class){
                return new AutorizarCommandFactory((AutorizacaoState)estado);
            }else if(estado.getClass() == EnvioNotificacaoState.class){
                return new EnviarNotificacaoCommandFactory((EnvioNotificacaoState)estado);
            }else if(estado.getClass() == BaseState.class){
                throw new ExecutionControl.NotImplementedException("O estado base não apresenta comando para ser executado.");
            }else{
                return null;
            }
        }catch(ExecutionControl.NotImplementedException ne){
            System.out.println(ne); //<- Aqui seria usado o Logger.
            return null;
        }
    }
    
    public abstract IListaUsuariosCommand criar();
}
