/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.service.GerenteSessao;
import com.service.ValidadorSenhaService;
import com.sistemalogger.SistemaLogger;
import com.sistemalogger.TipoOperacao;
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
                    try{
                        ValidadorSenhaService.validar((String)novosDados.get(chave));
                        usuarioAtualizacao.setSenha((String)novosDados.get(chave));
                    }catch(Exception e){
                        SistemaLogger.makeErrorLog(TipoOperacao.ALTERANDO_SENHA, (String)novosDados.get("nome"), GerenteSessao.getInstance().getUsuarioLogado().getNome(), e);
                    }
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
        SistemaLogger.makeInfoLog(TipoOperacao.ALTERANDO_USUARIO, usuarioAtualizacao.getNome(), GerenteSessao.getInstance().getUsuarioLogado().getNome());
    }
}
