/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.dto.NotificacaoBuscaDTO;
import com.model.Notificacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class BuscarNotificacoesCommand extends GerenteNotificacoesCommand{
    private NotificacaoBuscaDTO buscaDto;
    private List<Notificacao> notificacoesEncontradas;

    public void setBuscaDto(NotificacaoBuscaDTO buscaDto) {
        this.buscaDto = buscaDto;
    }

    public List<Notificacao> getNotificacoesEncontradas() {
        return notificacoesEncontradas;
    }

    public BuscarNotificacoesCommand(List<Notificacao> notificacoesUsuarioLogado) {
        super.notificacoesUsuarioLogado = notificacoesUsuarioLogado;
    }
    
    @Override
    public void executar(){
        notificacoesEncontradas.clear();
        for(Notificacao notificacao : notificacoesUsuarioLogado){
            if(verificarNotificacaoValida(notificacao)){
                notificacoesEncontradas.add(notificacao);
            }
        }
    }
    
    private boolean verificarNotificacaoValida(Notificacao notificacao){
        if(buscaDto != null){
            if(buscaDto.getTitulo() != null && notificacao.getTitulo().compareTo(buscaDto.getTitulo()) != 0){
                return false;
            }
            return buscaDto.getMensagem() == null || notificacao.getMensagem().compareTo(buscaDto.getMensagem()) == 0;
        }else
            return true;
    }
}
