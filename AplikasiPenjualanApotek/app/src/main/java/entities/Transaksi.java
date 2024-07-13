/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author galih
 */
public class Transaksi {
    public String idtrans;
    public String nama;
    public int jmltrans;
    public int total;
    public Stok idstok;
    public Obat kodeObat;

    public Transaksi(String idtrans, int jmltrans) {
        this.idtrans = idtrans;
        this.jmltrans = jmltrans;
    }
    
    public Transaksi(String idtrans, String nama, int jmltrans, int total) {
        this.idtrans = idtrans;
        this.nama = nama;
        this.jmltrans = jmltrans;
        this.total = total;
    }
    
    public Transaksi(String idtrans, String nama, int jmltrans, int total, Stok idstok, Obat kodeObat) {
        this.idtrans = idtrans;
        this.nama = nama;
        this.jmltrans = jmltrans;
        this.total = total;
        this.idstok = idstok;
        this.kodeObat = kodeObat;
    }
    
    @Override
    public String toString() {
        return "[" +kodeObat.toString() + "] ["+idstok+"] " + " Nama pemesan : " + nama + " jumlah transaksi : " +jmltrans+" total : "+total;
    }

}
