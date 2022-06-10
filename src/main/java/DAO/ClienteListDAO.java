/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cliente;
import Repositorio.ClienteRepositorio;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author julia
 */
public class ClienteListDAO implements ClienteRepositorio{

    private static Set<Cliente> clientes = new HashSet<>();
    
    @Override
    public boolean salvarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    @Override
    public Set<Cliente> recuperarTodosClientes() {
        return this.clientes;
    }
    
}
