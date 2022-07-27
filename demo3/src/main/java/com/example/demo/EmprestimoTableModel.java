package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EmprestimoTableModel  extends AbstractTableModel{




    private List<Emprestimo> dados = new ArrayList<>();
    private String[] colunas = {"Prazo","Data","CPF", "Nome", "Idencod"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getPrazo();
            case 1:
                return dados.get(linha).getData();
            case 2: 
                return dados.get(linha).getCpf();
            case 3:
            	return dados.get(linha).getNome();
            case 4:
            	return dados.get(linha).getIdentcod();
        }
        
        return null;
        
    }
    
    public void addRow(Emprestimo p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    
}