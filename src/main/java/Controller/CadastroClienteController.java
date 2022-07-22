/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteListDAO;
import View.CadastroClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.CadastroClienteException;
import Repositorio.ClienteRepositorio;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;

/**
 *
 * @author julia
 */
public class CadastroClienteController {

    private CadastroClienteView cadastroCliente;
    
    public CadastroClienteController(CadastroClienteView cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
        inicializarBotoes();
    }

    public void inicializarBotoes() {
        cadastroCliente.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    criaCliente();
                } catch (CadastroClienteException ex) {
                    cadastroCliente.exibirMensagem(ex.getMessage());
                }
            }  
        });
        
        cadastroCliente.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroCliente.fecharTela();
            }
        });
    }
    
    public void identificaExcecao() throws CadastroClienteException{
        if(cadastroCliente.getCliente().isBlank()){
            throw new CadastroClienteException("Campo 'Cliente' não informado.");
        } else if (cadastroCliente.getCpf().isBlank()){
            throw new CadastroClienteException("Campo 'CPF' não informado.");
        } else if (cadastroCliente.getRua().isBlank()){
            throw new CadastroClienteException("Campo 'Rua' não informado.");
        } else if (cadastroCliente.getBairro().isBlank()){
            throw new CadastroClienteException("Campo 'Bairro' não informado.");
        } else if (cadastroCliente.getCidade().isBlank()){
            throw new CadastroClienteException("Campo 'Cidade' não informado.");
        } else if (cadastroCliente.getEstado().isBlank()){
            throw new CadastroClienteException("Campo 'Estado' não informado.");
        } else if (cadastroCliente.getNome().isBlank()){
            throw new CadastroClienteException("Campo 'Nome' não informado.");
        } else if (cadastroCliente.getEmail().isBlank()){
            throw new CadastroClienteException("Campo 'Email' não informado.");
        } else if (cadastroCliente.getTelefone().isBlank()){
            throw new CadastroClienteException("Campo 'Telefone' não informado.");
        }
    }
    
    public void criaCliente() throws CadastroClienteException{
        ClienteRepositorio clienteRepositorio = new ClienteListDAO();
        Cliente cliente = recuperarCliente();
        boolean cadastroOk = clienteRepositorio.salvarCliente(cliente);
        if (cadastroOk) {
            cadastroCliente.exibirMensagem("Cliente criado com sucesso!");
            cadastroCliente.fecharTela();
        } else {
            throw new CadastroClienteException("CPF já cadastrado. Insira um CPF válido!");
        }
    }
    
    public Cliente recuperarCliente(){
        // dados cliente
        String cliente = cadastroCliente.getCliente();
        String cpf = cadastroCliente.getCpf();
        
        // dados contato
        String nome = cadastroCliente.getNome();
        String telefone = cadastroCliente.getTelefone();
        String email = cadastroCliente.getEmail();
        Contato contato = new Contato(nome, telefone, email);
        
        // dados endereco
        String rua = cadastroCliente.getRua();
        String bairro = cadastroCliente.getBairro();
        String cidade = cadastroCliente.getCidade();
        String estado = cadastroCliente.getEstado();
        Endereco endereco = new Endereco(rua, bairro, cidade, estado);
        
        Cliente novoCliente = new Cliente(cliente, endereco, contato, cpf);
        return novoCliente;   
    }
    
    public void exibirTelaCadastroCliente(){
        cadastroCliente.exibirTelaCadastroCliente();
    }
}
