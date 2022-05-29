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
public class Cliente extends Entidade{
    
    private String cpf;
    private List<Venda> vendas;
    private List<Atendimento> atendimentos;
    
    public Cliente(String nome, Endereco endereco, Contato contato, String cpf) {
        super(nome, endereco, contato);
        this.cpf = cpf;
        this.vendas = new ArrayList<>();
        this.atendimentos = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void addVenda(Venda venda){
        this.vendas.add(venda);
    }
    
    public void addAtendimento(Atendimento atendimento){
        this.atendimentos.add(atendimento);
    }    
}
