/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chris
 */
public class ConnectSQLite {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    String dbFilePath;

    public ConnectSQLite(String dbFilePath) {
        this.dbFilePath = dbFilePath;
    }

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            //connection = DriverManager.getConnection("jdbc:sqlite:D:\\testdb.db");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testeQuery() throws Exception {
        resultSet = statement
                .executeQuery("SELECT 1");
        System.out.println("Numero:" + resultSet.getString(1));

    }

    public void criarTabelaUsuario() throws Exception {
        String query = "CREATE TABLE  IF NOT EXISTS USUARIOS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME VARCHAR(20), SENHA VARCHAR(20))";
        statement.execute(query);
    }
    
    public void deletarTabelaUsuario() throws Exception {
        String query = "DROP TABLE USUARIOS";
        statement.execute(query);
    }

    public void insereUsuario(String nome, String senha) throws Exception {
        String query = "INSERT INTO USUARIOS ( NOME, SENHA) VALUES  ('" +nome + "','" +senha+"')";
//        String query = "INSERT INTO USUARIOS ("+ nome+", " +senha+");";
        System.out.println(query);
        statement.execute(query);
    }

    public void getUsuarios() throws Exception {
        resultSet = statement.executeQuery("SELECT * FROM USUARIOS");
        while (resultSet.next()) {
            System.out.println("ID=" + resultSet.getInt("ID") + " NOME=" +resultSet.getString("NOME")+ " SENHA=" + resultSet.getString("SENHA"));
        }
    }
    
    public void executeQuery(){
        try{
            
        }
        catch(Exception e){
            
        }
    }

}
