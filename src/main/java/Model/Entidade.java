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

public abstract class Entidade {
    private static int geradorIdEntidade = 0;
    
    private int idEntidade;
    protected String nome;
    protected Endereco endereco;
    protected List<Contato> contatos;
    
    
    public Entidade(String nome, Endereco endereco, Contato contato){
        this.idEntidade = geradorIdEntidade ++;
        this.nome = nome;
        this.endereco = endereco;
        this.contatos = new ArrayList<>();
        this.addContato(contato);
    }
    
    public int getIdEntidade() {
        return this.idEntidade;
    }    
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
    
    public void addContato(Contato contato){
        this.contatos.add(contato);
    }
    
    public void imprimeContatos(){
        for(Contato contato : contatos){
            System.out.println(contato.toString());
        }
    }

    public String retornaInformacoes() {
        String informacoes =  "ID da Entidade: " + this.getIdEntidade() + "\nNome: " + this.getNome() +
                "\nEstado: " + this.getEndereco().getEstado() + "\nCidade: " + this.getEndereco().getCidade() + "\nBairro: " + 
                this.getEndereco().getBairro() + "\nRua: " + this.getEndereco().getRua();
        for (Contato contato : contatos) {
            if (contato != null) {
                informacoes += "\nEmail: " + contato.getEmail() + "\nTelefone: " + contato.getTelefone();
            }
        }
        
        return informacoes;        
    }
    
    @Override
    public String toString() {
        return "Entidade{" + "idEntidade=" + idEntidade + ", nome=" + nome + ", endereco=" + endereco + ", contatos=" + contatos + '}';
    }
}
