/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.command.gerente_notificacoes;

import com.model.Notificacao;
import java.util.List;

/**
 *
 * @author Vanderson
 */
public class BuscarNotificacoesCommand extends GerenteNotificacoesCommand{
    private List<Integer> codsBusca;
    private List<Notificacao> notificacoesEncontradas;

    public void setCodsBusca(List<Integer> codsBusca) {
        this.codsBusca = codsBusca;
    }

    public List<Notificacao> getNotificacoesEncontradas() {
        return notificacoesEncontradas;
    }

    public BuscarNotificacoesCommand(List<Notificacao> notificacoesUsuarioLogado) {
        super.notificacoesUsuarioLogado = notificacoesUsuarioLogado;
    }
    
    @Override
    public void executar(){
        for(Notificacao notificacao : notificacoesUsuarioLogado){
            Integer codigoUsado = null;
            for(int codigo : codsBusca){
                if(notificacao.getNotCod() == codigo){
                    notificacoesEncontradas.add(notificacao);
                    codigoUsado = codigo;
                    break;
                }
            }
            if(codigoUsado != null){
                codsBusca.remove(codigoUsado);
            }
        }
    }
}
