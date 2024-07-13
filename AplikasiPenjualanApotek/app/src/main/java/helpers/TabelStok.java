/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import entities.Stok;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author galih
 */
public class TabelStok extends AbstractTableModel{

    List<Stok> dataStok;
    String[] header = {"ID Obat", "Jumlah Stok", "Obat"};

    public TabelStok(List<Stok> dataStok) {
        this.dataStok = dataStok;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataStok.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dataStok.get(rowIndex).idstok;
            case 1:
                return dataStok.get(rowIndex).jml;
            default:
                return dataStok.get(rowIndex).kodeObat;
        }
    }
    
}
