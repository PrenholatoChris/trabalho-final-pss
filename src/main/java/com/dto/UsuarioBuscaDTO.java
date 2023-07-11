/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

/**
 *
 * @author Vanderson
 */
public class UsuarioBuscaDTO {
    private Boolean isAdmin;
    private String nome;

    public UsuarioBuscaDTO(Boolean isAdmin, String nome) {
        this.isAdmin = isAdmin;
        this.nome = nome;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public String getNome() {
        return nome;
    }
}
