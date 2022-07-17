/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoListDAO;
import DAO.ColaboradorListDAO;
import Model.Atendimento;
import Model.Colaborador;
import Repositorio.AtendimentoRepositorio;
import Repositorio.ColaboradorRepositorio;
import View.RelatorioAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author felip
 */
public class RelatorioAtendimentoController {
    
    //View
    private RelatorioAtendimentoView relatorioAtendimento;

    public RelatorioAtendimentoController(RelatorioAtendimentoView relatorioAtendimento) {
        this.relatorioAtendimento = relatorioAtendimento;
        inicializarBotoes();
        montaListaComboboxColaborador();
    }
    
    public void exibirTelaRelatorioAtendimento(){
        relatorioAtendimento.exibirTelaRelatorioAtendimento();
    }
    
    public void inicializarBotoes(){
        relatorioAtendimento.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorioAtendimento.fecharTela();
            }
        });
        relatorioAtendimento.adicionarAcaoFiltroResponsavel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorioAtendimento.limpaTextArea();
                imprimeRelatorio(montarListaFiltroResponsavel());
            }
        });
        relatorioAtendimento.adicionarAcaoOrdenarPrioridade(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorioAtendimento.limpaTextArea();
                imprimeRelatorio(montaListaOrdenada());
            }
        });
    }
    
    public void montaListaComboboxColaborador(){
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        List<Colaborador> colaboradores = colaboradorRepositorio.recuperarTodosColaboradores();
        for(Colaborador colaborador : colaboradores){
            relatorioAtendimento.carregaComboboxColaborador(colaborador);
        }
    }
    
    //RECUPERADOS VIEW
    
    public void imprimeRelatorio(List<Atendimento> listaRelatorio){
        for(Atendimento atendimento : listaRelatorio){
            if(!atendimento.getSituacao().equals("Finalizado")){
                relatorioAtendimento.preencheRelatorio(atendimento.toString() + "\n");
            }
        }
    }
    
    public List<Atendimento> montaListaOrdenada(){
        /*if(cbResponsavel.getSelectedIndex() != (-1)){
            AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
            List<Atendimento> atendimentosList = atendimentoRepositorio.recuperarTodosAtendimentos();
            Collections.sort(atendimentosList);
            return atendimentosList;
        } else {*/
        List<Atendimento> atendimentoListResponsavel = montarListaFiltroResponsavel();
        Collections.sort(atendimentoListResponsavel);
        return atendimentoListResponsavel;
    }
    
    public List<Atendimento> montarListaFiltroResponsavel(){
        List<Atendimento> atendimentosResponsavel = new ArrayList<>();
        Colaborador responsavel = relatorioAtendimento.getResponsavel();
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        for(Atendimento atendimento : atendimentoRepositorio.recuperarTodosAtendimentos()){
            if(atendimento.getResponsavel() == responsavel){
                atendimentosResponsavel.add(atendimento);
            }
        }
        return atendimentosResponsavel;
    }
}
