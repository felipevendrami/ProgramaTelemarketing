/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author felip
 */
public class AtendimentoComparator implements Comparator<Atendimento>{

    @Override
    public int compare(Atendimento o1, Atendimento o2) {
        if(o1.retornarUltimoTramite().getDataTramiteNaoFormadato().isBefore(o2.retornarUltimoTramite().getDataTramiteNaoFormadato()) || o1.getSituacao().equals("Aberto")){
            return -1;
        } else if (o1.retornarUltimoTramite().getDataTramiteNaoFormadato().isAfter(o2.retornarUltimoTramite().getDataTramiteNaoFormadato()) || o1.getSituacao().equals("Finalizado")){
            return 1;
        }
        return 0;
    }
    
}
