/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galih
 */
public class Obat {
    public String kode;
    public String nama;
    public int harga;
    public List<Stok> stokObat;
    
    public Obat(String kode, String nama, int harga, List<Stok> dataObat){
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stokObat = dataObat;
    }
    
    public Obat(String kode, String nama, int harga){
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stokObat = new ArrayList<>();   
    }
    
    @Override
    public String toString(){
        return"["+kode+"] "+nama;
    }
    
    public int toHarga(){
        return harga;
    }
}
