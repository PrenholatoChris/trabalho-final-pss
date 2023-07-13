/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_usuarios;

import com.command.lista_usuarios.EnviarNotificacaoCommand;
import com.command.lista_usuarios.IListaUsuariosCommand;
import com.state.lista_usuarios.EnvioNotificacaoState;

/**
 *
 * @author Vanderson
 */
public class EnviarNotificacaoCommandFactory extends ListaUsuariosCommandFactory{
    private EnvioNotificacaoState estado;

    public EnviarNotificacaoCommandFactory(EnvioNotificacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public IListaUsuariosCommand criar(){
        return new EnviarNotificacaoCommand(estado);
    }
}
