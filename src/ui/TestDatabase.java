/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.sql.ResultSet;
import helpers.JdbcHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.ChuyenDe;

/**
 *
 * @author Admin
 */
public class TestDatabase extends javax.swing.JFrame {
    public List<ChuyenDe> lChuyende = new ArrayList<ChuyenDe>();
    public DefaultTableModel modelKhoahoc ;
    public DefaultTableModel modelHocvien ;
    /**
     * Creates new form TestDatabase
     */
    public TestDatabase() {
        initComponents();
        
        String[] KhoahocName = { "MaKH","Hoc phí","Thoi luong","Ngày KG" };
        modelKhoahoc = (DefaultTableModel)tblKhoaHoc.getModel();
        modelKhoahoc.setColumnIdentifiers(KhoahocName);
        
        String[] HocviencName = { "MaHV","MaNH","Diem" };
        modelHocvien = (DefaultTableModel)tblHocvien.getModel();
        modelHocvien.setColumnIdentifiers(HocviencName);
        
        loadChuyendeToCombobox();
        this.setLocationRelativeTo(null);
    }

    public final void loadChuyendeToCombobox() {
        try {
            cboChuyende.removeAllItems();
            ResultSet rs = JdbcHelper.executeQuery("select * from chuyende");
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe(
                        rs.getString("MaCD"),
                        rs.getString("TenCD"),
                        rs.getDouble("Hocphi"),
                        rs.getInt("ThoiLuong"),
                        rs.getString("hinh"),
                        rs.getString("mota")
                );
                lChuyende.add(cd);
                cboChuyende.addItem(cd.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadKhoahocByChuyende(String macd) {
        try {
            modelKhoahoc.setRowCount(0);
            String sql = "select makh,hocphi,thoiluong,ngaykg from khoahoc where macd = ?";
            ResultSet rs = JdbcHelper.executeQuery(sql,macd);
            while (rs.next()) {
                modelKhoahoc.addRow(new Object[] {
                    rs.getString("makh"),
                    rs.getDouble("hocphi"),
                    rs.getInt("thoiluong"),
                    rs.getDate("ngaykg")
                });
            }
            modelHocvien.setRowCount(0);
        } catch (SQLException ex) {
            Logger.getLogger(TestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    public void loadHocvienByKhoahoc(int makh) {
        try {
            modelHocvien.setRowCount(0);
            String sql = "select mahv,manh,diem from hocvien where makh = ?";
            ResultSet rs = JdbcHelper.executeQuery(sql,makh);
            while (rs.next()) {
                modelHocvien.addRow(new Object[] {
                    rs.getString("mahv"),
                    rs.getString("manh"),
                    rs.getDouble("diem")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboChuyende = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHocvien = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chuyên đề :");

        cboChuyende.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboChuyende.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChuyendeActionPerformed(evt);
            }
        });

        tblKhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhoaHocMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoaHoc);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Khóa hoc");

        tblHocvien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblHocvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHocvien);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Hoc vien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboChuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addGap(130, 130, 130))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboChuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChuyendeActionPerformed
        int index = cboChuyende.getSelectedIndex();
        if (index>=0) {
            String macd = lChuyende.get(index).getMaCD();
            loadKhoahocByChuyende(macd);
        }
    }//GEN-LAST:event_cboChuyendeActionPerformed

    private void tblKhoaHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMousePressed
        int index = tblKhoaHoc.getSelectedRow();
        if (index>=0) {
            Integer makh = Integer.parseInt((String)modelKhoahoc.getValueAt(index,0));
            loadHocvienByKhoahoc(makh);
        }
    }//GEN-LAST:event_tblKhoaHocMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDatabase().setVisible(true)    ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboChuyende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHocvien;
    private javax.swing.JTable tblKhoaHoc;
    // End of variables declaration//GEN-END:variables
}
