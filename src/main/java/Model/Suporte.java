/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felip
 */
public class Suporte extends Atendimento{

    private Venda venda;

    public Suporte(Venda venda, String responsavel, String descricaoTramite, String empresa) {
        super(responsavel, descricaoTramite, empresa);
        this.venda = venda;
    }

    @Override
    public String toString() {
        return super.toString() + " Suporte{" + "venda=" + venda + '}';
    }
    
    
    
}
