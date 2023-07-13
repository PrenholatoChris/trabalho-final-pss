/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.state.editor_usuario.EdicaoState;

/**
 *
 * @author Vanderson
 */
public class EditarCommand implements IEditorUsuarioCommand{
    private EdicaoState estado;

    public EditarCommand(EdicaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void  executar(){
        
    }
}
