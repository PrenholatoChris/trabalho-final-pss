/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.state.editor_usuario.CadastroInicialState;

/**
 *
 * @author Vanderson
 */
public class CadastrarInicialCommand implements IEditorUsuarioCommand{
    private CadastroInicialState estado;

    public CadastrarInicialCommand(CadastroInicialState estado) {
        this.estado = estado;
    }
    
    @Override
    public void  executar(){
        
    }
}
