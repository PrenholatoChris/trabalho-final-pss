/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.NotificacaoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class Notificacao {
    private Integer notCod;
    private String titulo;
    private String mensagem;
    private Boolean wasRead;
    
    private static final NotificacaoDAO nDAO = new NotificacaoDAO();

    public Notificacao(String titulo, String mensagem){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.wasRead = false;
    }
    
    public Notificacao(Integer notCod, String titulo, String mensagem){
        this.notCod = notCod;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
    
    public Notificacao(Integer notCod, String titulo, String mensagem, Boolean wasRead){
        this.notCod = notCod;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.wasRead = wasRead;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public Boolean getWasRead() {
        return wasRead;
    }
    
    public Integer getNotCod() {
        return notCod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNotCod(int notCod){
        this.notCod = notCod;
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
 
    public static Integer criar(Notificacao n){
        nDAO.insert(n);
        return nDAO.getLastRegister();
    }
    
    public static void deletar(Notificacao n){
        nDAO.remove(n.getNotCod());
    }
    
    public void update(){
         nDAO.update(this);
    }
    
    public static List<Notificacao> getAll(){
        return nDAO.findAll();
    }
    

}
