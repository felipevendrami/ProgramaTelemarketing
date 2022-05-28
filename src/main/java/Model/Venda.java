/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author felip
 */
public class Venda {
    
    private static int geradorIdVenda = 0;
    
    private int idVenda;
    private String dataVenda;
    private String cliente;
    private List<Produto> itens;
    private double subtotal;
    private double acrescimo;
    private double desconto;
    private double total;

    public Venda(String cliente) {
        this.idVenda = geradorIdVenda ++;
        this.cliente = cliente;
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.dataVenda = timeStamp;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getTotal() {
        return total;
    }

    public double getAcrescimo() {
        return acrescimo;
    }
}
