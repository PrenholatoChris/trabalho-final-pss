/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.tela_principal;

import com.model.Usuario;
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
    private JTextField nomeTextField;
    private JTextField senhaTextField;
    
    public InicializacaoState(TelaPrincipalPresenter telaPrincipal, JPanel painelConteudo){
        super.telaPrincipal = telaPrincipal;
        super.painelConteudo = painelConteudo;
        
        exibirTelaLogin();
    }
    
    @Override
    public void entrarAdministrativo(){
        telaPrincipal.setEstado(new LoginAdministrativoState(telaPrincipal, painelConteudo));
    }
    
    @Override
    public void entrarNormal(){
        telaPrincipal.setEstado(new LoginNormalState(telaPrincipal, painelConteudo));
    }
    
    private void exibirTelaLogin(){
        JInternalFrame telaLogin = new JInternalFrame();
        telaLogin.setTitle("Faça seu login.");
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        telaLogin.add(painelPrincipal);
        
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(0, 2, 10,0));
        painelPrincipal.add(painelFormulario);
        
        JPanel painelLabels = new JPanel();
        painelLabels.setLayout(new GridLayout(0, 1, 0, 10));
        /*painelLabels.setPreferredSize(new Dimension(50, 50));*/
        painelLabels.setMaximumSize(new Dimension(100, 50));
        painelFormulario.add(painelLabels);
        
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(0, 1, 0, 10));
        painelCampos.setPreferredSize(new Dimension(100, 50));
        painelFormulario.add(painelCampos);
        
        JLabel nomeLabel = new JLabel("Nome: ");
        painelLabels.add(nomeLabel);
        nomeTextField = new JTextField();
        painelCampos.add(nomeTextField);
        
        JLabel senhaLabel = new JLabel("Senha: ");
        painelLabels.add(senhaLabel);
        senhaTextField = new JTextField();
        painelCampos.add(senhaTextField);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelPrincipal.add(painelBotoes);
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                confirmarLogin();
            }
        });
        painelBotoes.add(botaoConfirmar);
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        painelBotoes.add(botaoCadastrar);
        
        telaLogin.pack();
        telaLogin.show();
        painelConteudo.add(telaLogin);
    }
    
    private void confirmarLogin(){
        Usuario usuarioEncontrado = GerenteUsuarios.getInstance().autenticarUsuario(nomeTextField.getText(), senhaTextField.getText());
        if(usuarioEncontrado == null){
            exibirAvisoFalhaLogin();
        }else{
            System.out.println("Checagem!!!");
            GerenteSessao.getInstance().setUsuarioLogado(usuarioEncontrado);
        }
    }
    
    private void exibirAvisoFalhaLogin(){
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
}
