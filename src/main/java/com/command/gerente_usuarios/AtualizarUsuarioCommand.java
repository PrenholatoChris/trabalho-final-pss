/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class AtualizarUsuarioCommand extends GerenteUsuariosCommand{
    private Map<String, Object> novosDados;
    private Usuario usuarioAtualizacao;
    private UsuarioDAO dao;

    public void setUsuarioAtualizacao(Usuario usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    public void setNovosDados(Map<String, Object> novosDados) {
        this.novosDados = novosDados;
    }
    
    public AtualizarUsuarioCommand(List<Usuario> usuarios, UsuarioDAO dao){
        super.usuarios = usuarios;
        this.dao = dao;
    }
    
    @Override
    public void executar(){
        for(String chave : novosDados.keySet()){
            switch(chave){
                case "nome":
                    usuarioAtualizacao.setNome((String)novosDados.get(chave));
                    break;
                case "senha":
                    usuarioAtualizacao.setSenha((String)novosDados.get(chave));
                    break;
                case "ehAdministrador":
                    usuarioAtualizacao.setIsAdmin((Boolean)novosDados.get(chave));
                    break;
                case "ehAutorizado":
                    usuarioAtualizacao.setIsAutorizado((Boolean)novosDados.get(chave));
                    break;
                default:
                    System.out.println("Isto tem que lançar um erro no futuro.");
                    break;
            }
        }
        dao.update(usuarioAtualizacao);
    }
}
