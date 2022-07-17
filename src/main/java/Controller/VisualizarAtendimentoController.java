/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoListDAO;
import Model.Atendimento;
import Model.Tramite;
import Repositorio.AtendimentoRepositorio;
import View.CadastroTramiteView;
import View.VisualizarAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class VisualizarAtendimentoController {
    
    //View
    private VisualizarAtendimentoView visualizarAtendimento;

    private Atendimento atendimentoSelecionado;
    
    public VisualizarAtendimentoController(VisualizarAtendimentoView visualizarAtendimento, int idAtendimento) {
        this.visualizarAtendimento = visualizarAtendimento;
        this.atendimentoSelecionado = localizaAtendimento(idAtendimento);
        inicializarBotoes();
        preencheInformacoesAtendimento();
        preencheInformacoesTramites();
    }
    
    public void exibirTelaVisualizarAtendimento(){
        visualizarAtendimento.exibirTelaVisualizarAtendimento();
    }
    
    public void inicializarBotoes(){
        visualizarAtendimento.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarAtendimento.fecharTela();
            }
        });
        visualizarAtendimento.adicionarAcaoNovoTramite(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaCadastroTramite();
            }
        });
    }
    
    public Atendimento localizaAtendimento(int idAtendimento){
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        for(Atendimento atendimento : atendimentoRepositorio.recuperarTodosAtendimentos()){
            if(atendimento.getIdAtendimento() == idAtendimento){
                return atendimento;
            }
        }
        return null;
    }
    
    public void exibirTelaCadastroTramite(){
        CadastroTramiteController cadastroTramiteController = new CadastroTramiteController(new CadastroTramiteView(), atendimentoSelecionado);
        cadastroTramiteController.exibirTelaCadastroTramite();
    }
    
    //RECUPERADOS VIEW
    
    public void preencheInformacoesAtendimento(){
        visualizarAtendimento.setInformacaoAtendimento(atendimentoSelecionado.retornaInformacoes());
    }
    
    public void preencheInformacoesTramites(){
        for(Tramite tramite : this.atendimentoSelecionado.getTramites()){
            visualizarAtendimento.setInformacaoTramite("============ Trâmite ============\n" + tramite.retornaInformacoes());
        }
    }
}
