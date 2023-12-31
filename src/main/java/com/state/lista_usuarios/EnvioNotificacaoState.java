/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.state.lista_usuarios;

import com.model.Usuario;
import com.presenter.ListaUsuariosPresenter;
import com.service.GerenteUsuarios;
import com.view.ListaUsuariosView;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vanderson
 */
public class EnvioNotificacaoState extends ListaUsuariosState {
    private JInternalFrame telaEnvioNotificacao;
    private JTextArea mensagemTextArea;
    private JTextField tituloTextField;
    
    public String getMensagem(){
        return mensagemTextArea.getText();
    }
    
    public String getTitulo(){
        return tituloTextField.getText();
    }
    
    public List<Usuario> getUsuariosAlvo(){
        return GerenteUsuarios.getInstance().buscarUsuarios(getCodsUsuariosSelecionados());
    }
    
    public EnvioNotificacaoState(ListaUsuariosPresenter listaUsuarios, ListaUsuariosView view){
        super.listaUsuarios = listaUsuarios;
        super.view = view;
        
        exibirTelaEnvioNotificacao();
    }
    
    @Override
    public void autorizar(){
        listaUsuarios.setEstado(new AutorizacaoState(listaUsuarios, view));
    }
    
    @Override
    public void retornar(){
        listaUsuarios.setEstado(new BaseState(listaUsuarios, view));
    }
    
    private void exibirTelaEnvioNotificacao(){
        telaEnvioNotificacao = new JInternalFrame();
        telaEnvioNotificacao.setTitle("Escreva a Notificação");
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
        telaEnvioNotificacao.add(painelPrincipal);
        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setBorder(new EmptyBorder(0, 10, 15, 10));
        painelTitulo.setLayout(new GridLayout(0, 1, 10, 10));
        painelPrincipal.add(painelTitulo);
        
        painelTitulo.add(new JLabel("Titulo: "));
        tituloTextField = new JTextField();
        painelTitulo.add(tituloTextField);
        
        JPanel painelMensagemLabel = new JPanel();
        painelMensagemLabel.setBorder(new EmptyBorder(0, 10, 15, 10));
        painelMensagemLabel.setLayout(new GridLayout(0, 1, 10, 10));
        painelPrincipal.add(painelMensagemLabel);
        painelMensagemLabel.add(new JLabel("Mensagem: "));
        
        JPanel painelMensagemTextArea = new JPanel();
        painelMensagemTextArea.setBorder(new EmptyBorder(0, 10, 15, 10));
        painelMensagemTextArea.setLayout(new GridLayout(0, 1, 10, 10));
        painelPrincipal.add(painelMensagemTextArea);
        
        mensagemTextArea = new JTextArea();
        mensagemTextArea.setColumns(50);
        mensagemTextArea.setRows(20);
        painelMensagemTextArea.add(new JScrollPane(mensagemTextArea));
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(new EmptyBorder(5, 0, 5, 0));
        painelBotoes.setLayout(new GridLayout(0, 2, 20, 5));
        painelPrincipal.add(painelBotoes);
        
        JButton enviarBotao = new JButton("Enviar");
        enviarBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executar();
                fecharJanelaEstado();
            }
        });
        painelBotoes.add(enviarBotao);
        
        JButton cancelarBotao = new JButton("Cancelar");
        cancelarBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fecharJanelaEstado();
            }
        });
        painelBotoes.add(cancelarBotao);
        
        telaEnvioNotificacao.pack();
        telaEnvioNotificacao.show();
        view.getPainelConteudo().add(telaEnvioNotificacao);
    }
    
    private void fecharJanelaEstado(){
        if(view.getTabelaDados().getSelectedRowCount() > 1){
            autorizar();
        }else{
            retornar();
        }
        view.getPainelConteudo().remove(telaEnvioNotificacao);
        view.getPainelConteudo().revalidate();
        view.getPainelConteudo().repaint();
    }
}
