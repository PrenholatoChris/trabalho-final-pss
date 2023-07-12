/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_usuarios;

import com.model.Usuario;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public abstract class GerenteUsuariosCommand {
    protected List<Usuario> usuarios;
    
    public abstract void executar();
}
