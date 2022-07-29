/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmpresaListDAO;
import Model.Empresa;
import Repositorio.EmpresaRepositorio;
import View.VisualizarEmpresaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author julia
 */
public class VisualizarEmpresaController {
    
    private VisualizarEmpresaView visualizarEmpresa;
    
    private Empresa empresaSelecionada;
    
    //Localiza empresa através do Set pelo Id e joga as informações da empresa para a tela.
    public VisualizarEmpresaController(VisualizarEmpresaView visualizarEmpresa, int idEntidade){
        this.visualizarEmpresa = visualizarEmpresa;
        this.empresaSelecionada = localizaEmpresa(idEntidade);
        inicializarBotoes();
        preencheInformacoes();
    }
    
    public Empresa localizaEmpresa(int idEntidade){
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        for (Empresa empresa : empresaRepositorio.recuperarTodasEmpresas()) {
            if (empresa.getIdEntidade() == idEntidade) {
                return empresa;
            } 
        }
        return null;
    }
    
     public void inicializarBotoes(){
        visualizarEmpresa.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarEmpresa.fecharTela();
            }
        });
    }
     
    public void preencheInformacoes(){
        visualizarEmpresa.preencheInformacoesEmpresa(empresaSelecionada.retornaInformacoes());
    }
    
    public void exibirTelaVisualizarEmpresa(){
        visualizarEmpresa.exibirTelaVisualizarEmpresa();
    }
}
