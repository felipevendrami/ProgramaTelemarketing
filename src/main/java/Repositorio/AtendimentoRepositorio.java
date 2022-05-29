/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;

import Model.Atendimento;
import java.util.List;

/**
 *
 * @author felip
 */
public interface AtendimentoRepositorio {
    
    public void salvarAtendimento(Atendimento atendimento);
    public List<Atendimento> recuperarTodosAtendimentos();
    
}
