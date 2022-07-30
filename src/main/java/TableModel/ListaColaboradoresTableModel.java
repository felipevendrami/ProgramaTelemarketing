/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Colaborador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author julia
 */
public class ListaColaboradoresTableModel extends AbstractTableModel{

    private List<Colaborador> colaboradores;
    
    //Colunas da Tabela
    private final String[] atributoColunas = {"IdEntidade","Nome Colaborador","Cidade","UF","Bairro","Rua"};
    private final int COLUNA_IDENTIDADE = 0;
    private final int COLUNA_NOME_COLABORADOR = 1;
    private final int COLUNA_CIDADE = 2;
    private final int COLUNA_UF = 3;
    private final int COLUNA_BAIRRO = 4;
    private final int COLUNA_RUA = 5;
    
    public ListaColaboradoresTableModel(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
    
    @Override
    public int getRowCount() {
        return colaboradores.size();
    }

    @Override
    public int getColumnCount() {
        return atributoColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return atributoColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Colaborador colaborador = colaboradores.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_IDENTIDADE:
                valor = Integer.toString(colaborador.getIdEntidade());
                break;
            case COLUNA_NOME_COLABORADOR:
                valor = colaborador.getNome();
                break;
            case COLUNA_CIDADE:
                valor = colaborador.getEndereco().getCidade();
                break;
            case COLUNA_UF:
                valor = colaborador.getEndereco().getEstado();
                break;
            case COLUNA_BAIRRO:
                valor = colaborador.getEndereco().getBairro();
                break;
            case COLUNA_RUA:
                valor = colaborador.getEndereco().getRua();
                break;
        }
        return valor;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Colaborador colaborador = this.colaboradores.get(rowIndex);
        switch (columnIndex) {
            case COLUNA_CIDADE:
                colaborador.getEndereco().setCidade((String) aValue);
                break;
            case COLUNA_NOME_COLABORADOR:
                colaborador.setNome((String) aValue);
                break;
            case COLUNA_UF:
                colaborador.getEndereco().setEstado((String) aValue);
                break;
            case COLUNA_BAIRRO:
                colaborador.getEndereco().setBairro((String) aValue);
                break;
            case COLUNA_RUA:
                colaborador.getEndereco().setRua((String) aValue);
                break;
        }
        fireTableDataChanged();
    }
    
    
    
}
