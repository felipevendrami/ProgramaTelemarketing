/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Model.Cliente;
import java.util.Set;
/**
 *
 * @author julia
 */
public interface ClienteRepositorio {
    
    public boolean salvarCliente(Cliente cliente);
    public Set<Cliente> recuperarTodosClientes();
    
}
