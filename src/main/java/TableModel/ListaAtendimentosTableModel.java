/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Atendimento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class ListaAtendimentosTableModel extends AbstractTableModel{

    private List<Atendimento> atendimentos;
    
    //Colunas da Tabela
    private final String[] atributoColunas = {"IdAtendimento","Tipo","Empresa","Abertura","Situação","Última Atualiz."};
    private final int COLUNA_IDATENDIMENTO = 0;
    private final int COLUNA_TIPO = 1;
    private final int COLUNA_EMPRESA = 2;
    private final int COLUNA_ABERTURA = 3;
    private final int COLUNA_SITUACAO = 4;
    private final int COLUNA_ULTIMAATUALIZACAO = 5;

    public ListaAtendimentosTableModel(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
    
    @Override
    public int getRowCount() {
        return atendimentos.size();
    }

    @Override
    public int getColumnCount() {
        return atributoColunas.length;
    }

    @Override
    public String getColumnName(int column){
        return atributoColunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Atendimento atendimento = atendimentos.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_IDATENDIMENTO:
                valor = Integer.toString(atendimento.getIdAtendimento());
                break;
            case COLUNA_TIPO:
                valor = atendimento.getTipo();
                break;
            case COLUNA_EMPRESA:
                valor = atendimento.getEmpresa().getNome();
                break;
            case COLUNA_ABERTURA:
                valor = atendimento.getDataAbertura();
                break;
            case COLUNA_SITUACAO:
                valor = atendimento.getSituacao();
                break;
            case COLUNA_ULTIMAATUALIZACAO:
                valor = atendimento.retornarUltimoTramite().getDataTramite();
        }
        return valor;
    }
    
}
