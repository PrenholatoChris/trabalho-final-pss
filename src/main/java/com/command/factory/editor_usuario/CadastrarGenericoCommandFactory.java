/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.editor_usuario;

import com.command.editor_usuario.CadastrarGenericoCommand;
import com.command.editor_usuario.IEditorUsuarioCommand;
import com.state.editor_usuario.CadastroGenericoState;

/**
 *
 * @author Vanderson
 */
public class CadastrarGenericoCommandFactory extends EditorUsuarioCommandFactory{
    private CadastroGenericoState estado;

    public CadastrarGenericoCommandFactory(CadastroGenericoState estado) {
        this.estado = estado;
    }
    
    @Override
    public IEditorUsuarioCommand criar(){
        return new CadastrarGenericoCommand(estado);
    }
}
