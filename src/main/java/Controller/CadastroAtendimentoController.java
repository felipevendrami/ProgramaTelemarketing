/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.CadastroAtendimentoView;

/**
 *
 * @author felip
 */
public class CadastroAtendimentoController {
    
    //View
    private CadastroAtendimentoView cadastroAtendimento;

    public CadastroAtendimentoController(CadastroAtendimentoView cadastroAtendimento) {
        this.cadastroAtendimento = cadastroAtendimento;
    }
    
    public void exibirTelaCadastroAtendimento(){
        cadastroAtendimento.exibirTelaCadastroAtendimento();
    }
    
}