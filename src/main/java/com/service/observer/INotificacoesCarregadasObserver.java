/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service.observer;

import com.model.UsuarioNotificacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public interface INotificacoesCarregadasObserver {
    
    public void atualizarNotificacoesCarregadas(List<UsuarioNotificacao> notificacoesUsuario);
}
