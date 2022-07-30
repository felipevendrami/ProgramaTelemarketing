/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;
import Model.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author nicol
 */
public class ListaProdutosTableModel extends AbstractTableModel{
     private List<Produto> produtos;
    
    private final String[] atributoColunas = {"idProduto", "Nome", "Marca", "Preco"};
    private final int COLUNA_IDENTIDADE = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_MARCA = 2;
    private final int COLUNA_PRECO = 3;
    
    public ListaProdutosTableModel(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    public int getRowCount() {
        return produtos.size();
    }

    public int getColumnCount() {
        return atributoColunas.length;
    }
    
    public String getColumnName(int column) {
        return atributoColunas[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_IDENTIDADE:
                valor = Integer.toString(produto.getIdProduto());
                break;
            case COLUNA_NOME:
                valor = produto.getNome();
                break;
            case COLUNA_MARCA:
                valor = produto.getMarca();
                break;
            case COLUNA_PRECO:
                valor = produto.getPreco();
                break;
        }
        return valor;
    }
}
