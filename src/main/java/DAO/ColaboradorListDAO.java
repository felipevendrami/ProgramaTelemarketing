/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Colaborador;
import Repositorio.ColaboradorRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class ColaboradorListDAO implements ColaboradorRepositorio{

    private static List<Colaborador> colaboradores = new ArrayList<>();
    
    @Override
    public void salvarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    @Override
    public List<Colaborador> recuperarTodosColaboradores() {
        return this.colaboradores;
    }
    
}
