/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nicol
 */
public class Produto{
    protected int codigo;
    protected String nome;
    protected double valor;
    protected double percentDesc;
    protected double valorDesc;

    public Produto(int codigo, String nome, double valor, double percentDesc, double valorDesc) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.percentDesc = percentDesc;
        this.valorDesc = valorDesc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPercentDesc() {
        return percentDesc;
    }

    public void setPercentDesc(double percentDesc) {
        this.percentDesc = percentDesc;
    }

    public double getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(double valorDesc) {
        this.valorDesc = valorDesc;
    }

    
}

