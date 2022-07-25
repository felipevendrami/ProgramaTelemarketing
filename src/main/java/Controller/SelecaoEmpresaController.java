/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmpresaListDAO;
import Repositorio.EmpresaRepositorio;
import TableModel.ListaEmpresaTableModel;
import View.SelecaoEmpresaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.Empresa;
import View.VisualizarEmpresaView;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author julia
 */
public class SelecaoEmpresaController {
    private SelecaoEmpresaView selecaoEmpresa;
    
    public SelecaoEmpresaController(SelecaoEmpresaView selecaoEmpresa){
        this.selecaoEmpresa = selecaoEmpresa;
        setTableModel();
        inicializarBotoes();
    }
    
    public void setTableModel(){
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        List<Empresa> empresasEmLista = converterSetEmList(empresaRepositorio.recuperarTodasEmpresas());
        ListaEmpresaTableModel listaEmpresasTableModel = new ListaEmpresaTableModel(empresasEmLista);
        selecaoEmpresa.setTableModel(listaEmpresasTableModel);
    }
    
    public void inicializarBotoes(){
        selecaoEmpresa.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoEmpresa.fecharTela();
            }
        });
        selecaoEmpresa.adicionarAcaoVisualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abreVisualizacaoEmpresa();
                } catch (Exception ex) {
                    selecaoEmpresa.exibirMensagem("Um erro aconteceu ao visualizar!");
                }
            }
        });
    }
    
    public void abreVisualizacaoEmpresa(){
        String idEmpresaString = selecaoEmpresa.getEmpresaSelecionada();
        if (idEmpresaString == null) {
            selecaoEmpresa.exibirMensagem("Nenhuma empresa selecionada! ");
        } else {
            int idEmpresa = Integer.parseInt(idEmpresaString);
            VisualizarEmpresaController visualizarEmpresaController = new VisualizarEmpresaController(new VisualizarEmpresaView(), idEmpresa);
            visualizarEmpresaController.exibirTelaVisualizarEmpresa();
        }
    }
    
    //Recebe Set, percorre Set, adiciona cada elemento na lista e retorna lista.
    public List<Empresa> converterSetEmList(Set<Empresa> empresasSet){
        List<Empresa> empresasEmLista = new ArrayList<>();
        for(Empresa empresa: empresasSet){
            empresasEmLista.add(empresa);
        }
        return empresasEmLista;
    }

    public void exibirTelaSelecaoEmpresa(){
        selecaoEmpresa.exibirTelaSelecaoEmpresa();
    }
}
