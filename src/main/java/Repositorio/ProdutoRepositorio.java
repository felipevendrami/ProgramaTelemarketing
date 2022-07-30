/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;
import Model.Produto;
import java.util.Set;
/**
 *
 * @author nicol
 */
public interface ProdutoRepositorio {

    public boolean salvarProduto(Produto produto);

    public Set<Produto> recuperarTodosProdutos();
}
