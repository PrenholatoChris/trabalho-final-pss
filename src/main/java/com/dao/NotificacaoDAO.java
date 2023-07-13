/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Notificacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class NotificacaoDAO implements DAO<Notificacao>{
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    
    public NotificacaoDAO(){
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try{
            statement = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void criarTabelaNotificao() {
        String sql = "CREATE TABLE  IF NOT EXISTS NOTIFICACOES"
                + "( NOT_COD INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", TITULO VARCHAR(20)"
                + ", MENSAGEM VARCHAR)";
        execute(sql);
    }
    
    public void deletarTabelaNotificacao() {
        String sql = "DROP TABLE NOTIFICACOES";
        execute(sql);
    }
    
    @Override
    public void insert(Notificacao not){
        String sql = "INSERT INTO NOTIFICACOES ( TITULO, MENSAGEM) VALUES  ('" + not.getTitulo() + "','" + not.getMensagem()+"')";
        execute(sql);
    }
    
    @Override
    public void remove(Integer id){
        String sql = "DELETE FROM NOTIFICACOES WHERE NOTIFICACOES.NOT_COD = " + id;
        execute(sql);
    }
    
    public void update(Notificacao not){
        String sql = "UPDATE NOTIFICACOES SET NOTIFICACOES.TITULO =" + not.getTitulo()
                + ", NOTIFICACOES.MENSAGEM =" +not.getMensagem()
                + "WHERE NOTIFICACOES.NOT_COD = "+ not.getNotCod();
        execute(sql);
    }
    
    @Override
    public Notificacao findById(Integer not_cod){
        Notificacao not = null;
        String sql = String.format("SELECT * FROM %s WHERE %s = %d","NOTIFICACOES", not_cod);
        System.out.println(sql);
        try{
            resultSet = statement.executeQuery(sql);
            String titulo = resultSet.getString("TITULO");
            String mensagem = resultSet.getString("MENSAGEM");
            not = new Notificacao(not_cod, titulo, mensagem);
        }catch(Exception e){
            e.printStackTrace();
        }
        return not;
    }
    
    @Override
    public List<Notificacao> findAll(){
        List<Notificacao> notificacoes = new ArrayList<>();
        String sql = "SELECT * FROM NOTIFICACOES";
        try{
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                notificacoes.add(
                        new Notificacao(
                                resultSet.getInt("NOT_COD")
                                , resultSet.getString("TITULO")
                                , resultSet.getString("MENSAGEM"))
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return notificacoes;
    }
    
    private void execute(String sql){
        try{
            statement.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public static String getNotificacoes() throws Exception {
        String query = ("SELECT * FROM NOTIFICACOES");
        return query;
    }
}
