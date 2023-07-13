/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_usuarios;

import com.command.lista_usuarios.IListaUsuariosCommand;
import com.state.lista_usuarios.AutorizacaoState;
import com.state.lista_usuarios.BuscaState;
import com.state.lista_usuarios.EnvioNotificacaoState;
import com.state.lista_usuarios.ListaUsuariosState;

/**
 *
 * @author Vanderson
 */
public abstract class ListaUsuariosCommandFactory {
    
    static public ListaUsuariosCommandFactory getFactory(ListaUsuariosState estado){
        if(estado.getClass() == AutorizacaoState.class){
            return new AutorizarCommandFactory((AutorizacaoState)estado);
        }else if(estado.getClass() == BuscaState.class){
            return new BuscarCommandFactory((BuscaState)estado);
        }else if(estado.getClass() == EnvioNotificacaoState.class){
            return new EnviarNotificacaoCommandFactory((EnvioNotificacaoState)estado);
        }else{
            return null;
        }
    }
    
    public abstract IListaUsuariosCommand criar();
}
