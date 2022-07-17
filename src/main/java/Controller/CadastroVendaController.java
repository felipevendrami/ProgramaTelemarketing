/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Atendimento;
import Model.IAtendimentoDivulgacao;
import View.CadastroVendaView;

/**
 *
 * @author felip
 */
public class CadastroVendaController {
    
    //View
    private CadastroVendaView cadastroVenda;
    
    //Atendimento Divulgação
    private Atendimento atendimentoDivulgacao;

    public CadastroVendaController(CadastroVendaView cadastroVenda, Atendimento atendimentoDivulgacao) {
        this.cadastroVenda = cadastroVenda;
        this.atendimentoDivulgacao = atendimentoDivulgacao;
    }
    
    public void exibirTelaCadastroVenda(){
        
    }
    
    public void inicializatBotoes(){
        
    }
}
