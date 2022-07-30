/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Produto;
import Repositorio.ProdutoRepositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nicol
 */
public class ProdutoListDAO implements ProdutoRepositorio{
     private static Set<Produto> produtos = new HashSet<>();
     
     @Override
     public boolean salvarProduto(Produto produto) {
        return produtos.add(produto);
    }
     
     @Override
     public Set<Produto> recuperarTodosProdutos() {
        return this.produtos;
    }
     
     private static void createTableProdutoBD(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS produto"
                + " (id_produto INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "  nome              TEXT,"
                + "  marca             TEXT,"
                + "  preco             INTEGER)";
        
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
