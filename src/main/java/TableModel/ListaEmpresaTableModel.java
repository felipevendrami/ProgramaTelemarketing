/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Empresa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author julia
 */
public class ListaEmpresaTableModel extends AbstractTableModel{

    private List<Empresa> empresas;
    
    private final String[] atributoColunas = {"idEntidade", "Nome Empresa", "Cidade", "UF"};
    private final int COLUNA_IDENTIDADE = 0;
    private final int COLUNA_NOME_EMPRESA = 1;
    private final int COLUNA_CIDADE = 2;
    private final int COLUNA_UF = 3;
    
    public ListaEmpresaTableModel(List<Empresa> empresas){
        this.empresas = empresas;
    }
    
    @Override
    public int getRowCount() {
        return empresas.size();
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
        Empresa empresa = empresas.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_IDENTIDADE:
                valor = Integer.toString(empresa.getIdEntidade());
                break;
            case COLUNA_NOME_EMPRESA:
                valor = empresa.getNome();
                break;
            case COLUNA_CIDADE:
                valor = empresa.getEndereco().getCidade();
                break;
            case COLUNA_UF:
                valor = empresa.getEndereco().getEstado();
                break;
        }
        return valor;
    }
    
}
