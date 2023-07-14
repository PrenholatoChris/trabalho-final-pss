/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author chris
 */
public class Usuario {
    private Integer usrCod;
    private String nome;
    private String senha;
    private Boolean isAdmin;
    private static final UsuarioDAO uDAO = new UsuarioDAO();

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = false;
    }
    
    //Construtor do select do banco
    public Usuario(Integer usrCod, String nome, String senha, Boolean isAdmin){
        this.usrCod = usrCod;
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }
    
    public Usuario(String nome, String senha, Integer isAdmin){
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = false;
    }
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getUsrCod() {
        return usrCod;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public void setUserAsAdmin(Usuario outroUsuario) {
        if(this.isAdmin){
            outroUsuario.setIsAdmin(true);
        }else{
            throw new IllegalAccessError("Nao possui a permissao para tornar usuários em Administradores");
        }
    }

    @Override
    public String toString() {
        return String.format("USR_COD=%s NOME=%s SENHA=%s isAdmin=%b",this.getUsrCod(), this.getNome(), this.getUsrCod(), this.getSenha(), this.getIsAdmin());
    }
    
    public static void criar(Usuario u){
        uDAO.insert(u);
    }
    
    public static void remover(Usuario u){
        uDAO.remove(u.getUsrCod());
    }
    
    public void update(){
        uDAO.update(this);
    }
    
    public List<Notificacao> getNotifications(){
        return uDAO.getNotifications(this.usrCod);
    }
    
    public static Usuario getUser(Integer usrCod){
        return uDAO.findById(usrCod);        
    }
    
}