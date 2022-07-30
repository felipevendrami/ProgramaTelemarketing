/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.CadastroAtendimentoView;
import View.CadastroClienteView;
import View.CadastroColaboradorView;
import View.CadastroEmpresaView;
import View.CadastroProdutoView;
import View.ListaAtendimentosView;
import View.MenuInicialView;
import View.RelatorioAtendimentoView;
import View.SelecaoColaboradorView;
import View.SelecaoEmpresaView;
import View.SelecaoProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;

/**
 *
 * @author felip
 */
public class MenuInicialController {
    
    //View MenuInicial
    private MenuInicialView menuInicial;
    
    //Controllers Produto
    private CadastroProdutoController cadastroProduto;
    private SelecaoProdutoController selecaoProduto;
    
    //Controllers Entidade
    private CadastroClienteController cadastroCliente;
    private CadastroColaboradorController cadastroColaborador;
    private CadastroEmpresaController cadastroEmpresa;
    
    private SelecaoColaboradorController selecaoColaborador;
    private SelecaoEmpresaController selecaoEmpresa;
    
    //Controllers Atendimento
    private CadastroAtendimentoController cadastroAtendimento;
    private RelatorioAtendimentoController relatorioAtendimento;
    private ListaAtendimentosController listaAtendimento;

    public MenuInicialController(MenuInicialView menuInicial) {
        this.menuInicial = menuInicial;
        inicializarBotoes();
    }
    
    public void exibirTelaMenuInicial(){
        menuInicial.exibirTelaMenuInicial();
    }
    
    public void inicializarBotoes(){
        menuInicial.adicionarAcaoNovoAtendimento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaCadastroAtendimento();
                cadastroAtendimento.exibirTelaCadastroAtendimento();
            }
        });
        menuInicial.adicionarAcaoListaAtendimentos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializaTelaListaAtendimento();
                listaAtendimento.exibirTelaListaAtendimento();
            }
        });
        menuInicial.adicionarAcaoRelatorioAtendimentos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaRelatorioAtendimento();
                relatorioAtendimento.exibirTelaRelatorioAtendimento();
            }
        });
        menuInicial.adicionarAcaoNovoCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaCadastroCliente();
                cadastroCliente.exibirTelaCadastroCliente();
            }
        });
        menuInicial.adicionarAcaoNovoColaborador(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaCadastroColaborador();
                cadastroColaborador.exibirTelaCadastroColaborador();
            }
        });
        menuInicial.adicionarAcaoNovaEmpresa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaCadastroEmpresa();
                cadastroEmpresa.exibirTelaCadastroEmpresa();
            }
        });
        menuInicial.adicionarAcaoSelecaoColaborador(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaSelecaoColaborador();
                selecaoColaborador.exibirTelaSelecaoColaborador();
            }
        });
        menuInicial.adicionarAcaoSelecaoEmpresa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaSelecaoEmpresa();
                selecaoEmpresa.exibirTelaSelecaoEmpresa();
            }
        });
        
         menuInicial.adicionarAcaoNovoProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaNovoProduto();
                cadastroProduto.exibirTelaCadastroProduto();
            }
        });
            menuInicial.adicionarAcaoListarProdutos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaSelecaoProduto();
                selecaoProduto.exibirTelaSelecaoProduto();
            }
        });
    }
    
    public void inicializarTelaCadastroAtendimento(){
        cadastroAtendimento = new CadastroAtendimentoController(new CadastroAtendimentoView());
    }
    
    public void inicializaTelaListaAtendimento(){
        listaAtendimento = new ListaAtendimentosController(new ListaAtendimentosView());
    }
    
    public void inicializarTelaRelatorioAtendimento(){
        relatorioAtendimento = new RelatorioAtendimentoController(new RelatorioAtendimentoView());
    }
    
    public void inicializarTelaCadastroCliente(){
        cadastroCliente = new CadastroClienteController(new CadastroClienteView());
    }
    
    public void inicializarTelaCadastroColaborador(){
        cadastroColaborador = new CadastroColaboradorController(new CadastroColaboradorView());
    }
    
    public void inicializarTelaCadastroEmpresa(){
        cadastroEmpresa = new CadastroEmpresaController(new CadastroEmpresaView());
    }
    
    public void inicializarTelaSelecaoColaborador(){
        selecaoColaborador = new SelecaoColaboradorController(new SelecaoColaboradorView());
    }
    
    public void inicializarTelaSelecaoEmpresa(){
        selecaoEmpresa = new SelecaoEmpresaController(new SelecaoEmpresaView());
    }
     public void inicializarTelaNovoProduto(){
        cadastroProduto = new CadastroProdutoController(new CadastroProdutoView());
    }
      public void inicializarTelaSelecaoProduto(){
        selecaoProduto = new SelecaoProdutoController(new SelecaoProdutoView());
    }
    
}
