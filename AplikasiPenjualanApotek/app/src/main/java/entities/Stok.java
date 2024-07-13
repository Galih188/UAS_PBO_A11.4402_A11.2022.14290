/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author galih
 */
public class Stok {
    public String idstok;
    public int jml;
    int harga;
    public Obat kodeObat;
    
    public Stok(String idstok, int jml){
//    public Stok(int tbStok){
        this.idstok = idstok;
        this.jml = jml;
    }
    
    @Override
    public String toString(){
        if(this.kodeObat == null){
            return "["+idstok+"] ("+jml+" Stok)";
//            return "("+tbStok+" Stok)";
        } else {
            return "["+idstok+"] ("+jml+" Stok) "+kodeObat; 
//            return "("+tbStok+" Stok) "+kodeObat;
        }
    }
}
