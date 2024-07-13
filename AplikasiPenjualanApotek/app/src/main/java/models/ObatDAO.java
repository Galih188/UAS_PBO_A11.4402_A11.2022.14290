/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Obat;
import entities.Stok;
import java.util.List;

/**
 *
 * @author galih
 */
public interface ObatDAO {
    void insert(Obat obat);
    Obat selectByKode(String kode);
    List<Obat> selectAll();
    void update(Obat obat);
    void delete(String kode);
    List<Stok> getDataObat(Obat obat);
    List<Obat> selectByObat(String kode, String nama);
}
