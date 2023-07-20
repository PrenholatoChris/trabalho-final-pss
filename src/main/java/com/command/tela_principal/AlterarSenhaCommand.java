/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.tela_principal;

import com.service.GerenteSessao;
import com.service.GerenteUsuarios;
import com.state.tela_principal.AlteracaoSenhaState;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class AlterarSenhaCommand implements ITelaPrincipalCommand {
    private AlteracaoSenhaState estado;

    public AlterarSenhaCommand(AlteracaoSenhaState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        if(GerenteUsuarios.getInstance().autenticarUsuario(GerenteSessao.getInstance().getUsuarioLogado().getNome(), estado.getSenhaAntigaTexto()) != null){
            Map<String, Object> novosDados = new HashMap<>();
            novosDados.put("senha", estado.getSenhaNovaFieldTexto());
            estado.getSenhaNovaFieldTexto(); //<- Tem que fazer uma validação de senha em cima disto.
            GerenteUsuarios.getInstance().atualizarUsuario(GerenteSessao.getInstance().getUsuarioLogado(), novosDados);
        }
    }
}
