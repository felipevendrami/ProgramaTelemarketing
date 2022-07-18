/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.VendaListDAO;
import Model.Atendimento;
import Model.Cliente;
import Model.IAtendimentoDivulgacao;
import Model.Venda;
import Repositorio.VendaRepositorio;
import View.CadastroVendaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class CadastroVendaController {
    
    //View
    private CadastroVendaView cadastroVenda;
    
    //Atendimento Divulgação
    private Atendimento atendimento;

    //Venda
    private Cliente cliente;
    private List<String> itensPedido;

    public CadastroVendaController(CadastroVendaView cadastroVenda) {
        this.cadastroVenda = cadastroVenda;
        inicializarBotoes();
    }
    
    public void exibirTelaCadastroVenda(){
        cadastroVenda.exibirTelaCadastroVenda();
    }
    
    public void inicializarBotoes(){
        cadastroVenda.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroVenda.fecharTela();
            }
        });
        cadastroVenda.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastrarPedidoVenda();
                    //this.atendimentoDivulgacao.setVenda(recuperarVenda());
                    //this.atendimentoDivulgacao.setConversaoDivulgacao(getSituacaoVenda());
                    //atendimentoDivulgacao.processoAtendimento();
                    cadastroVenda.fecharTela();
                } catch (Exception ex) {
                    cadastroVenda.exibirMensagem("Um erro aconteceu!");
                }
            }
        });
        cadastroVenda.adicionarAcaoAdicionarProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        cadastroVenda.adicionarAcaoRemoverProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        cadastroVenda.adicionarAcaoCadastrarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aguardar criação do controlles Cadastro de Clientes
            }
        });
        cadastroVenda.adicionarAcaoBuscarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aguardar criação do controller de Selação de Cliente
            }
        });
    }
    
    //RECUPERADOS VIEW
    
    public void cadastrarPedidoVenda(){
        VendaRepositorio vendaRepositorio = new VendaListDAO();
        Venda venda = recuperarVenda();
        vendaRepositorio.salvarVenda(venda);
        cadastroVenda.exibirMensagem("Venda aberta com sucesso !");
    }
    
    public Venda recuperarVenda(){
        // Recuperamos as informações da tela
        Cliente cliente = this.cliente;
        String situacao = getSituacaoVenda();
        Venda venda = new Venda(cliente, situacao);
        return venda;
    }
    
    public String getSituacaoVenda(){
        String situacao = cadastroVenda.getSituacaoVenda();
        return situacao;
    }
}
