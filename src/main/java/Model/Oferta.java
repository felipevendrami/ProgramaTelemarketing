/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nicol
 */
public class Oferta {

    public Item criarOferta(String nomeItem, double valorItem, String descricaoItem, boolean TipoServico) {
        Item item = new Item(nomeItem, valorItem, descricaoItem, TipoServico) {
            @Override
            public double getValorItem() {
                if (TipoServico) {
                    return valorItem * 0.10;
                } else {
                    return valorItem * 0.05;
                }
            }
        };
        return item;
    }
    
}
