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
public class SQLite {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    private final String dbFilePath;

    public SQLite(String dbFilePath) {
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
//            resultSet.close();
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

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
   

}
