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

public abstract class Atendimento implements IAtendimento, Comparable<Atendimento>{
    
    private static int geradorIdAtendimento = 0;
    protected int idAtendimento;
    protected LocalDateTime dataAbertura;
    protected LocalDateTime dataFechamento;
    protected Colaborador responsavel;
    protected String situacao;
    protected List<Tramite> tramites;
    protected Empresa empresa;
    protected String tipo;

    /*
    Situações:
        Aberto
        Finalizado
    */
    
    public Atendimento(Colaborador responsavel, String descricaoTramite, Empresa empresa){
        //this.idAtendimento = geradorIdAtendimento ++;
        this.responsavel = responsavel;
        this.situacao = "Aberto";
        this.dataAbertura = getDataHoraAtual();
        this.tramites = new ArrayList<>();
        this.empresa = empresa;
        defineTipoAtendimento();
        criarTramite(descricaoTramite, "Abertura");
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    
    public String getSituacao(){
        return this.situacao;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public Empresa getEmpresa(){
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
    
    public Colaborador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Colaborador responsavel) {
        this.responsavel = responsavel;
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

    @Override
    public String toString() {
        return "Id: " + idAtendimento + " | Data Abertura: " + getDataAbertura() + " | Responsável: " + responsavel + " | Situação: " + situacao;
    }
    
    public List<Tramite> getTramites(){
        return this.tramites;
    }
    
    @Override
    public String retornaInformacoes(){
        String retorno = "Id Atendimento: " + idAtendimento + "\nData Abertura: " + getDataAbertura() + "\nSituação: " + situacao + "\nResponsável: " + responsavel;
        if(this.situacao.equalsIgnoreCase("Finalizado")){
            retorno += "\nData Fechamento: " + getDataFechamento();
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

    @Override
    public int compareTo(Atendimento o){
        if(this.dataAbertura.isBefore(o.dataAbertura)){
            return -1;
        } else if (this.dataAbertura.isAfter(o.dataAbertura)){
            return 1;
        }
        return 0;
    }
    
    public Tramite retornarUltimoTramite(){
        Tramite ultimoTramite = this.tramites.get(this.tramites.size()-1);
        return ultimoTramite;
    }
}
