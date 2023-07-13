/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.editor_usuario;

import com.command.editor_usuario.EditarCommand;
import com.command.editor_usuario.IEditorUsuarioCommand;
import com.state.editor_usuario.EdicaoState;

/**
 *
 * @author Vanderson
 */
public class EditarCommandFactory extends EditorUsuarioCommandFactory{
    private EdicaoState estado;

    public EditarCommandFactory(EdicaoState estado) {
        this.estado = estado;
    }
    
    public IEditorUsuarioCommand criar(){
        return new EditarCommand(estado);
    }
}
