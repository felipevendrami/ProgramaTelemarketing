/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author felip
 */
public interface IAtendimento {
    
    public String getDataHoraFormatado(LocalDateTime dataHora);
    public LocalDateTime getDataHoraAtual();
    public String retornaInformacoes();
    
}
