/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Atendimento;
import Repositorio.AtendimentoRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class AtendimentoListDAO implements AtendimentoRepositorio{

    private static List<Atendimento> atendimentos = new ArrayList<>();
    
    @Override
    public void salvarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    @Override
    public List<Atendimento> recuperarTodosAtendimentos() {
        return this.atendimentos;
    }
    
    
}
