/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemalogger;

/**
 *
 * @author chris
 */
public interface LogAdapter {
    public void makeInfoLog(TipoOperacao operacao, String nome, String usuario);
    public void makeErrorLog(TipoOperacao operacao, String nome, String usuario, Exception e);
}
