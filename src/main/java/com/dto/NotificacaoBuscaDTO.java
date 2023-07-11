package com.dto;

public class NotificacaoBuscaDTO {
    String titulo;
    String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public NotificacaoBuscaDTO(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
}
