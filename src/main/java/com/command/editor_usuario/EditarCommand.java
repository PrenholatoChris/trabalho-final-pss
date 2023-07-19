/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.editor_usuario;

import com.service.GerenteUsuarios;
import com.state.editor_usuario.EdicaoState;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vanderson
 */
public class EditarCommand implements IEditorUsuarioCommand{
    private EdicaoState estado;

    public EditarCommand(EdicaoState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(){
        Map<String, Object> novosDados = new HashMap<>();
        novosDados.put("nome", estado.getNovoNome());
        novosDados.put("senha", estado.getNovaSenha());
        novosDados.put("ehAdministrador", estado.getStatusAdministrador());
        novosDados.put("ehAutorizado", estado.getStatusAutorizado());
        GerenteUsuarios.getInstance().atualizarUsuario(estado.getUsuarioAEditar(), novosDados);
        estado.visualizar();
    }
}
