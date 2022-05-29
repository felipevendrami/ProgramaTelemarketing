/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author julia
 */
public class Contato {
    private static int geradorIdContato = 0;
    
    private int idContato;
    private String nome;
    private String telefone;
    private String email;
    
    public Contato(String nome, String telefone, String email){
        this.idContato = geradorIdContato ++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdContato() {
        return idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
