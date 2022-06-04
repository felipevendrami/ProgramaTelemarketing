/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author felip
 */
public class Tramite implements AtendimentoInterface{
    
    private static int geradorIdTramite = 0;
    
    private int idTramite;
    private LocalDateTime dataTramite;
    private String descricao;
    private String tipoTramite;

//    Tipos Tramite:
//    1 = Abertura;
//    2 = Em Andamento;
//    3 = Fechammento;
    
    public Tramite(String descricao, String tipoTramite) {
        this.idTramite = geradorIdTramite ++;
        this.descricao = descricao;
        this.tipoTramite = tipoTramite;
        this.dataTramite = getDataHoraAtual();
    }

    public int getIdTramite() {
        return idTramite;
    }

    public String getDataTramite() {
        return getDataHoraFormatado(dataTramite);
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        String retorno = "Tramite{" + "id=" + idTramite + ", dataTramite=" + dataTramite + ", descricao=" + descricao;
        if(this.tipoTramite.equals("Abertura")){
            retorno += ", tipoTramite=Abertura}";
        } if (this.tipoTramite.equals("Em Andamento")){
            retorno += ", tipoTramite=Em Andamento}";
        } if (this.tipoTramite.equals("Fechameto")){
            retorno += ", tipoTramite=Fechamento}";
        }
        return retorno;
    }
    
    @Override
    public String retornaInformacoes(){
        return "Id Trâmite: " + idTramite + "\nData Trâmite: " + getDataTramite() + "\nTipo do Trâmite: " + tipoTramite + "\nDescrição do Trâmite: " + descricao + "\n";
    }

    @Override
    public LocalDateTime getDataHoraAtual(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }
    
    @Override
    public String getDataHoraFormatado(LocalDateTime dataHora){
        String dataHoraFormatado = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dataHoraFormatado;
    }
}
