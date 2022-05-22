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

    public Divulgacao(String responsavel, String produto, String cliente, String descricaoTramite) {
        super(responsavel, produto, cliente, descricaoTramite);
    }
    
    @Override
    public String toString() {
        return super.toString() + " Tipo Atendimento: Divulgação";
    }
    
}
