/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;
import Model.Colaborador;
import java.util.List;

/**
 *
 * @author julia
 */
public interface ColaboradorRepositorio {
    public void salvarColaborador(Colaborador colaborador);
    public List<Colaborador> recuperarTodosColaboradores();
}
