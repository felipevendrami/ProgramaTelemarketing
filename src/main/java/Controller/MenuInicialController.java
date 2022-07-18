/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.CadastroAtendimentoView;
import View.ListaAtendimentosView;
import View.MenuInicialView;
import View.RelatorioAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;

/**
 *
 * @author felip
 */
public class MenuInicialController {
    
    //View MenuInicial
    private MenuInicialView menuInicial;
    
    //Controllers Produto
    
    
    //Controllers Entidade
    
    
    //Controllers Atendimento
    private CadastroAtendimentoController cadastroAtendimento;
    private RelatorioAtendimentoController relatorioAtendimento;
    private ListaAtendimentosController listaAtendimento;

    public MenuInicialController(MenuInicialView menuInicial) {
        this.menuInicial = menuInicial;
        inicializarBotoes();
    }
    
    public void exibirTelaMenuInicial(){
        menuInicial.exibirTelaMenuInicial();
    }
    
    public void inicializarBotoes(){
        menuInicial.adicionarAcaoNovoAtendimento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaCadastroAtendimento();
                cadastroAtendimento.exibirTelaCadastroAtendimento();
            }
        });
        menuInicial.adicionarAcaoListaAtendimentos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializaTelaListaAtendimento();
                listaAtendimento.exibirTelaListaAtendimento();
            }
        });
        menuInicial.adicionarAcaoRelatorioAtendimentos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarTelaRelatorioAtendimento();
                relatorioAtendimento.exibirTelaRelatorioAtendimento();
            }
        });
    }
    
    public void inicializarTelaCadastroAtendimento(){
        cadastroAtendimento = new CadastroAtendimentoController(new CadastroAtendimentoView());
    }
    
    public void inicializaTelaListaAtendimento(){
        listaAtendimento = new ListaAtendimentosController(new ListaAtendimentosView());
    }
    
    public void inicializarTelaRelatorioAtendimento(){
        relatorioAtendimento = new RelatorioAtendimentoController(new RelatorioAtendimentoView());
    }
}
