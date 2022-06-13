/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nicol
 */
public class TipoDesconto {

    private int codigo;
    private String nome;
    private String descricao;

    public TipoDesconto(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
      public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> tipoDesconto = new HashMap<String, String>();

    // Add keys and values (Country, City)
    tipoDesconto.put("Validade" , "Produto proximo da validade final");
    tipoDesconto.put("Oferta Relampago" , "Produto com uma super oferta");
    tipoDesconto.put("Oferta Limitada" , "Produto com ofertas limitadas");
    System.out.println(tipoDesconto);
  }
    
}
