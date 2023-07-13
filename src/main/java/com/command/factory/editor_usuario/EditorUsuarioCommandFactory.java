/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.factory.editor_usuario;

import com.command.editor_usuario.IEditorUsuarioCommand;
import com.state.editor_usuario.CadastroGenericoState;
import com.state.editor_usuario.CadastroInicialState;
import com.state.editor_usuario.EdicaoState;
import com.state.editor_usuario.EditorUsuarioState;
import com.state.editor_usuario.RemocaoState;

/**
 *
 * @author Vanderson
 */
public abstract class EditorUsuarioCommandFactory {
    
    static public EditorUsuarioCommandFactory getFactory(EditorUsuarioState estado){
        if(estado.getClass() == CadastroGenericoState.class){
            return new CadastrarGenericoCommandFactory((CadastroGenericoState)estado);
        }else if(estado.getClass() == CadastroInicialState.class){
            return new CadastrarInicialCommandFactory((CadastroInicialState)estado);
        }else if(estado.getClass() == EdicaoState.class){
            return new EditarCommandFactory((EdicaoState)estado);
        }else if(estado.getClass() == RemocaoState.class){
            return new RemoverCommandFactory((RemocaoState)estado);
        }else return null;
    }
    
    public abstract IEditorUsuarioCommand criar();
}
