/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.UsuarioDAO;
import java.util.List;
//import com.pss.senha.validacao.ValidadorSenha;
import java.util.ArrayList;
/**
 *
 * @author chris
 */
public class Usuario {
    private Integer usrCod;
    private String nome;
    private String senha;
    private Boolean isAdmin;
    private Boolean isAutorizado;
    private static final UsuarioDAO uDAO = new UsuarioDAO();
//    ValidadorSenha validadorSenha = new ValidadorSenha();

    public Usuario(String nome, String senha, Boolean isAutorizado){
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = false;
        this.isAutorizado = isAutorizado;
    }
    //Construtor do select do banco
    public Usuario(Integer usrCod, String nome, String senha, Boolean isAdmin, Boolean isAutorizado){
        this.usrCod = usrCod;
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
    }
    
    public Usuario(String nome, String senha, Boolean isAdmin, Boolean isAutorizado){
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
    }
    
//    public boolean validarSenha(String senha){
//        List<String> validacoes = new ArrayList<>();
//        validacoes = this.validadorSenha.validar(senha);
//        for (String validacao : validacoes) {
//            System.out.println(validacao);
//        }
//        return true;
//    }

    public Integer getUsrCod() {
        return usrCod;
    }
    
    public void setUsrCod(int usrCod){
        this.usrCod = usrCod;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsAutorizado() {
        return isAutorizado;
    }

    public void setIsAutorizado(Boolean isAutorizado) {
        this.isAutorizado = isAutorizado;
    }
    
//    public void setUserAsAdmin(Usuario outroUsuario) {
//        if(this.isAdmin){
//            outroUsuario.setIsAdmin(true);
//        }else{
//            throw new IllegalAccessError("Nao possui a permissao para tornar usuários em Administradores");
//        }
//    }

    @Override
    public String toString() {
        return String.format("USR_COD=%s NOME=%s SENHA=%s isAdmin=%b isAutorizado=%s",this.getUsrCod(), this.getNome(), this.getSenha(), this.getIsAdmin(),
                this.getIsAutorizado());
    }
    
//    public static Integer criar(Usuario u){
//        uDAO.insert(u);
//        return uDAO.getLastRegister();
//    }
//    
//    public static void remover(Usuario u){
//        uDAO.remove(u.getUsrCod());
//    }
//    
//    public void update(){
//        uDAO.update(this);
//    }
//    
//    public static Usuario getUser(Integer usrCod){
//        return uDAO.findById(usrCod);        
//    }
    
}