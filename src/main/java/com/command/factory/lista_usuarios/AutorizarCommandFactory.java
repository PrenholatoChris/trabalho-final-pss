/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_usuarios;

import com.command.lista_usuarios.AutorizarCommand;
import com.command.lista_usuarios.IListaUsuariosCommand;
import com.state.lista_usuarios.AutorizacaoState;

/**
 *
 * @author Vanderson
 */
public class AutorizarCommandFactory extends ListaUsuariosCommandFactory{
    private AutorizacaoState estado;

    public AutorizarCommandFactory(AutorizacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public IListaUsuariosCommand criar(){
        return new AutorizarCommand(estado);
    }
}
