/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felip
 */
public class Divulgacao extends Atendimento{

    private String tipoContato;
    private String contato;
    private boolean conversao;
    private Venda venda;

    public Divulgacao(String tipoContato, String contato, Colaborador responsavel, String descricaoTramite, Empresa empresa) {
        super(responsavel, descricaoTramite, empresa);
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.conversao = false;
    }

    @Override
    public String toString() {
        return super.toString() + " |  Tipo: Divulgacao | Contato: " + contato + " | Conversão ? " + conversao;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public boolean isConversao() {
        return conversao;
    }    
    
    public boolean gerarVenda(Cliente cliente, String situacao){
        Venda venda = new Venda(cliente, situacao);
        this.venda = venda;
        if(this.venda.getSituacao().equals("Confirmado")){
            this.conversao = true;
        }
        return true;
    }
}
