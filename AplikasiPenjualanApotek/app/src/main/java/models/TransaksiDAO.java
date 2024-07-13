/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Transaksi;
import java.util.List;

/**
 *
 * @author galih
 */
public interface TransaksiDAO {
    void insert(Transaksi transaksi);
    List<Transaksi> selectAll();
    void delete(String idtrans);
    Transaksi selectbyidtrans(String idtrans);

}
