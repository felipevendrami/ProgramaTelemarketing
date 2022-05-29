/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author felip
 */
public class Tramite {
    
    private static int geradorIdTramite = 0;
    
    private int idTramite;
    private String dataTramite;
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
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.dataTramite = timeStamp;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public String getDataTramite() {
        return dataTramite;
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
    
    public String informacoesTramite(){
        return "Id Trâmite: " + idTramite + "\nData Trâmite: " + dataTramite + "\nTipo do Trâmite: " + tipoTramite + "\nDescrição do Trâmite: " + descricao;
    }
    
}
