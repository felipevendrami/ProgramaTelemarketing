/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ColaboradorListDAO;
import Repositorio.ColaboradorRepositorio;
import View.CadastroColaboradorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Colaborador;
import Model.Contato;
import Model.Endereco;

/**
 *
 * @author julia
 */
public class CadastroColaboradorController {
    
    private CadastroColaboradorView cadastroColaborador;
    
    public CadastroColaboradorController(CadastroColaboradorView cadastroColaborador){
        this.cadastroColaborador = cadastroColaborador;
        inicializarBotoes();
    }
    
    public void exibirTelaCadastroColaborador(){
        cadastroColaborador.exibirTelaCadastroColaborador();
    }
    
    public void inicializarBotoes() {
        cadastroColaborador.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
                    Colaborador colaborador = recuperarColaborador();
                    colaboradorRepositorio.salvarColaborador(colaborador);
                    cadastroColaborador.exibirMensagem("Colaborador criado com sucesso!");
                    cadastroColaborador.fecharTela();
                } catch (Exception ex) {
                    cadastroColaborador.exibirMensagem("Um erro aconteceu ao cadastrar colaborador!");
                }
            }  
        });
        
        cadastroColaborador.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroColaborador.fecharTela();
            }
        });
    }
    
    public Colaborador recuperarColaborador(){
        // dados colaborador
        String colaborador = cadastroColaborador.getColaborador();
        String setor = cadastroColaborador.getSetor();
        String cargo = cadastroColaborador.getCargo();
        
        // dados contato
        String nome = cadastroColaborador.getNome();
        String telefone = cadastroColaborador.getTelefone();
        String email = cadastroColaborador.getEmail();
        Contato contato = new Contato(nome, telefone, email);
        
        // dados endereco
        String rua = cadastroColaborador.getRua();
        String bairro = cadastroColaborador.getBairro();
        String cidade = cadastroColaborador.getCidade();
        String estado = cadastroColaborador.getEstado();
        Endereco endereco = new Endereco(rua, bairro, cidade, estado);
        
        Colaborador novoColaborador = new Colaborador(colaborador, endereco, contato, setor, cargo);
        return novoColaborador;
        
        
    }
}
