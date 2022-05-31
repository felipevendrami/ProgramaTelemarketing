/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nicol
 */
public class Produto extends Empresa{
        
    private String nomeProduto;
    private double valorProduto;
    private String descricaoProduto;
    private Empresa empresa;

    public Produto(String nomeProduto, double valorProduto, String descricaoProduto, Empresa empresa, String nome, Endereco endereco, Contato contato, String cnpj) {
        super(nome, endereco, contato, cnpj);
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.descricaoProduto = descricaoProduto;
        this.empresa = empresa;
    }

   
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
