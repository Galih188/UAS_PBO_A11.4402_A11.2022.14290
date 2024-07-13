/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author galih
 */
public class SetupDB {
    public static void createTable() {
        String[] sql = { 
                    """
                    CREATE TABLE IF NOT EXISTS obat(
                     kode TEXT PRIMARY KEY,
                     nama TEXT NOT NULL,
                     harga INTEGER NOT NULL
                    );
                    """,
                    """
                    CREATE TABLE IF NOT EXISTS stok(
                     idStok TEXT PRIMARY KEY,
                     jmlStok INTEGER NOT NULL,
                     kodeObat TEXT,
                     FOREIGN KEY (kodeObat) REFERENCES obat(kode)
                    );
                    """,
                    """
                    CREATE TABLE IF NOT EXISTS transaksi(
                     idTrans TEXT PRIMARY KEY,
                     idStok TEXT,
                     kodeObat TEXT,
                     nama TEXT NOT NULL,
                     jmlTrans INTEGER NOT NULL,
                     total INTEGER DEFAULT 0,
                     FOREIGN KEY (kodeObat) REFERENCES obat(kode),
                     FOREIGN KEY (idStok) REFERENCES stok(idStok)                    
                    );
                    """
        };
        
        try (Connection conn = KoneksiDB.connect();
            Statement stmt = conn.createStatement()) {
            for(String query: sql) stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
