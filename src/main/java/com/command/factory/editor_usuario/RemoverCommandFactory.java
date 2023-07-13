/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.editor_usuario;

import com.command.editor_usuario.IEditorUsuarioCommand;
import com.command.editor_usuario.RemoverCommand;
import com.state.editor_usuario.RemocaoState;

/**
 *
 * @author Vanderson
 */
public class RemoverCommandFactory extends EditorUsuarioCommandFactory{
    private RemocaoState estado;

    public RemoverCommandFactory(RemocaoState estado) {
        this.estado = estado;
    }
    
    public IEditorUsuarioCommand criar(){
        return new RemoverCommand(estado);
    }
}
