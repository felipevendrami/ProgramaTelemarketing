/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public abstract class Atendimento implements AtendimentoInterface{
    
    private static int geradorIdAtendimento = 0;
    
    //LocalDateTime para as datas, verificar implementação
    private int idAtendimento;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private String responsavel;
    private String situacao;
    private List<Tramite> tramites;
    private String empresa;
    private String tipo;
    
//    Situações atendimento:
//    1 = Aberto;
//    2 = Em andamento;
//    3 = Finalizada;

    public Atendimento(String responsavel, String descricaoTramite, String empresa){
        this.idAtendimento = geradorIdAtendimento ++;
        this.responsavel = responsavel;
        this.situacao = "Aberto";
        this.dataAbertura = getDataHoraAtual();
        this.tramites = new ArrayList<>();
        this.empresa = empresa;
        defineTipoAtendimento();
        criarTramite(descricaoTramite, "Abertura");
    }

    public String getSituacao(){
        return this.situacao;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getEmpresa(){
        return this.empresa;
    }
    
    public int getIdAtendimento() {
        return idAtendimento;
    }

    public String getDataAbertura() {
        return getDataHoraFormatado(dataAbertura);
    }

    public String getDataFechamento() {
        return getDataHoraFormatado(dataFechamento);
    }
    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public LocalDateTime getDataHoraAtual(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }
    
    public String getDataHoraFormatado(LocalDateTime dataHora){
        String dataHoraFormatado = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dataHoraFormatado;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "idAtendimento=" + idAtendimento + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", responsavel=" + responsavel + ", situacao=" + situacao;
    }
    
    public List<Tramite> getTramites(){
        return this.tramites;
    }
    
    @Override
    public String retornaInformacoes(){
        String retorno = "Id Atendimento: " + idAtendimento + "\nData Abertura: " + dataAbertura + "\nSituação: " + situacao + "\nResponsável: " + responsavel;
        if(this.situacao.equalsIgnoreCase("Finalizado")){
            retorno += "\nData Fechamento: " + dataFechamento;
        }
        return retorno;
    }
    
    public boolean criarTramite(String descricao, String tipoTramite){
        if(tipoTramite.equals("Abertura") || tipoTramite.equals("Em Andamento")){
            Tramite tramite = new Tramite(descricao, tipoTramite);
            this.tramites.add(tramite);
            return true;
        } if(tipoTramite == "Fechamento"){
            Tramite tramite = new Tramite(descricao, tipoTramite);
            this.tramites.add(tramite);
            finalizaAtendimento();
            return true;
        } else {
            return false;
        }
    }
    
    public void finalizaAtendimento(){
        this.dataFechamento = getDataHoraAtual();
        this.situacao = "Finalizado";
    }
    
    public void defineTipoAtendimento(){
        if(this instanceof Divulgacao){
            this.tipo = "Divulgacao";
        } else if (this instanceof Suporte){
            this.tipo = "Suporte";
        } else if (this instanceof Pesquisa){
            this.tipo = "Pesquisa";
        }
    }
}
