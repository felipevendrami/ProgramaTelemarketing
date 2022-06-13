/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nicol
 */
public class Desconto {
   public Produto criarDesconto(int codigo, String nome , double valor, double percentDesc ,double valorDesc) {
       
        Produto produto = new Produto(codigo, nome, valor, percentDesc, valorDesc){
            @Override
            public double getValorDesc(){
                return valorDesc * valor;
            }
        };
       Produto Produto = null;
       return Produto;
}
}
