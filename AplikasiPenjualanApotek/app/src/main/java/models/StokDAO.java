/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Stok;
import java.util.List;

/**
 *
 * @author galih
 */
public interface StokDAO {
    void insert(Stok stok);
    Stok selectByStok(String idstok);
    List<Stok> selectAll();
    void update(Stok stok);
    void delete(String idstok);
    void kurang(Stok stok, int jml);
}
