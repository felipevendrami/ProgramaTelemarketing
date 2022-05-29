/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;

import Model.Venda;
import java.util.List;

/**
 *
 * @author felip
 */
public interface VendaRepositorio {
    
    public void salvarVenda(Venda venda);
    public List<Venda> recuperarTodasVendas();
    
}
