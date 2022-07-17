/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoListDAO;
import Repositorio.AtendimentoRepositorio;
import TableModel.ListaAtendimentosTableModel;
import View.ListaAtendimentosView;
import View.VisualizarAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class ListaAtendimentosController {
    
    //View
    private ListaAtendimentosView listaAtendimentos;

    public ListaAtendimentosController(ListaAtendimentosView listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
        setTableModel();
        inicializarBotoes();
    }
    
    public void exibirTelaListaAtendimento(){
        listaAtendimentos.exibirTelaListaAtendimentos();
    }
    
    public void inicializarBotoes(){
        listaAtendimentos.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaAtendimentos.fecharTela();
            }
        });
        listaAtendimentos.adicionarAcaoVisualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abreVisualizacaoAtendimento();
                } catch (Exception ex) {
                    listaAtendimentos.exibirMensagem("Um erro aconteceu ao visualizar!");
                }
            }
        });
    }
    
    //TableModel
    public void setTableModel(){
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        ListaAtendimentosTableModel listaAtendimentosTableModel = new ListaAtendimentosTableModel(atendimentoRepositorio.recuperarTodosAtendimentos());
        listaAtendimentos.setTableModel(listaAtendimentosTableModel);
    }
    
    //RECUPERADOS VIEW
    
    public void abreVisualizacaoAtendimento(){
        String idAtendimentoString = listaAtendimentos.getAtendimentoSelecionado();
        if(idAtendimentoString == null){
            System.out.println("Nenhum atendimento selecionado !");
        } else {
            int idAtendimento = Integer.parseInt(idAtendimentoString);
            VisualizarAtendimentoController visualizarAtendimentoController = new VisualizarAtendimentoController(new VisualizarAtendimentoView(), idAtendimento);
            visualizarAtendimentoController.exibirTelaVisualizarAtendimento();
        }
        
    }
}
