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
public class ModelObat implements ObatDAO{
    
    @Override
    public void insert(Obat obat) {
        String sql = "INSERT INTO obat(kode, nama, harga) VALUES(?, ?, ?)";
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, obat.kode);
            pstmt.setString(2, obat.nama);
            pstmt.setInt(3, obat.harga);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Obat selectByKode(String kode) {
        String sql = "SELECT kode, nama, harga FROM obat WHERE kode = ?";
        Obat obat = null;
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, obat.kode);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                obat = new Obat(
                rs.getString("kode"),
                rs.getString("nama"),
                rs.getInt("harga"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obat;
    }

    @Override
    public List<Obat> selectAll() {
        String sql = "SELECT kode, nama, harga FROM obat";
        List<Obat> dataObat = new ArrayList<>();
        
        try(Connection conn = KoneksiDB.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Obat obat = new Obat(
                rs.getString("kode"),
                rs.getString("nama"),
                rs.getInt("harga"));
                dataObat.add(obat);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataObat;
    }    
        
    @Override
    public void update(Obat obat) {
        String sql = "UPDATE obat SET nama = ?, harga = ? WHERE kode = ?";
        
        try(Connection conn = KoneksiDB.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, obat.nama);
            pstmt.setString(2, obat.kode);
            pstmt.setInt(3, obat.harga);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String kode) {
        String sql = "DELETE FROM obat WHERE kode = ?";
        
        try(Connection conn = KoneksiDB.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, kode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Stok> getDataObat(Obat obat) {
        String sql = """
                     SELECT s.idStok, s.jmlStok, o.kode, o.nama, o.harga 
                     FROM stok s, obat o
                     WHERE o.kode = ?
                     """;
        List<Stok> stokKodeObat =  new ArrayList<>();
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, obat.kode);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Stok stok = new Stok(
                rs.getString("idStok"),
                rs.getInt("jmlStok"));
                stokKodeObat.add(stok);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stokKodeObat;
    }

    @Override
    public List<Obat> selectByObat(String kode, String nama) {
        String sql = "SELECT * FROM obat WHERE kode = ? AND nama = ?";
        List<Obat> dataObat = new ArrayList<>();
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Obat obat = new Obat(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getInt("harga"));
                dataObat.add(obat);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataObat;
    }
}
