/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author felip
 */
public abstract class Atendimento {
    
    private static int geradorIdAtendimento = 0;
    
    //LocalDateTime para as datas, verificar implementação
    private int idAtendimento;
    private String dataAbertura;
    private String dataFechamento;
    private String responsavel;
    private int situacao;
    private List<Tramite> tramites;
    private String empresa;
    
//    Situações atendimento:
//    1 = Aberto;
//    2 = Em andamento;
//    3 = Finalizada;

    public Atendimento(String responsavel, String descricaoTramite, String empresa){
        this.idAtendimento = geradorIdAtendimento ++;
        this.responsavel = responsavel;
        this.situacao = 1;
        this.dataAbertura = retornaTimestamp();
        this.tramites = new ArrayList<>();
        this.empresa = empresa;
        criarTramite(descricaoTramite, 1);
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }
    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String retornaTimestamp(){
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "idAtendimento=" + idAtendimento + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", responsavel=" + responsavel + ", situacao=" + situacao + ", tramites=" + tramites + '}';
    }


    public boolean criarTramite(String descricao, int tipoTramite){
        if(tipoTramite == 1 || tipoTramite == 2){
            Tramite tramite = new Tramite(descricao, tipoTramite);
            this.tramites.add(tramite);
            return true;
        } if(tipoTramite == 3){
            Tramite tramite = new Tramite(descricao, tipoTramite);
            this.tramites.add(tramite);
            finalizaAtendimento();
            return true;
        } else {
            return false;
        }
    }
    
    public void finalizaAtendimento(){
        this.dataFechamento = retornaTimestamp();
        this.situacao = 3;
    }
    
    public void imprimeTramites(){
        for(Tramite tramite : tramites){
            System.out.println(tramite.toString());
        }
    }
    
}
