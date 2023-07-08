/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author chris
 */
public class Notificacao {
    private Integer notCod;
    private String titulo;
    private String mensagem;

    public Notificacao(String titulo, String mensagem){
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
    
    public Notificacao(Integer notCod, String titulo, String mensagem){
        this.notCod = notCod;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public Integer getNotCod() {
        return notCod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return ("NOT_COD=" + this.getNotCod() + " TITULO="+ this.getTitulo()+ " MENSAGEM="+this.getMensagem()+".");
    }
 
    
    
}
