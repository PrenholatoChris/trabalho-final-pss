package com.view;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloVisualTabela extends AbstractTableModel{
    private final List<String> nomesColunas;
    private final List<List<Object>> dados;
    
    public ModeloVisualTabela(List<String> nomesColunas){
        this.nomesColunas = nomesColunas;
        this.dados = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return nomesColunas.size();
    }
    
    @Override
    public String getColumnName(int col){
        return nomesColunas.get(col);
    }
    
    @Override
    public int getRowCount(){
        return dados.size();
    }
    
    @Override
    public Object getValueAt(int row, int col){
        return dados.get(row).get(col);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex){
        return false;
    }
    
    public void addRow(List<Object> dadosRow){
        dados.add(dadosRow);
        fireTableRowsInserted(dados.size() - 1, dados.size());
    }
    
    public void clearRows(){
        dados.clear();
    }
}
