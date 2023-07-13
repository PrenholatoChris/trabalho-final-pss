/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.lista_usuarios;

import com.command.lista_usuarios.BuscarCommand;
import com.command.lista_usuarios.IListaUsuariosCommand;
import com.state.lista_usuarios.BuscaState;

/**
 *
 * @author Vanderson
 */
public class BuscarCommandFactory extends ListaUsuariosCommandFactory{
    private BuscaState estado;

    public BuscarCommandFactory(BuscaState estado) {
        this.estado = estado;
    }
    
    @Override
    public IListaUsuariosCommand criar(){
        return new BuscarCommand(estado);
    }
}
