/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class Empresa extends Entidade{
    
    private String cnpj;
    private List<Item> produtos;
            
    public Empresa(String nome, Endereco endereco, Contato contato, String cnpj) {
        super(nome, endereco, contato);
        this.cnpj = cnpj;
        this.produtos = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Item> getProdutos() {
        return produtos;
    }
    
    public void addProduto(Item produto){
        this.produtos.add(produto);
    }    
    
}
