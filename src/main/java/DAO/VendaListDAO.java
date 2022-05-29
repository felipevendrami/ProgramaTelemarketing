/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Venda;
import Repositorio.VendaRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class VendaListDAO implements VendaRepositorio{

    private static List<Venda> vendas = new ArrayList<>();
    
    @Override
    public void salvarVenda(Venda venda) {
        vendas.add(venda);
    }

    @Override
    public List<Venda> recuperarTodasVendas() {
        return this.vendas;
    }
    
}
