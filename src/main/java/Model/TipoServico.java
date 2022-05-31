/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author nicol
 */
public class TipoServico {
    private int colaboradores;
    private Date durabilidadeServico;
    private Produto produto;

    public TipoServico(int colaboradores, Date durabilidadeServico, Produto produto) {
        this.colaboradores = colaboradores;
        this.durabilidadeServico = durabilidadeServico;
        this.produto = produto;
    }

    public int getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(int colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Date getDurabilidadeServico() {
        return durabilidadeServico;
    }

    public void setDurabilidadeServico(Date durabilidadeServico) {
        this.durabilidadeServico = durabilidadeServico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
