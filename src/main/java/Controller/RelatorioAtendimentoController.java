/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.RelatorioAtendimentoView;

/**
 *
 * @author felip
 */
public class RelatorioAtendimentoController {
    
    //View
    private RelatorioAtendimentoView relatorioAtendimento;

    public RelatorioAtendimentoController(RelatorioAtendimentoView relatorioAtendimento) {
        this.relatorioAtendimento = relatorioAtendimento;
    }
    
    public void exibirTelaRelatorioAtendimento(){
        relatorioAtendimento.exibirTelaRelatorioAtendimento();
    }
}
