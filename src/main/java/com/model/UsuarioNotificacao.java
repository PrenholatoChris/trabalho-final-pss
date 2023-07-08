/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author chris
 */
public class UsuarioNotificacao {
    private Integer usrNotCod;
    private Integer usrCod;
    private Integer notCod;
    private Boolean wasRead;
    
    public UsuarioNotificacao(Integer usrNotCod,Integer usrCod, Integer notCod, Boolean wasRead){
        this.usrCod = usrCod;
        this.notCod = notCod;
        this.wasRead = wasRead;
    }
    
    public UsuarioNotificacao(Integer usrCod, Integer notCod){
        this.usrCod = usrCod;
        this.notCod = notCod;
        this.wasRead = Boolean.FALSE;
    }

    public Integer getNotCod() {
        return notCod;
    }

    public Integer getUsrCod() {
        return usrCod;
    }

    public Boolean getWasRead() {
        return wasRead;
    }

    public Integer getUsrNotCod() {
        return usrNotCod;
    }
    
        @Override
    public String toString() {
        String lido = wasRead? "foi lida" : "nao foi lida";
        return String.format("USR_NOT_COD=%d USR_COD=%d possui a NOT_COD=%d que %s", usrNotCod,usrCod, notCod, lido);
    }
    
}
