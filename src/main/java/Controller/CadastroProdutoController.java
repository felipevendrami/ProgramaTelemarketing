/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.ProdutoListDAO;
import View.CadastroProdutoView;
import Exception.CadastroProdutoException;
import Repositorio.ProdutoRepositorio;
import Model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nicol
 */
public class CadastroProdutoController {
    private CadastroProdutoView cadastroProduto;
    
    public CadastroProdutoController(CadastroProdutoView cadastroProduto){
        this.cadastroProduto = cadastroProduto;
        inicializarBotoes();
    }
    
    public void inicializarBotoes() {
        cadastroProduto.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    criaProduto();
                } catch (CadastroProdutoException ex) {
                    cadastroProduto.exibirMensagem(ex.getMessage());
                }
            }  
        });
        
       cadastroProduto.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroProduto.fecharTela();
            }
        });
    }
    
    public void identificaExcecao() throws CadastroProdutoException{
        if(cadastroProduto.getNome().isBlank()){
            throw new CadastroProdutoException("Campo 'Nome' não informado.");
        } else if (cadastroProduto.getPreco().isBlank()){
            throw new CadastroProdutoException("Campo 'Preco' não informado.");
        } else if (cadastroProduto.getMarca().isBlank()){
            throw new CadastroProdutoException("Campo 'Marca' não informado.");
        }
    }

    public void criaProduto() throws CadastroProdutoException{
        ProdutoRepositorio produtoRepositorio = new ProdutoListDAO();
        Produto produto = recuperarProduto();
        // Tenta cadastrar produto, se Nome repetido ele não deixa.
        boolean cadastroOk = produtoRepositorio.salvarProduto(produto);
        if (cadastroOk) {
            cadastroProduto.exibirMensagem("Produto criado com sucesso!");
            cadastroProduto.fecharTela();
        } else {
            throw new CadastroProdutoException("Produto já cadastrado. Insira um Produto válido!");
        }
    }
    
    public Produto recuperarProduto() {
        String nome = cadastroProduto.getNome();
        String preco = cadastroProduto.getPreco();
        String marca = cadastroProduto.getMarca();
        
        Produto novoProduto = new Produto(nome, preco, marca);
        return novoProduto;
    }
    
    public void exibirTelaCadastroProduto(){
        cadastroProduto.exibirTelaCadastroProduto();
    }
}