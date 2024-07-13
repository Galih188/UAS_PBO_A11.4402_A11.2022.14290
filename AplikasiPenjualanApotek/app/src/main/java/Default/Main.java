/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Default;

import GUI.MainPage;
import helpers.SetupDB;

/**
 *
 * @author galih
 */
public class Main {
    public static void main(String[] args) {
        SetupDB.createTable();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}
