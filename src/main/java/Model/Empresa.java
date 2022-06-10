/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(this.cnpj);
        return hash;    
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String retornaInformacoes() {
        return "CNPJ: " + this.getCnpj() + "\n" + super.retornaInformacoes();
    }
    
    

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
