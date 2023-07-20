/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.tela_principal;

import com.presenter.TelaPrincipalPresenter;
import com.service.GerenteSessao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vanderson
 */
public class AlteracaoSenhaState extends TelaPrincipalState{
    private JInternalFrame telaAlteraSenha;
    private JTextField senhaAntigaField;
    private JTextField senhaNovaField;
    
    public String getSenhaAntigaTexto(){
        return senhaAntigaField.getText();
    }
    
    public String getSenhaNovaFieldTexto(){
        return senhaNovaField.getText();
    }
    
    public AlteracaoSenhaState(TelaPrincipalPresenter telaPrincipal, JPanel painelConteudo){
        super.telaPrincipal = telaPrincipal;
        super.painelConteudo = painelConteudo;
        
        exibirTelaAlteracaoSenha();
    }
    
    @Override
    public void entrarAdministrativo(){
        telaPrincipal.setEstado(new LoginAdministrativoState(telaPrincipal, painelConteudo));
    }
    
    @Override
    public void entrarNormal(){
        telaPrincipal.setEstado(new LoginNormalState(telaPrincipal, painelConteudo));
    }
    
    private void exibirTelaAlteracaoSenha(){
        telaAlteraSenha = new JInternalFrame();
        telaAlteraSenha.setTitle("Altere sua Senha");
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        telaAlteraSenha.add(painelPrincipal);
        
        JPanel painelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelPrincipal.add(painelFormulario);
        
        JPanel painelLabels = new JPanel(new GridLayout(0, 1, 5, 10));
        painelLabels.setSize(50, 0);
        painelFormulario.add(painelLabels);
        
        JLabel senhaAntigaLabel = new JLabel("Senha Antiga: ");
        painelLabels.add(senhaAntigaLabel);
        
        JLabel senhaNovaLabel = new JLabel("Senha Nova: ");
        painelLabels.add(senhaNovaLabel);
        
        JPanel painelCampos = new JPanel(new GridLayout(0, 1, 5, 10));
        painelFormulario.add(painelCampos);
        
        senhaAntigaField = new JTextField();
        senhaAntigaField.setColumns(15);
        painelCampos.add(senhaAntigaField);
        
        senhaNovaField = new JTextField();
        senhaNovaField.setColumns(15);
        painelCampos.add(senhaNovaField);
        
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelPrincipal.add(painelBotoes);
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
                close();
            }
        });
        painelBotoes.add(botaoConfirmar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                close();
            }
        });
        painelBotoes.add(botaoCancelar);
        
        telaAlteraSenha.pack();
        telaAlteraSenha.show();
        painelConteudo.add(telaAlteraSenha);
    }
    
    private void close(){
        painelConteudo.remove(telaAlteraSenha);
        painelConteudo.revalidate();
        painelConteudo.repaint();
        if(GerenteSessao.getInstance().getUsuarioLogado().getIsAdmin()){
            entrarAdministrativo();
        }else{
            entrarNormal();
        }
    }
}
