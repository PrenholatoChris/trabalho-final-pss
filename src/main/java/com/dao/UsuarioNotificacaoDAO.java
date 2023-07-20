/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.UsuarioNotificacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class UsuarioNotificacaoDAO implements IDAO<UsuarioNotificacao>{
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    
    public UsuarioNotificacaoDAO(){
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try{
            statement = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void execute(String sql){
        try{
            statement.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void insert(UsuarioNotificacao usrNot){
        String sql = String.format("INSERT INTO USUARIOS_NOTIFICACOES "
                + "(NOT_COD, USR_COD, WAS_READ) VALUES "
                + "(%d, %d, %d)",usrNot.getNotCod(),usrNot.getUsrCod(),0);
        execute(sql);
    }
    
    @Override
    public Integer getLastRegister() {
        Integer lastRegister = null;
        String sql = String.format("""
                                   SELECT MAX(USUARIOS_NOTIFICACOES.USR_COD)
                                   FROM USUARIOS_NOTIFICACOES""");
        try{
            resultSet = statement.executeQuery(sql);
            lastRegister = resultSet.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return lastRegister;
    }
    
    @Override
    public void remove(Integer usrNotCod){
        String sql = String.format("DELETE FROM USUARIOS_NOTIFICACOES "
                + "WHERE USR_NOT_COD = %d",usrNotCod);
        execute(sql);
    }
    
    @Override
    public void update(UsuarioNotificacao usrNot){
        String sql = String.format("""
                                   UPDATE USUARIOS_NOTIFICACOES
                                    SET NOT_COD = %d,
                                            USR_COD = %d,
                                            WAS_READ = %d
                                            WHERE USUARIOS_NOTIFICACOES.USR_NOT_COD = %d """,
                usrNot.getNotCod(),
                usrNot.getUsrCod(),
                (usrNot.getWasRead()?1:0),
                usrNot.getUsrNotCod());
        execute(sql);
    }
    
    @Override
    public UsuarioNotificacao findById(Integer usrNotCod){
        UsuarioNotificacao usrNot = null;
        String sql = String.format("SELECT * FROM USUARIOS_NOTIFICACOES "
                + "WHERE USR_NOT_COD = %d",usrNotCod);
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            usrNot = new UsuarioNotificacao(
                    resultSet.getInt("USR_NOT_COD"),
                    resultSet.getInt("USR_COD"),
                    resultSet.getInt("NOT_COD"),
                    resultSet.getBoolean("WAS_READ"));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usrNot;
    }
    
    @Override
    public List<UsuarioNotificacao> findAll(){
        List<UsuarioNotificacao> usrNots = new ArrayList<>();
        UsuarioNotificacao usrNot = null;
        
        String sql = String.format("SELECT * FROM USUARIOS_NOTIFICACOES");
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                usrNot = new UsuarioNotificacao(
                        resultSet.getInt("USR_NOT_COD"),
                        resultSet.getInt("USR_COD"),
                        resultSet.getInt("NOT_COD"),
                        resultSet.getBoolean("WAS_READ"));
                usrNots.add(usrNot);
                System.out.println(usrNot);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return usrNots;
    }
    
    public List<UsuarioNotificacao> getNotificationsOfUser(Integer usr_cod){
    List<UsuarioNotificacao> usrNotificacoes = new ArrayList<>();
        String query = String.format("""
                                     SELECT USUARIOS_NOTIFICACOES.USR_NOT_COD,
                                                    USUARIOS_NOTIFICACOES.USR_COD,
                                                    USUARIOS_NOTIFICACOES.WAS_READ,
                                                    NOTIFICACOES.*
                                     FROM USUARIOS_NOTIFICACOES, NOTIFICACOES
                                     WHERE USUARIOS_NOTIFICACOES.NOT_COD = NOTIFICACOES.NOT_COD
                                      AND USUARIOS_NOTIFICACOES.USR_COD = %d """, usr_cod);
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                usrNotificacoes.add(
                        new UsuarioNotificacao(
                                resultSet.getInt("USR_NOT_COD"),
                                resultSet.getInt("USR_COD"),
                                resultSet.getInt("NOT_COD"),
                                resultSet.getBoolean("WAS_READ"),
                                resultSet.getString("MENSAGEM"),
                                resultSet.getString("TITULO")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usrNotificacoes;
    }
    
    public void  criarTabelaUsuarioNotificacao(){
        String sql = "CREATE TABLE  IF NOT EXISTS USUARIOS_NOTIFICACOES"
                + "( USR_NOT_COD INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", NOT_COD INTEGER"
                + ", USR_COD INTEGER"
                + ", WAS_READ INTEGER"
                + ", FOREIGN KEY (NOT_COD) REFERENCES NOTIFICACOES(NOT_COD)"
                + ", FOREIGN KEY (USR_COD) REFERENCES USUARIOS(USR_COD))";
        execute(sql);
    }
    
    public void deletarTabelaNotificacao(){
        String sql = "DROP TABLE USUARIOS_NOTIFICACOES";
        execute(sql);
    }
    
//    public void addNotificacaoToUser(Integer not_id, Integer usr_id) throws Exception {
//        String sql = "INSERT INTO USUARIOS_NOTIFICACOES( NOT_COD, USR_COD, WAS_READ) VALUES  ('" +not_id + "','" +usr_id+"','" + false +"'')";
//        execute(sql);
//    }
//    
//    public void removeNotificacaoOfUser(Integer not_id, Integer usr_id) throws Exception {
//        String sql = "DELETE FROM USUARIOS_NOTIFICACOES"
//                + "WHERE USUARIOS_NOTIFICACOES.NOT_COD = " + not_id
//                + "AND USUARIOS_NOTIFICACOES.USR_COD = " + usr_id;
//        execute(sql);
//    }
//    
//    
//
//    public static String getUsersNotificacoes() throws Exception {
//        String query = ("SELECT * FROM USUARIO_NOTIFICACOES");
//        return query;
//    }
//    
//    public static String getNotificacoesByUserID(Integer usr_id){
//       String query = "SELECT * FROM USUARIO_NOTIFICACOES "
//               + "WHERE USUARIO_NOTIFICACOES.USR_COD = " + usr_id + ";";
//       return query;
//    }
}
