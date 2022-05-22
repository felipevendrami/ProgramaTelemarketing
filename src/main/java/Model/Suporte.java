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

    public Suporte(String responsavel, String produto, String cliente, String descricaoTramite) {
        super(responsavel, produto, cliente, descricaoTramite);
    }
    
    @Override
    public String toString() {
        return super.toString() + " Tipo Atendimento: Suporte";
    }
}
