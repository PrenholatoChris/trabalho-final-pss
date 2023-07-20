/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.UsuarioDAO;
import com.pss.senha.validacao.ValidadorSenha;
import com.sistemalogger.SistemaLogger;
import com.sistemalogger.TipoOperacao;
import java.util.Date;

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
    private Date dataCadastro;
    private static final UsuarioDAO uDAO = new UsuarioDAO();
//    ValidadorSenha validadorSenha = new ValidadorSenha();

    public Usuario(String nome, String senha,Boolean isAdmin, Boolean isAutorizado){
        List<String> lista = new ValidadorSenha().validar(senha);
         if(!lista.isEmpty()){
             String senhaRecusada = "";
             for (String erroSenha: lista) {
                 senhaRecusada = senhaRecusada + erroSenha + "\n";
             }
            throw new RuntimeException("Senha inválida:\n " + senhaRecusada);
        }
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataCadastro = new Date();
    }
    
    //Construtor do select do banco
    public Usuario(Integer usrCod, String nome, String senha, Boolean isAdmin, Boolean isAutorizado, Date dataCadastro){
        this.usrCod = usrCod;
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataCadastro = dataCadastro;
    }  

    public Integer getUsrCod() {
        return usrCod;
    }
    
    public void setUsrCod(int usrCod){
        this.usrCod = usrCod;
    }
    
    public String getNome() {
        return nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
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
    
    public static Integer criar(Usuario u){
            uDAO.insert(u);
        return uDAO.getLastRegister();
    }
    
    public static void remover(Usuario u){
        uDAO.remove(u.getUsrCod());
    }
    
    public void update(){
        uDAO.update(this);
    }
    
    public static Usuario getUser(Integer usrCod){
        return uDAO.findById(usrCod);        
    }
    
}