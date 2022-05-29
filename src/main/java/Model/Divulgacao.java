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

    public Divulgacao(String tipoContato, String contato, String responsavel, String descricaoTramite, String empresa) {
        super(responsavel, descricaoTramite, empresa);
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.conversao = false;
    }

    @Override
    public String toString() {
        return super.toString() + " Divulgacao{" + "tipoContato=" + tipoContato + ", contato=" + contato + ", conversao=" + conversao + '}';
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
    
    public boolean gerarVenda(String cliente, int situacao){
        Venda venda = new Venda(cliente, situacao);
        this.venda = venda;
        if(this.venda.getSituacao() == 3){
            this.conversao = true;
        }
        return true;
    }

}
