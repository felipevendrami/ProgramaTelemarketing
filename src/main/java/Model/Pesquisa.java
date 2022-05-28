/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felip
 */
public class Pesquisa extends Atendimento{

    private Venda venda;
    private int satisfacaoProduto;
    private int satisfacaoAtendimento;

    public Pesquisa(Venda venda, int satisfacaoProduto, int satisfacaoAtendimento, String responsavel, String descricaoTramite, String empresa) {
        super(responsavel, descricaoTramite, empresa);
        this.venda = venda;
        this.satisfacaoProduto = satisfacaoProduto;
        this.satisfacaoAtendimento = satisfacaoAtendimento;
    }

    @Override
    public String toString() {
        return super.toString() + " Pesquisa{" + "venda=" + venda + ", satisfacaoProduto=" + satisfacaoProduto + ", satisfacaoAtendimento=" + satisfacaoAtendimento + '}';
    }
    
    
    
}
