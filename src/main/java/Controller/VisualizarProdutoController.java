/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProdutoListDAO;
import Model.Produto;
import Repositorio.ProdutoRepositorio;
import View.VisualizarProdutosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nicol
 */
public class VisualizarProdutoController {
        private VisualizarProdutosView visualizarProduto;
    
    private Produto produtoSelecionado;
    
    //Pego empresa através do Set pelo Id e jogo as informações da empresa para a tela.
    public VisualizarProdutoController(VisualizarProdutosView visualizarProduto, int idProduto){
        this.visualizarProduto = visualizarProduto;
        this.produtoSelecionado = localizaProduto(idProduto);
        inicializarBotoes();
        preencheInformacoes();
    }
    
    public Produto localizaProduto(int idProduto){
        ProdutoRepositorio produtoRepositorio = new ProdutoListDAO();
        for (Produto produto : produtoRepositorio.recuperarTodosProdutos()) {
            if (produto.getIdProduto() == idProduto) {
                return produto;
            } 
        }
        return null;
    }
    
     public void inicializarBotoes(){
        visualizarProduto.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarProduto.fecharTela();
            }
        });
    }
     
    public void preencheInformacoes(){
        visualizarProduto.preencheInformacoesProduto(produtoSelecionado.retornaInformacoes());
    }
    
    public void exibirTelaVisualizarProduto(){
        visualizarProduto.exibirTelaVisualizarProduto();
    }
}
