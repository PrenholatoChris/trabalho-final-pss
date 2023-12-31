/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.tela_principal;

import com.model.Usuario;
import com.presenter.EditorUsuarioPresenter;
import com.presenter.TelaPrincipalPresenter;
import com.service.GerenteSessao;
import com.service.GerenteUsuarios;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Vanderson
 */
public class InicializacaoState extends TelaPrincipalState{
    private JInternalFrame telaLogin;
    private JTextField nomeTextField;
    private JTextField senhaTextField;
    
    public String getNomeTextFieldText(){
        return nomeTextField.getText();
    }
    
    public String getSenhaTextFieldText(){
        return senhaTextField.getText();
    }
    
    public InicializacaoState(TelaPrincipalPresenter telaPrincipal, JPanel painelConteudo){
        super.telaPrincipal = telaPrincipal;
        super.painelConteudo = painelConteudo;
        
        exibirTelaLogin();
    }
    
    @Override
    public void entrarAdministrativo(){
        telaPrincipal.setEstado(new LoginAdministrativoState(telaPrincipal, painelConteudo));
        painelConteudo.remove(telaLogin);
    }
    
    @Override
    public void entrarNormal(){
        telaPrincipal.setEstado(new LoginNormalState(telaPrincipal, painelConteudo));
        painelConteudo.remove(telaLogin);
    }
    
    public void exibirAvisoFalhaLogin(){
        JDialog errorDialog = new JDialog(SwingUtilities.getWindowAncestor(painelConteudo), "Problema de login");
        errorDialog.setSize(200, 100);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        errorDialog.add(painel);

        JLabel aviso = new JLabel("Usuario Não Autorizado.");
        aviso.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(aviso);

        JButton botao = new JButton("Fechar");
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                errorDialog.dispose();
            }
        });
        painel.add(botao);

        errorDialog.setVisible(true);
    }
    
    private void exibirTelaLogin(){
        telaLogin = new JInternalFrame();
        telaLogin.setTitle("Faça seu Login");
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        telaLogin.add(painelPrincipal);
        
        JPanel painelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelPrincipal.add(painelFormulario);
        
        JPanel painelLabels = new JPanel(new GridLayout(0, 1, 5, 10));
        painelLabels.setSize(50, 0);
        painelFormulario.add(painelLabels);
        
        JLabel nomeLabel = new JLabel("Nome: ");
        painelLabels.add(nomeLabel);
        
        JLabel senhaLabel = new JLabel("Senha: ");
        painelLabels.add(senhaLabel);
        
        JPanel painelCampos = new JPanel(new GridLayout(0, 1, 5, 10));
        painelFormulario.add(painelCampos);
        
        nomeTextField = new JTextField();
        nomeTextField.setColumns(15);
        painelCampos.add(nomeTextField);
        
        senhaTextField = new JTextField();
        senhaTextField.setColumns(15);
        painelCampos.add(senhaTextField);
        
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelPrincipal.add(painelBotoes);
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
            }
        });
        painelBotoes.add(botaoConfirmar);
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new EditorUsuarioPresenter(painelConteudo);
            }
        });
        painelBotoes.add(botaoCadastrar);
        
        telaLogin.pack();
        telaLogin.show();
        painelConteudo.add(telaLogin);
    }
}
