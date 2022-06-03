/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author nicol
 */
public class Item  {
    private String nomeItem;
    private double valorItem;
    private String descricaoItem;
    private boolean TipoServico;

    public Item(String nomeItem, double valorItem, String descricaoItem, boolean TipoServico) {
        this.nomeItem = nomeItem;
        this.valorItem = valorItem;
        this.descricaoItem = descricaoItem;
        this.TipoServico = TipoServico;
    }

    
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public boolean isTipoServico() {
        return TipoServico;
    }

    public void setTipoServico(boolean TipoServico) {
        this.TipoServico = TipoServico;
    }

}