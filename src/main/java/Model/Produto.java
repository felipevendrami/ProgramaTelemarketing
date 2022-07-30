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
 * @author nicol
 */
public class Produto {

    private static int geradorIdProduto = 0;

    private int idProduto;
    protected String nome;
    protected String preco;
    protected String marca;

    public Produto(String nome, String preco,String marca) {
        this.idProduto = geradorIdProduto++;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public String retornaInformacoes() {
        return "Nome: " + this.getNome()+ "Marca: " + this.getMarca() + "Preco: " + this.getPreco();
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", marca=" + marca + '}';
    }    
}
