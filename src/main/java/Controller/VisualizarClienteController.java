/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cliente;
import View.VisualizarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author julia
 */
public class VisualizarClienteController {
    
    private VisualizarClienteView visualizarCliente;
    
    private Cliente clienteSelecionado;
    
    public VisualizarClienteController(VisualizarClienteView visualizarCliente, Cliente cliente){
        this.visualizarCliente = visualizarCliente;
        this.clienteSelecionado = cliente;
        inicializarBotoes();
        preencheInformacoes();
    }
    
    public void inicializarBotoes(){
        visualizarCliente.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarCliente.fecharTela();
            }
        });
    }
    
    public void preencheInformacoes(){
        visualizarCliente.preencheInformacoesCliente(clienteSelecionado.retornaInformacoes());
    }
    
    public void exibirTelaVisualizarCliente(){
        visualizarCliente.exibirTelaVisualizarCliente();
    }
}
