/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author julia
 */
public class ListaClientesTableModel extends AbstractTableModel{
    
    private List<Cliente> clientes;
    
    private final String[] atributoColunas = {"idEntidade", "Nome Cliente", "Cidade", "UF", "Bairro", "Rua"};
    private final int COLUNA_IDENTIDADE = 0;
    private final int COLUNA_NOME_CLIENTE = 1;
    private final int COLUNA_CIDADE = 2;
    private final int COLUNA_UF = 3;
    private final int COLUNA_BAIRRO = 4;
    private final int COLUNA_RUA = 5;
    
    public ListaClientesTableModel(List<Cliente> clientes){
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
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
        Cliente cliente = clientes.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_IDENTIDADE:
                valor = Integer.toString(cliente.getIdEntidade());
                break;
            case COLUNA_NOME_CLIENTE:
                valor = cliente.getNome();
                break;
            case COLUNA_CIDADE:
                valor = cliente.getEndereco().getCidade();
                break;
            case COLUNA_UF:
                valor = cliente.getEndereco().getEstado();
                break;
            case COLUNA_BAIRRO:
                valor = cliente.getEndereco().getBairro();
                break;
            case COLUNA_RUA:
                valor = cliente.getEndereco().getRua();
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
        Cliente cliente = this.clientes.get(rowIndex);
        switch (columnIndex) {
            case COLUNA_CIDADE:
                cliente.getEndereco().setCidade((String) aValue);
                break;
            case COLUNA_NOME_CLIENTE:
                cliente.setNome((String) aValue);
                break;
            case COLUNA_UF:
                cliente.getEndereco().setEstado((String) aValue);
                break;
            case COLUNA_BAIRRO:
                cliente.getEndereco().setBairro((String) aValue);
                break;
            case COLUNA_RUA:
                cliente.getEndereco().setRua((String) aValue);
                break;
        }
        fireTableDataChanged();
    }
    
    
    
}
