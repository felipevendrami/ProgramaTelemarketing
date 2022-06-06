/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author julia
 */
public class Colaborador extends Entidade {
    
    private String setor;
    private String cargo;
    
    public Colaborador(String nome, Endereco endereco, Contato contato, String setor, String cargo) {
        super(nome, endereco, contato);
        this.setor = setor;
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
