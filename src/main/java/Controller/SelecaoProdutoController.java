/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.ProdutoListDAO;
import Repositorio.ProdutoRepositorio;
import TableModel.ListaProdutosTableModel;
import View.SelecaoProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.Produto;
import View.VisualizarProdutosView;
import java.util.ArrayList;
import java.util.Set;
/**
 *
 * @author nicol
 */
public class SelecaoProdutoController {
        private SelecaoProdutoView selecaoProduto;
    
    public SelecaoProdutoController(SelecaoProdutoView selecaoProduto){
        this.selecaoProduto = selecaoProduto;
        setTableModel();
        inicializarBotoes();
    }
    
    public void setTableModel(){
        ProdutoRepositorio produtoRepositorio = new ProdutoListDAO();
        List<Produto> produtosEmLista = converterSetEmList(produtoRepositorio.recuperarTodosProdutos());
        ListaProdutosTableModel listaProdutosTableModel = new ListaProdutosTableModel(produtosEmLista);
        selecaoProduto.setTableModel(listaProdutosTableModel);
    }
    
    public void inicializarBotoes(){
        selecaoProduto.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoProduto.fecharTela();
            }
        });
        selecaoProduto.adicionarAcaoVisualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abreVisualizacaoProduto();
                } catch (Exception ex) {
                    selecaoProduto.exibirMensagem("Um erro aconteceu ao visualizar!");
                }
            }
        });
    }
    
    public void abreVisualizacaoProduto(){
        String idProdutoString = selecaoProduto.getProdutoSelecionado();
        if (idProdutoString == null) {
            selecaoProduto.exibirMensagem("Nenhum produto selecionado! ");
        } else {
            int idProduto = Integer.parseInt(idProdutoString);
            VisualizarProdutoController visualizarProdutoController = new VisualizarProdutoController(new VisualizarProdutosView(), idProduto);
            visualizarProdutoController.exibirTelaVisualizarProduto();
        }
    }
    
    //Recebe Set, percorre Set, adiciona cada elemento na lista e retorna lista.
    public List<Produto> converterSetEmList(Set<Produto> produtosSet){
        List<Produto> produtosEmLista = new ArrayList<>();
        for(Produto produto: produtosSet){
            produtosEmLista.add(produto);
        }
        return produtosEmLista;
    }

    public void exibirTelaSelecaoProduto(){
        selecaoProduto.exibirTelaSelecaoProduto();
    }
}
