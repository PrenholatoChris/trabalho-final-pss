/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author chris
 */

//VANDERSON: Esta classes é realmente necessária? A gente não pode tratar todos os casos de uso especifícos do administrador usando somente a variável boleana no Usuário?

public class Admin extends Usuario{
    private String nome;
    private String senha;
    private Boolean isAdmin;
    
    public Admin(String nome, String senha){
        super(nome, senha);
        this.isAdmin = true;
    }
    
    
}
