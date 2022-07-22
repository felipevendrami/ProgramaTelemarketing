/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ColaboradorListDAO;
import Repositorio.ColaboradorRepositorio;
import TableModel.ListaColaboradoresTableModel;
import View.SelecaoColaboradorView;
import View.VisualizarColaboradorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author julia
 */
public class SelecaoColaboradorController {
    
    private SelecaoColaboradorView selecaoColaborador;
    
    public SelecaoColaboradorController(SelecaoColaboradorView selecaoColaborador){
        this.selecaoColaborador = selecaoColaborador;
        setTableModel();
        inicializarBotoes();
    }
    
    //TableModel
    public void setTableModel(){
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        ListaColaboradoresTableModel listaColaboradoresTableModel = new ListaColaboradoresTableModel(colaboradorRepositorio.recuperarTodosColaboradores());
        selecaoColaborador.setTableModel(listaColaboradoresTableModel);
    }
    
    public void inicializarBotoes(){
        selecaoColaborador.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoColaborador.fecharTela();
            }
        });
        selecaoColaborador.adicionarAcaoVisualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abreVisualizacaoColaborador();
                } catch (Exception ex) {
                    selecaoColaborador.exibirMensagem("Um erro aconteceu ao visualizar!");
                }
            }
        });
    }
    
    public void abreVisualizacaoColaborador(){
        String idColaboradorString = selecaoColaborador.getColaboradorSelecionado();
        if(idColaboradorString == null){
            selecaoColaborador.exibirMensagem("Nenhum colaborador selecionado !");
        } else {
            int idColaborador = Integer.parseInt(idColaboradorString);
            VisualizarColaboradorController visualizarColaboradorController = new VisualizarColaboradorController(new VisualizarColaboradorView(), idColaborador);
            visualizarColaboradorController.exibirTelaVisualizarColaborador();
        }
    }
    
    public void exibirTelaSelecaoColaborador(){
        selecaoColaborador.exibirTelaSelecaoColaborador();
    }
}
