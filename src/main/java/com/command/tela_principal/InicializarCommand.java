/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.model.Usuario;
import com.service.GerenteSessao;
import com.service.GerenteUsuarios;
import com.state.tela_principal.InicializacaoState;

/**
 *
 * @author Vanderson
 */
public class InicializarCommand implements ITelaPrincipalCommand {
    private InicializacaoState estado;

    public InicializarCommand(InicializacaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        Usuario usuarioEncontrado = GerenteUsuarios.getInstance().autenticarUsuario(estado.getNomeTextFieldText(), estado.getSenhaTextFieldText());
        if(usuarioEncontrado == null){
            estado.exibirAvisoFalhaLogin();
        }else{
            GerenteSessao.getInstance().setUsuarioLogado(usuarioEncontrado);
        }
    }
}
