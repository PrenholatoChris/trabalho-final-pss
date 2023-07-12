/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.presenter;

import com.state.tela_principal.InicializacaoState;
import com.state.tela_principal.TelaPrincipalState;
import com.view.TelaPrincipalView;

/**
 *
 * @author Vanderson
 */
public class TelaPrincipalPresenter {
    private TelaPrincipalView view;
    private TelaPrincipalState estado;

    public void setEstado(TelaPrincipalState estado) {
        this.estado = estado;
    }
    
    public TelaPrincipalPresenter(){
        this.view = new TelaPrincipalView();
        this.estado = new InicializacaoState(this, view.getPainelConteudo());
        
        estado.executar();
    }
}
