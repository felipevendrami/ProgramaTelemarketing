/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cliente;
import Repositorio.ClienteRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class ClienteListDAO implements ClienteRepositorio{

    private static List<Cliente> clientes = new ArrayList<>();
    
    @Override
    public void salvarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> recuperarTodosClientes() {
        return this.clientes;
    }
    
}
