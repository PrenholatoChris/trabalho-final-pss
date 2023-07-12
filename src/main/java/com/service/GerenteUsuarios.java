/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.command.gerente_usuarios.GerenteUsuariosCommand;
import com.command.gerente_usuarios.RemoverUsuarioCommand;
import com.command.gerente_usuarios.BuscarUsuariosCommand;
import com.command.gerente_usuarios.AutenticarUsuarioCommand;
import com.command.gerente_usuarios.AtualizarUsuarioCommand;
import com.command.gerente_usuarios.AdicionarUsuarioCommand;
import com.dao.UsuarioDAO;
import com.model.Usuario;
import com.dto.UsuarioBuscaDTO;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class GerenteUsuarios {
    private static GerenteUsuarios instance = null;
    private Map<String, GerenteUsuariosCommand> comandos;
    private List<IUsuariosObserver> observers;
    private List<Usuario> usuarios;

    public static GerenteUsuarios getInstance() {
        if(instance == null)
            instance = new GerenteUsuarios();
        return instance;
    }
    
    private GerenteUsuarios(){
        UsuarioDAO dao = null;
        /*dao = new UsuarioDAO(); <- É necessário alguma maneira de instanciar um DAO sem precisar injetar a conexão nele. Somente as DAO e classes relacionadas deveriam se 
        preocupar com a conexão com o banco, não as models ou services.*/
        usuarios = dao.findAll();
        comandos = new HashMap<>();
        comandos.put("Adicionar", new AdicionarUsuarioCommand(usuarios, dao));
        comandos.put("Atualizar", new AtualizarUsuarioCommand(usuarios, dao));
        comandos.put("Autenticar", new AutenticarUsuarioCommand(usuarios));
        comandos.put("Buscar", new BuscarUsuariosCommand(usuarios));
        comandos.put("Remover", new RemoverUsuarioCommand(usuarios, dao));
        observers = Arrays.asList();
    }
    
    public void addObserver(IUsuariosObserver observer){
        observers.add(observer);
    }
    
    public void removeObserver(IUsuariosObserver observer){
        observers.remove(observer);
    }
    
    public void adicionarUsuario(Usuario usuario){
        AdicionarUsuarioCommand comando = (AdicionarUsuarioCommand)comandos.get("Adicionar");
        comando.setUsuarioAdicao(usuario);
        comando.executar();
        notificarObservers();
    }
    
    public void atualizarUsuario(Usuario usuario, Map<String, Object> novosDados){
        AtualizarUsuarioCommand comando = (AtualizarUsuarioCommand)comandos.get("Atualizar");
        comando.setUsuarioAtualizacao(usuario);
        comando.setNovosDados(novosDados);
        notificarObservers();
    }
    
    public Usuario autenticarUsuario(String nome, String senha){
        AutenticarUsuarioCommand comando = (AutenticarUsuarioCommand)comandos.get("Autenticar");
        comando.setNome(nome);
        comando.setSenha(senha);
        comando.executar();
        return comando.getUsuarioEncontrado();
    }
    
    public List<Usuario> buscarUsuarios(UsuarioBuscaDTO buscaDto){
        BuscarUsuariosCommand comando = (BuscarUsuariosCommand)comandos.get("Buscar");
        comando.setBuscaDto(buscaDto);
        comando.executar();
        return comando.getUsuariosEncontrados();
    }
    
    public void removerUsuario(int usuarioCod){
        RemoverUsuarioCommand comando = (RemoverUsuarioCommand)comandos.get("Remover");
        comando.setUsuarioCod(usuarioCod);
        comando.executar();
        notificarObservers();
    }
    
    private void notificarObservers(){
        for(IUsuariosObserver observer : observers){
            observer.atualizarUsuarios(usuarios);
        }
    }
}
