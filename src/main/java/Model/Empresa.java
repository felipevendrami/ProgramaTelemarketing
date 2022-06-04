/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author julia
 */
public class Empresa extends Entidade{
    
    private String cnpj;
    private Set<Item> produtos;
            
    public Empresa(String nome, Endereco endereco, Contato contato, String cnpj) {
        super(nome, endereco, contato);
        this.cnpj = cnpj;
        this.produtos = new HashSet<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public Set<Item> getProdutos() {
        return produtos;
    }
    
    public void addProduto(Item produto){
        this.produtos.add(produto);
    }    
    
}
