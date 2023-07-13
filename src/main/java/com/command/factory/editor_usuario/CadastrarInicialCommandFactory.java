/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.editor_usuario;

import com.command.editor_usuario.CadastrarInicialCommand;
import com.command.editor_usuario.IEditorUsuarioCommand;
import com.state.editor_usuario.CadastroInicialState;

/**
 *
 * @author Vanderson
 */
public class CadastrarInicialCommandFactory extends EditorUsuarioCommandFactory{
    private CadastroInicialState estado;

    public CadastrarInicialCommandFactory(CadastroInicialState estado) {
        this.estado = estado;
    }
    
    public IEditorUsuarioCommand criar(){
        return new CadastrarInicialCommand(estado);
    }
}
