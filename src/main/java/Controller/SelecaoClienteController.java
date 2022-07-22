/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteListDAO;
import Repositorio.ClienteRepositorio;
import View.SelecaoClienteView;
import java.util.List;
import Model.Cliente;

/**
 *
 * @author julia
 */
import TableModel.ListaClientesTableModel;
import View.VisualizarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class SelecaoClienteController {

    private SelecaoClienteView selecaoCliente;
    private CadastroVendaController cadastroVenda;

    public SelecaoClienteController(SelecaoClienteView selecaoCliente, CadastroVendaController cadastroVenda) {
        this.selecaoCliente = selecaoCliente;
        this.cadastroVenda = cadastroVenda;
        setTableModel();
        inicializarBotoes();
    }

    public void inicializarBotoes() {
        selecaoCliente.adicionarAcaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoCliente.fecharTela();
            }
        });
        selecaoCliente.adicionarAcaoVisualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    abreVisualizacaoCliente();
                } catch (Exception ex) {
                    selecaoCliente.exibirMensagem("Um erro aconteceu ao visualizar!");
                }
            }
        });
        selecaoCliente.adicionarAcaoSelecionar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClienteString = selecaoCliente.getClienteSelecionado();
                if (idClienteString == null) {
                    selecaoCliente.exibirMensagem("Nenhum cliente selecionado! ");
                } else {
                    int idCliente = Integer.parseInt(idClienteString);
                    cadastroVenda.setCliente(localizaCliente(idCliente));
                    cadastroVenda.carregaCliente();
                    selecaoCliente.fecharTela();
                }
            }
        });
    }

    public void abreVisualizacaoCliente() {
        String idClienteString = selecaoCliente.getClienteSelecionado();
        if (idClienteString == null) {
            selecaoCliente.exibirMensagem("Nenhum cliente selecionado! ");
        } else {
            int idCliente = Integer.parseInt(idClienteString);
            VisualizarClienteController visualizarClienteController = new VisualizarClienteController(new VisualizarClienteView(), localizaCliente(idCliente));
            visualizarClienteController.exibirTelaVisualizarCliente();
        }
    }

    public Cliente localizaCliente(int idEntidade) {
        ClienteRepositorio clienteRepositorio = new ClienteListDAO();
        for (Cliente cliente : clienteRepositorio.recuperarTodosClientes()) {
            if (cliente.getIdEntidade() == idEntidade) {
                return cliente;
            }
        }
        return null;
    }

    public void setTableModel() {
        ClienteRepositorio clienteRepositorio = new ClienteListDAO();
        List<Cliente> clientesEmLista = converterSetEmList(clienteRepositorio.recuperarTodosClientes());
        ListaClientesTableModel listaClientesTableModel = new ListaClientesTableModel(clientesEmLista);
        selecaoCliente.setTableModel(listaClientesTableModel);
    }

    public List<Cliente> converterSetEmList(Set<Cliente> clientesSet) {
        List<Cliente> clientesEmLista = new ArrayList<>();
        for (Cliente cliente : clientesSet) {
            clientesEmLista.add(cliente);
        }
        return clientesEmLista;
    }

    public void exibirTelaSelecaoCliente() {
        selecaoCliente.exibirTelaSelecaoCliente();
    }
}
