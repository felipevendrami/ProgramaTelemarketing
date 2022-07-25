/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmpresaListDAO;
import View.CadastroEmpresaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.CadastroEmpresaException;
import Model.Contato;
import Repositorio.EmpresaRepositorio;
import Model.Empresa;
import Model.Endereco;

/**
 *
 * @author julia
 */
public class CadastroEmpresaController {

    private CadastroEmpresaView cadastroEmpresa;
    
    public CadastroEmpresaController(CadastroEmpresaView cadastroEmpresa){
        this.cadastroEmpresa = cadastroEmpresa;
        inicializarBotoes();
    }
    
    public void inicializarBotoes() {
        cadastroEmpresa.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    criaEmpresa();
                } catch (CadastroEmpresaException ex) {
                    cadastroEmpresa.exibirMensagem(ex.getMessage());
                }
            }  
        });
        
        cadastroEmpresa.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroEmpresa.fecharTela();
            }
        });
    }
    
    public void identificaExcecao() throws CadastroEmpresaException{
        if(cadastroEmpresa.getEmpresa().isBlank()){
            throw new CadastroEmpresaException("Campo 'Empresa' não informado.");
        } else if (cadastroEmpresa.getCnpj().isBlank()){
            throw new CadastroEmpresaException("Campo 'CNPJ' não informado.");
        } else if (cadastroEmpresa.getRua().isBlank()){
            throw new CadastroEmpresaException("Campo 'Rua' não informado.");
        } else if (cadastroEmpresa.getBairro().isBlank()){
            throw new CadastroEmpresaException("Campo 'Bairro' não informado.");
        } else if (cadastroEmpresa.getCidade().isBlank()){
            throw new CadastroEmpresaException("Campo 'Cidade' não informado.");
        } else if (cadastroEmpresa.getEstado().isBlank()){
            throw new CadastroEmpresaException("Campo 'Estado' não informado.");
        } else if (cadastroEmpresa.getNome().isBlank()){
            throw new CadastroEmpresaException("Campo 'Nome' não informado.");
        } else if (cadastroEmpresa.getEmail().isBlank()){
            throw new CadastroEmpresaException("Campo 'Email' não informado.");
        } else if (cadastroEmpresa.getTelefone().isBlank()){
            throw new CadastroEmpresaException("Campo 'Telefone' não informado.");
        }
    }

    public void criaEmpresa() throws CadastroEmpresaException{
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        Empresa empresa = recuperarEmpresa();
        // Tenta cadastrar empresa, se CNPJ repetido ele não deixa.
        boolean cadastroOk = empresaRepositorio.salvarEmpresa(empresa);
        if (cadastroOk) {
            cadastroEmpresa.exibirMensagem("Empresa criada com sucesso!");
            cadastroEmpresa.fecharTela();
        } else {
            throw new CadastroEmpresaException("CNPJ já cadastrado. Insira um CNPJ válido!");
        }
    }
    
    public Empresa recuperarEmpresa() {
        String empresa = cadastroEmpresa.getEmpresa();
        String cnpj = cadastroEmpresa.getCnpj();
        
        // dados contato
        String nome = cadastroEmpresa.getNome();
        String telefone = cadastroEmpresa.getTelefone();
        String email = cadastroEmpresa.getEmail();
        Contato contato = new Contato(nome, telefone, email);
        
        // dados endereco
        String rua = cadastroEmpresa.getRua();
        String bairro = cadastroEmpresa.getBairro();
        String cidade = cadastroEmpresa.getCidade();
        String estado = cadastroEmpresa.getEstado();
        Endereco endereco = new Endereco(rua, bairro, cidade, estado);
        
        Empresa novaEmpresa = new Empresa(empresa, endereco, contato, cnpj);
        return novaEmpresa;
    }
    
    public void exibirTelaCadastroEmpresa(){
        cadastroEmpresa.exibirTelaCadastroEmpresa();
    }
}
