/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Obat;
import entities.Stok;
import entities.Transaksi;
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
public class ModelTransaksi implements TransaksiDAO{

    private String idstok;

    @Override
    public void insert(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi(idTrans, idStok, nama, jmlTrans, total) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, transaksi.idtrans);
            pstmt.setString(2, transaksi.idstok.idstok);
            pstmt.setString(3, transaksi.nama);
            pstmt.setInt(4, transaksi.jmltrans);
            pstmt.setInt(5, transaksi.total);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Transaksi> selectAll() {
        String sql = """
                     SELECT idTrans, s.idStok, o.kode AS kodeObat, nama, jmlTrans, total, harga
                     FROM stok s, transaksi t, obat o
                     WHERE s.idStok = t.idTrans AND t.idTrans = o.kodeObat
                     """;
        List<Transaksi> dataTrans = new ArrayList<>();
        
        try(Connection conn = KoneksiDB.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Transaksi transaksi = new Transaksi(
                    rs.getString("idTrans"),
                    rs.getString("nama"),
                    rs.getInt("jmlTrans"),
                    rs.getInt("total")
                );
                String idtrans = rs.getString("idTrans");
                String kodeObat = rs.getString("kodeObat");
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                if (idtrans != null && kodeObat != null) {
                    transaksi.kodeObat = new Obat(kodeObat, nama, harga);
                    transaksi.idstok = new Stok(idstok, 0);
                }
                dataTrans.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataTrans;
    }

    @Override
    public void delete(String idtrans) {
        String sql = "DELETE FROM transaksi WHERE idTrans = ?";
        
        try(Connection conn = KoneksiDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, idtrans);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Transaksi selectbyidtrans(String idtrans) {
        String sql = """
                     SELECT idTrans, jmlTrans
                     FROM transaksi
                     WHERE idTrans = ?
                     """;
        Transaksi transaksi =  null;
        
        try(Connection conn = KoneksiDB.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, idtrans);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                transaksi = new Transaksi(
                    rs.getString("idTrans"),
                    rs.getInt("jmlTrans")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transaksi;
    }
    
}
