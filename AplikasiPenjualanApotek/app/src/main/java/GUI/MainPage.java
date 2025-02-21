/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.CardLayout;

/**
 *
 * @author galih
 */
public class MainPage extends javax.swing.JFrame {

    PanelObat panelObat;
    PanelStok panelStok;
    PanelTransaksi panelTrans;
    
    CardLayout layout;
    
    
    /**
     * Creates new form TabelObat
     */
    public MainPage() {
        initComponents();
        layout = (CardLayout) mainPanel.getLayout();
        
        btnMjObat.setEnabled(false);
        
        panelObat = new PanelObat();
        panelStok = new PanelStok();
        panelTrans = new PanelTransaksi();
        
        mainPanel.add("obat", panelObat);
        mainPanel.add("stok", panelStok);
        mainPanel.add("transaksi", panelTrans);        
        
        layout.show(mainPanel, "obat");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barPanel = new javax.swing.JPanel();
        btnMjObat = new javax.swing.JButton();
        btnMjStok = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 450));
        setSize(new java.awt.Dimension(0, 0));

        mainPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Aplikasi Penjualan Apotek");

        barPanel.setBackground(new java.awt.Color(204, 204, 204));

        btnMjObat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMjObat.setText("Manajemen Obat");
        btnMjObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMjObatMouseClicked(evt);
            }
        });
        btnMjObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMjObatActionPerformed(evt);
            }
        });

        btnMjStok.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMjStok.setText("Manajemen Stok");
        btnMjStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMjStokMouseClicked(evt);
            }
        });
        btnMjStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMjStokActionPerformed(evt);
            }
        });

        btnTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barPanelLayout = new javax.swing.GroupLayout(barPanel);
        barPanel.setLayout(barPanelLayout);
        barPanelLayout.setHorizontalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMjObat)
                    .addGroup(barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMjStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        barPanelLayout.setVerticalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnMjObat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnMjStok, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMjObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMjObatActionPerformed
        layout.show(mainPanel, "obat");
        panelObat.refreshData();
    }//GEN-LAST:event_btnMjObatActionPerformed

    private void btnMjStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMjStokActionPerformed
        layout.show(mainPanel, "stok");
        panelStok.refreshData();
    }//GEN-LAST:event_btnMjStokActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        layout.show(mainPanel, "transaksi");
        panelTrans.refreshData();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnMjObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMjObatMouseClicked
        if(evt.getClickCount() == 1){
            btnMjObat.setEnabled(false);
            btnMjStok.setEnabled(true);
            btnTransaksi.setEnabled(true);
        }
    }//GEN-LAST:event_btnMjObatMouseClicked

    private void btnMjStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMjStokMouseClicked
        if(evt.getClickCount() == 1){
            btnMjStok.setEnabled(false);
            btnMjObat.setEnabled(true);
            btnTransaksi.setEnabled(true);
        }
    }//GEN-LAST:event_btnMjStokMouseClicked

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        if(evt.getClickCount() == 1){
            btnTransaksi.setEnabled(false);
            btnMjObat.setEnabled(true);
            btnMjStok.setEnabled(true);
        }
    }//GEN-LAST:event_btnTransaksiMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barPanel;
    private javax.swing.JButton btnMjObat;
    private javax.swing.JButton btnMjStok;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
