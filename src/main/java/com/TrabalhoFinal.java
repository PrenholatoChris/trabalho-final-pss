/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com;

import com.dao.ConnectSQLite;


/**
 *
 * @author chris
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ConnectSQLite sql = new ConnectSQLite("./banco.db");
         sql.conectar();
         
         try{
             sql.deletarTabelaUsuario();
             sql.criarTabelaUsuario();
             sql.insereUsuario("vanderson", "teste");
             sql.insereUsuario("teteu", "123");
             sql.insereUsuario("chris", "321");
             
             sql.getUsuarios();
             
             sql.desconectar();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        
    }
}
