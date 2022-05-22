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
    
    private int id;
    private String dataAbertura;
    private String dataFechamento;
    private String setor;
    private String responsavel;
    private String produto;
    private String cliente;
    private int situacao;
    private List<Tramite> tramites;
    
//    Situações atendimento:
//    1 = Aberto;
//    2 = Em andamento;
//    3 = Finalizada;

    public Atendimento(String responsavel, String produto, String cliente, String descricaoTramite){
        this.id = geradorIdAtendimento ++;
        this.responsavel = responsavel;
        this.produto = produto;
        this.cliente = cliente;
        this.situacao = 1;
        this.dataAbertura = retornaTimestamp();
        this.tramites = new ArrayList<>();
        criarTramite(descricaoTramite, 1);
    }

    public int getId() {
        return id;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public String getSetor() {
        return setor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String retornaTimestamp(){
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", setor=" + setor + ", responsavel=" + responsavel + ", produto=" + produto + ", cliente=" + cliente + ", situacao=" + situacao + '}';
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
