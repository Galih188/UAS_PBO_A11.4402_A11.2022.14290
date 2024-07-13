/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import entities.Obat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author galih
 */
public class TabelObat extends AbstractTableModel{

    List<Obat> dataObat;

    String[] header = {"Kode Obat", "Nama Obat", "Harga"};
    
    public TabelObat(List<Obat> dataObat) {
        this.dataObat = dataObat;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataObat.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dataObat.get(rowIndex).kode;
            case 1:
                return dataObat.get(rowIndex).nama;
            default:
                return dataObat.get(rowIndex).harga;
        }
    }
    
}
