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

    public Divulgacao(String tipoContato, String contato, Colaborador responsavel, String descricaoTramite, Empresa empresa, boolean conversao, Venda venda) {
        super(responsavel, descricaoTramite, empresa);
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.conversao = conversao;
        this.venda = venda;
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
    
    public void setConversao(boolean conversao){
        this.conversao = conversao;
    }
    
    public boolean isConversao() {
        return conversao;
    }
    
    public void setVenda(Venda venda){
        this.venda = venda;
    }
    
    public boolean existeVenda(){
        if(this.venda == null){
            return false;
        } else {
            return true;
        }
    }
}
