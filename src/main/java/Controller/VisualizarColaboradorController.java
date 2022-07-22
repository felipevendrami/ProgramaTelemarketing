package Controller;


import DAO.ColaboradorListDAO;
import Model.Colaborador;
import Repositorio.ColaboradorRepositorio;
import View.VisualizarColaboradorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julia
 */
public class VisualizarColaboradorController {
    
    private VisualizarColaboradorView visualizarColaborador;
    
    private Colaborador colaboradorSelecionado;
    
    public VisualizarColaboradorController(VisualizarColaboradorView visualizarColaborador, int idEntidade){
        this.visualizarColaborador = visualizarColaborador;
        this.colaboradorSelecionado = localizaColaborador(idEntidade);
        inicializarBotoes();
        preencheInformacoes();
    }

    public Colaborador localizaColaborador(int idEntidade){
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        for(Colaborador colaborador : colaboradorRepositorio.recuperarTodosColaboradores()){
            if(colaborador.getIdEntidade()== idEntidade){
                return colaborador;
            }
        }
        return null;
    }
    
    public void inicializarBotoes(){
        visualizarColaborador.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarColaborador.fecharTela();
            }
        });
    }
    
    public void preencheInformacoes(){
        visualizarColaborador.preencheInformacoesColaborador(colaboradorSelecionado.retornaInformacoes());
    }
    
    public void exibirTelaVisualizarColaborador(){
        visualizarColaborador.exibirTelaVisualizarColaborador();
    }
}
