/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_usuarios;

import com.state.lista_usuarios.BuscaState;

/**
 *
 * @author Vanderson
 */
public class BuscarCommand implements IListaUsuariosCommand{
    private BuscaState estado;

    public BuscarCommand(BuscaState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
