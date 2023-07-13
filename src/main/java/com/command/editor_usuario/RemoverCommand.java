/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.state.editor_usuario.RemocaoState;

/**
 *
 * @author Vanderson
 */
public class RemoverCommand implements IEditorUsuarioCommand{
    private RemocaoState estado;

    public RemoverCommand(RemocaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void  executar(){
        
    }
}
