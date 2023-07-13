/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;



/**
 *
 * @author chris
 */
public class UsuarioDAO implements DAO<Usuario> {
    
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    
    public UsuarioDAO(){
        SQLite sqlite = SQLite.getInstance();
        this.conn = sqlite.getConnection();
        try{
            this.statement = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Usuario findById(Integer usr_cod){
        Usuario usuario;
        try{
            String sql = "SELECT * FROM USUARIOS WHERE USUARIOS.USR_COD = " + usr_cod;
            resultSet = statement.executeQuery(sql);
            usuario = new Usuario(resultSet.getInt("USR_COD"),resultSet.getString("NOME"),resultSet.getString("SENHA"),resultSet.getBoolean("IS_ADMIN"));
            return usuario;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new Usuario(null,null);
    }
    
    @Override
    public List<Usuario> findAll(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            String sql = "SELECT * FROM USUARIOS";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Boolean isAdmin = resultSet.getBoolean("IS_ADMIN");
                usuarios.add(  
                    new Usuario( resultSet.getInt("USR_COD"),
                            resultSet.getString("NOME"),
                            resultSet.getString("SENHA"),
                            isAdmin));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }
    
    
    @Override
    public void update(Usuario usuario){
        String sql = "UPDATE USUARIOS SET NOME = "+ usuario.getNome() 
                +", SENHA =" + usuario.getSenha()
                +"WHERE USR_COD =" + usuario.getUsrCod();
        execute(sql);
    }
    
    @Override
    public void remove(Integer id) {
        String sql = "DELETE FROM USUARIOS WHERE USUARIOS.USR_COD = " + id;
        execute(sql);
    }

    @Override
    public void insert(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS ( NOME, SENHA) VALUES  ('" +usuario.getNome() + "','" +usuario.getSenha()+"')";
        execute(sql);        
    }
    
    public void criarTabelaUsuario() {
        String sql = "CREATE TABLE  IF NOT EXISTS USUARIOS"
                + "( USR_COD INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", NOME VARCHAR(20)"
                + ", SENHA VARCHAR(20)"
                + ", IS_ADMIN INTEGER)";
       execute(sql);
    }
    
    public void deletarTabelaUsuario(){
        String sql = "DROP TABLE USUARIOS";
        execute(sql);
    }
    
    private void execute(String sql){
        try{
            statement.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /*
    public static String getUsuarios() throws Exception {
        String query = ("SELECT * FROM USUARIOS");
        return query;
        resultSet = statement.executeQuery("SELECT * FROM USUARIOS");
        while (resultSet.next()) {
            str = ("ID=" + resultSet.getInt("ID") + " NOME=" +resultSet.getString("NOME")+ " SENHA=" + resultSet.getString("SENHA"))
            System.out.println(str);
        }
    } 
    
    public static String turnUserToAdmin(Integer usr_cod) throws Exception {
        String query = "UPDATE USUARIOS SET IS_ADMIN = 1"
                + "WHERE USR_COD =" + usr_cod;
        return query;
//        statement.execute(query);
    }
    
    public static String validateUser(Integer usr_cod) throws Exception {
        String query = "UPDATE USUARIOS SET IS_ADMIN = 0"
                + "WHERE USR_COD =" + usr_cod;
        return query;
//        statement.execute(query);
    }


*/
    
    
}
