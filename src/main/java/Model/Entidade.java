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

    @Override
    public String toString() {
        String informacoes =  "ID da Entidade: " + this.getIdEntidade() + "\nNome: " + this.getNome() +
                "\nEstado: " + this.getEndereco().getEstado() + " -- Cidade: " + this.getEndereco().getCidade() + " -- Bairro: " + 
                this.getEndereco().getBairro() + " -- Rua: " + this.getEndereco().getRua();
        for (Contato contato : contatos) {
            informacoes += "\nEmail: " + contato.getEmail() + " -- Telefone: " + contato.getTelefone();
        }
        
        return informacoes;
    }
    
    
}
