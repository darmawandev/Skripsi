/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Drmwn
 */
public class Pendataanpetugas extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
private JasperReport jasperReport;
private JasperPrint jasperPrint;
private final Map<String, Object> param = new HashMap<>();
private JasperDesign jasperDesign;

    /**
     * Creates new form Pendataanpetugas
     */
    public Pendataanpetugas() {
        initComponents();
        setVisible(true);
        setEditStatus(false);
        datatable();
         id_auto();
    }
    
     protected void aktif(){
        tnama.setEnabled(true);  
         cjk.setEnabled(true);
        ttempat.setEnabled(true);
        ttanggal.setEnabled(true);
       
        talamat.setEnabled(true);
        tid.requestFocus();
     }
     
      protected void kosong(){
        tid.setText("");
        tnama.setText("");
        cjk.setSelectedItem("-Pilih-");
        ttempat.setText("");
        ttanggal.setDate(null);
        
        talamat.setText("");
      }

      protected void datatable(){
        Object[] Baris ={"ID","NAMA","JENIS KELAMIN","TEMPAT LAHIR","TANGGAL LAHIR","ALAMAT"};
        tabmode = new DefaultTableModel (null, Baris);
        ttable.setModel(tabmode);
        String sql ="select * from datapetugas";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idpetugas = hasil.getString("idpetugas");
                String namapetugas = hasil.getString("namapetugas");
                String jeniskelamin = hasil.getString("jeniskelamin");
                String tempatlahir = hasil.getString("tempatlahir");
                String tanggallahir = hasil.getString("tanggallahir");
                
                String alamat = hasil.getString("alamat");
                
                
                
                String[] data={idpetugas,namapetugas,jeniskelamin,tempatlahir,tanggallahir,alamat};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }}
      
      private void id_auto(){
    try {
        String sql = "SELECT MAX(right(idpetugas,2)) Asno FROM datapetugas";
        java.sql.Statement stat= conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            if (rs.first()==false){
                tid.setText("IDP01");
            }else{
            rs.last();
            int auto_id = rs.getInt(1)+1;
            String no = String.valueOf(auto_id);
            int noLong = no.length();
            for (int a = 0; a<3-noLong; a++){
                no = "0" +no;
               
            }
             tid.setText("IDP" +no);
            }
        } 
    }catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error :\n" + e.toString(),"kesalahan",JOptionPane.WARNING_MESSAGE);
}
      }
      private void BersihkanSemuaField() {
        tnama.setText("");
        cjk.setSelectedItem("PRIA");
        ttempat.setText("");
        ttanggal.setDate(null);
        
        talamat.setText("");
      }
      
       private void setEditStatus(boolean status) {
        if (status == false) {
            bsimpan.setEnabled(false);
            btambah.setEnabled(true);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(false);
            bcetak.setEnabled(true);
            tid.setEnabled(true);
            tnama.setEnabled(false);
            cjk.setEnabled(false);
            ttempat.setEnabled(false);
            ttanggal.setEnabled(false);
            
            talamat.setEnabled(false);
            
            } else {
            
            bsimpan.setEnabled(true);
            btambah.setEnabled(false);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(true);
            bcetak.setEnabled(true);
            tid.setEnabled(true);
            tnama.setEnabled(true);
            cjk.setEnabled(true);
            ttempat.setEnabled(true);
            ttanggal.setEnabled(true);
            
            talamat.setEnabled(true);
        }
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        ttempat = new javax.swing.JTextField();
        cjk = new javax.swing.JComboBox<>();
        ttanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ttable = new javax.swing.JTable();
        btambah = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bcetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/petugas.png"))); // NOI18N
        jLabel1.setText("DATA PETUGAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(1052, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TANGGAL LAHIR :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("JENIS KELAMIN :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TEMPAT LAHIR :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ALAMAT :");

        tid.setEditable(false);

        cjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIA", "WANITA" }));

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane1.setViewportView(talamat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cjk, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tid, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(tnama, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ttempat)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ttempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ttable.setModel(new javax.swing.table.DefaultTableModel(
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
        ttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ttableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ttable);

        btambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/add.png"))); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bbersih.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bbersih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        bbersih.setText("Bersih");
        bbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihActionPerformed(evt);
            }
        });

        bsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bubah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/delete.png"))); // NOI18N
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bcetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bcetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/print.png"))); // NOI18N
        bcetak.setText("Cetak");
        bcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bbersih)
                        .addGap(18, 18, 18)
                        .addComponent(bsimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcetak))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(bbersih)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bcetak))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        setEditStatus(true);
        BersihkanSemuaField();
        
    }//GEN-LAST:event_btambahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
         String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgll = String.valueOf(fm.format(ttanggal.getDate()));

        String sql ="insert into datapetugas values (?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString (1, tid.getText());
            stat.setString (2, tnama.getText());
            stat.setString (3, (String) cjk.getSelectedItem());
            stat.setString (4, ttempat.getText());
            stat.setString (5, tgll);
            
            stat.setString (6, talamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
            tid.requestFocus();
            datatable();
             id_auto();
            
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);

        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        setEditStatus(false);
         id_auto();
        BersihkanSemuaField();
    }//GEN-LAST:event_bbersihActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Delete","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql ="delete from datapetugas where idpetugas ='"+tid.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                tid.requestFocus();
                datatable();
                 id_auto();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl = String.valueOf(fm.format(ttanggal.getDate()));

        try {

            String sql ="update datapetugas set namapetugas=?,jeniskelamin=?,tempatlahir=?,tanggallahir=?,alamat=? where idpetugas ='"+tid.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString (1, tnama.getText());
             stat.setString (2, (String) cjk.getSelectedItem());
            stat.setString (3, ttempat.getText());
            stat.setString (4, tgl);
           
            stat.setString (5, talamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            kosong();
            tid.requestFocus();
            datatable();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah"+e);

        }
    }//GEN-LAST:event_bubahActionPerformed

    private void ttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ttableMouseClicked
        // TODO add your handling code here:
        setEditStatus(true);
        bsimpan.setEnabled(false);
        bhapus.setEnabled(true);
        bubah.setEnabled(true);
        int bar = ttable.getSelectedRow();
        String a= tabmode.getValueAt(bar, 0).toString();
        String b= tabmode.getValueAt(bar, 1).toString();
        String c= tabmode.getValueAt(bar, 2).toString();
        String d= tabmode.getValueAt(bar, 3).toString();
        String e= tabmode.getValueAt(bar, 4).toString();
        String f= tabmode.getValueAt(bar, 5).toString();

        tid.setText(a);
        tnama.setText(b);
          cjk.setSelectedItem(c);
        ttempat.setText(d);

        try{
            DefaultTableModel tabmode = (DefaultTableModel)ttable.getModel();
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(bar,4));
            ttanggal.setDate(date);} catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(Level.SEVERE, null, ex);
        }

      

        talamat.setText(f);
    }//GEN-LAST:event_ttableMouseClicked

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        // TODO add your handling code here:
         try {
        File file = new File("src/tampilan/lappetugas.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }      
    }//GEN-LAST:event_bcetakActionPerformed

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
            java.util.logging.Logger.getLogger(Pendataanpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pendataanpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pendataanpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pendataanpetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pendataanpetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bcetak;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cjk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTable ttable;
    private com.toedter.calendar.JDateChooser ttanggal;
    private javax.swing.JTextField ttempat;
    // End of variables declaration//GEN-END:variables
}
