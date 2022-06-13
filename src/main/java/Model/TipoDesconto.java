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
    private HashMap<String, String> tipodesconto;

    public TipoDesconto(int codigo, String nome, String descricao) {
        this.tipodesconto = new HashMap();
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
    
    public void setMapTipoDesconto(){
        HashMap<String, String> tipoDesconto = new HashMap<String, String>();

        tipoDesconto.put("Validade" , "Produto proximo da validade final");
        tipoDesconto.put("Oferta Relampago" , "Produto com uma super oferta");
        tipoDesconto.put("Oferta Limitada" , "Produto com ofertas limitadas");
    }
    
    public HashMap getTipoDesconto(){
        return this.tipodesconto;
    }
}

