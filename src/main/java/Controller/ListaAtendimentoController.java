/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.ListaAtendimentosView;

/**
 *
 * @author felip
 */
public class ListaAtendimentoController {
    
    //View
    private ListaAtendimentosView listaAtendimentos;

    public ListaAtendimentoController(ListaAtendimentosView listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
    }
    
    public void exibirTelaListaAtendimento(){
        listaAtendimentos.exibirTelaListaAtendimentos();
    }
}
