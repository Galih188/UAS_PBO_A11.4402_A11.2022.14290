/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Obat;
import entities.Stok;
import helpers.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galih
 */
public class ModelStok implements StokDAO{

    @Override
    public void insert(Stok stok) {
        String sql = "INSERT INTO stok (idStok, jmlStok) VALUES (?, ?)";
        
        if(stok.kodeObat != null){
            sql = "INSERT INTO stok (idStok, jmlStok, kodeObat) VALUES (?, ?, ?)";
        }
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, stok.idstok);
            pstmt.setInt(2, stok.jml);
            if(stok.kodeObat != null){
                pstmt.setString(3, stok.kodeObat.kode);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Stok selectByStok(String jml) {
        String sql = """
                     SELECT jmlStok, stok.idStok AS idStok,
                     obat.kode, obat.nama AS namaObat, obat.harga
                     FROM stok  
                     LEFT JOIN obat ON (obat.kode = stok.kodeObat)
                     WHERE jmlStok = ?
                     """;
        Stok stok = null;
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, stok.jml);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                stok = new Stok(
                rs.getString("jmlStok"),
                rs.getInt("idStok"));
                
                String kode_obat = rs.getString("kode");
                String nama_obat = rs.getString("namaObat");
                int harga = rs.getInt("harga");
                if(kode_obat != null){
                    stok.kodeObat = new Obat(kode_obat, nama_obat, harga);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stok;
    }

    @Override
    public List<Stok> selectAll() {
        String sql = """
                     SELECT idStok, stok.jmlStok AS jmlStok,
                     obat.kode, obat.nama AS namaObat, obat.harga
                     FROM stok  
                     LEFT JOIN obat ON (obat.kode = stok.kodeObat)
                     """;
        List<Stok> dataStok = new ArrayList<>();
        
        try(Connection conn = KoneksiDB.connect();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Stok stok  = new Stok(
                rs.getString("idStok"),
                rs.getInt("jmlStok"));
                
                String kode_obat = rs.getString("kode");
                String nama_obat = rs.getString("namaObat");
                int harga = rs.getInt("harga");
                if(kode_obat != null){
                    stok.kodeObat = new Obat(kode_obat, nama_obat, harga);
                }
                dataStok.add(stok);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataStok;
    }

    @Override
    public void update(Stok stok) {
        String sql = "UPDATE stok SET jmlStok = ? ";
        if(stok.kodeObat != null){
            sql += ", kodeObat = ? ";
        }
        sql += "WHERE idStok = ?";
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, stok.jml);
            pstmt.setString(2, stok.idstok);
            if(stok.kodeObat != null){
                pstmt.setString(2, stok.kodeObat.kode);
                pstmt.setString(3, stok.idstok);
            } else {
                pstmt.setString(3, stok.idstok);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM stok WHERE idStok = ?";
        
        try(Connection conn = KoneksiDB.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void kurang(Stok stok, int jml) {
        String sql = "UPDATE stok SET jml = jml -? where idStok = ?  ";

        try (Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jml);
            pstmt.setString(2, stok.idstok);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
