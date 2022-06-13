/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class Venda {
    
    private static int geradorIdVenda = 0;
    
    private int idVenda;
    private LocalDateTime dataVenda;
    private Cliente cliente;
    private List<Produto> itens;
    private double subtotal;
    private double total;
    private String situacao;
    
    //Situações pedido
    //1 - Cancelado
    //2 - Pendente
    //3 - Confirmado

    public Venda(Cliente cliente, String situacao) {
        this.idVenda = geradorIdVenda ++;
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.dataVenda = getDataHoraAtual();
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
        return getDataHoraFormatado(dataVenda);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
    
    public void addProduto(Produto produto){
        this.itens.add(produto);
    }
    
    public void removeProduto(Produto produto){
        this.itens.remove(produto);
    }
    
    public String getDataHoraFormatado(LocalDateTime dataHora){
        String dataHoraFormatado = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dataHoraFormatado;
    }
    
    public LocalDateTime getDataHoraAtual(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }
    
    public String retornaInformacoesCurto(){
        String retorno = "Id: " + idVenda + " | Cliente: " + cliente.getNome() + " | Total: " + total;
        return retorno;
    }
}