/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.state.editor_usuario.CadastroGenericoState;

/**
 *
 * @author Vanderson
 */
public class CadastrarGenericoCommand implements IEditorUsuarioCommand{
    private CadastroGenericoState estado;

    public CadastrarGenericoCommand(CadastroGenericoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void  executar(){
        
    }
}
