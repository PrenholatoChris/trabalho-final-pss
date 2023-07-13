/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.lista_usuarios;

import com.state.lista_usuarios.AutorizacaoState;

/**
 *
 * @author Vanderson
 */
public class AutorizarCommand implements IListaUsuariosCommand{
    private AutorizacaoState estado;

    public AutorizarCommand(AutorizacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        
    }
}
