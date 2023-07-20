/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemalogger;

/**
 *
 * @author chris
 */
public enum TipoOperacao {
        INSERINDO_USUARIO("Inserir Usuario"),
        ALTERANDO_USUARIO("AlterarUsuario"),
        EXCLUSAO_USUARIO("Excluir Usuario"),
        ENVIANDO_NOTIFICACAO("Enviar Notificacao"),
        LEITURA_NOTIFICACAO("Ler Notificacao"),
        ALTERANDO_SENHA("Alterar Senha"),
        AUTORIZACAO_USUARIO("Autorizar Usuario");

        private final String descricao;

        TipoOperacao(String descricao) {
          this.descricao = descricao;
        }

        public String getDescricao() {
          return descricao;
        }
    }
