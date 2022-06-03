/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private List<Item> itens;
    private double subtotal;
    private double total;
    private String situacao;
    
    //Situações pedido
    //1 - Cancelado
    //2 - Pendente
    //3 - Confirmado

    public Venda(String cliente, String situacao) {
        this.idVenda = geradorIdVenda ++;
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.dataVenda = timeStamp;
        this.situacao = situacao;
        this.subtotal = 0;
        this.total = 0;
    }
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public double getTotal() {
        return total;
    }
    
    public void addProduto(Item produto){
        this.itens.add(produto);
    }
    
    public void removeProduto(Item produto){
        this.itens.remove(produto);
    }
}