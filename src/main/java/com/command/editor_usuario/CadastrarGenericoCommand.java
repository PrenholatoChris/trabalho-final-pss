/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.model.Usuario;
import com.service.GerenteSessao;
import com.service.GerenteUsuarios;
import com.service.ValidadorSenhaService;
import com.state.editor_usuario.CadastroGenericoState;
import javax.swing.JOptionPane;

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
        boolean ehUsuarioInicial = GerenteUsuarios.getInstance().getQtdUsuarios() == 0;
        
        try{
            ValidadorSenhaService.validar(estado.getSenhaInserida());
            Usuario usuario = new Usuario(estado.getNomeInserido(), estado.getSenhaInserida(), ehUsuarioInicial, ehUsuarioInicial);
            GerenteUsuarios.getInstance().adicionarUsuario(usuario);
            if(ehUsuarioInicial){
               GerenteSessao.getInstance().setUsuarioLogado(usuario);
               estado.externalClose();
            }
            JOptionPane.showMessageDialog(null, "Cadastro efetuado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){}
    }
}
