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
public class Pendataanwarga extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
private JasperReport jasperReport;
private JasperPrint jasperPrint;
private final Map<String, Object> param = new HashMap<>();
private JasperDesign jasperDesign;
    /**
     * Creates new form Pendataanwarga
     */
    public Pendataanwarga() {
        initComponents();
        setVisible(true);
        setEditStatus(false);
        datatable();
        id_auto();
    }
    
     protected void aktif(){
        tnama.setEnabled(true);        
        ttempat.setEnabled(true);
        ttanggal.setEnabled(true);
        cjk.setEnabled(true);
        talamat.setEnabled(true);
        tid.requestFocus();
     }
   
   protected void kosong(){
        tid.setText("");
        tnama.setText("");
        ttempat.setText("");
        ttanggal.setDate(null);
        cjk.setSelectedItem("-Pilih-");
        talamat.setText("");
      }
   
    protected void datatable(){
        Object[] Baris ={"ID","NAMA","TEMPAT LAHIR","TANGGAL LAHIR","JENIS KELAMIN","ALAMAT"};
        tabmode = new DefaultTableModel (null, Baris);
        ttable.setModel(tabmode);
        String sql ="select * from datawarga";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idwarga = hasil.getString("idwarga");
                String namawarga = hasil.getString("namawarga");
                String tempatlahir = hasil.getString("tempatlahir");
                String tanggallahir = hasil.getString("tanggallahir");
                String jeniskelamin = hasil.getString("jeniskelamin");
                String alamat = hasil.getString("alamat");
                
                
                
                String[] data={idwarga,namawarga,tempatlahir,tanggallahir,jeniskelamin,alamat};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }}
    
    private void id_auto(){
    try {
        String sql = "SELECT MAX(right(idwarga,2)) Asno FROM datawarga";
        java.sql.Statement stat= conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            if (rs.first()==false){
                tid.setText("IDW01");
            }else{
            rs.last();
            int auto_id = rs.getInt(1)+1;
            String no = String.valueOf(auto_id);
            int noLong = no.length();
            for (int a = 0; a<3-noLong; a++){
                no = "0" +no;
               
            }
             tid.setText("IDW" +no);
            }
        } 
    }catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error :\n" + e.toString(),"kesalahan",JOptionPane.WARNING_MESSAGE);
}
    }
    
     private void BersihkanSemuaField() {
        tnama.setText("");
        ttempat.setText("");
        ttanggal.setDate(null);
        cjk.setSelectedItem("-Pilih-");
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
            ttempat.setEnabled(false);
            ttanggal.setEnabled(false);
            cjk.setEnabled(false);
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
            ttempat.setEnabled(true);
            ttanggal.setEnabled(true);
            cjk.setEnabled(true);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        ttempat = new javax.swing.JTextField();
        ttanggal = new com.toedter.calendar.JDateChooser();
        cjk = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ttable = new javax.swing.JTable();
        btambah = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bcetak = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/warga.png"))); // NOI18N
        jLabel1.setText("DATA WARGA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(977, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TEMPAT LAHIR :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TANGGAL LAHIR :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("JENIS KELAMIN :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ALAMAT :");

        tid.setEditable(false);

        cjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIA", "WANITA" }));

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane1.setViewportView(talamat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cjk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tid)
                    .addComponent(tnama)
                    .addComponent(ttempat)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(ttempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        bubah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
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

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        jLabel8.setText("*cari berdasarkan nama warga");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btambah)
                .addGap(26, 26, 26)
                .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bcetak, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel8))
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(bbersih)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bcetak))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
          String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgll = String.valueOf(fm.format(ttanggal.getDate()));

        String sql ="insert into datawarga values (?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString (1, tid.getText());
            stat.setString (2, tnama.getText());
            stat.setString (3, ttempat.getText());
            stat.setString (4, tgll);
            stat.setString (5, (String) cjk.getSelectedItem());
            stat.setString (6, talamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
            tid.requestFocus();
            datatable();
            id_auto() ;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);

        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
         setEditStatus(true);
        BersihkanSemuaField();
                 
    }//GEN-LAST:event_btambahActionPerformed

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
            String sql ="delete from datawarga where idwarga ='"+tid.getText()+"'";
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

            String sql ="update datawarga set namawarga=?,tempatlahir=?,tanggallahir=?,jeniskelamin=?,alamat=? where idwarga ='"+tid.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString (1, tnama.getText());
            stat.setString (2, ttempat.getText());
            stat.setString (3, tgl);
            stat.setString (4, (String) cjk.getSelectedItem());
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
        ttempat.setText(c);

        try{
            DefaultTableModel tabmode = (DefaultTableModel)ttable.getModel();
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(bar,3));
            ttanggal.setDate(date);} catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(Level.SEVERE, null, ex);
        }

        cjk.setSelectedItem(e);

        talamat.setText(f);

    }//GEN-LAST:event_ttableMouseClicked

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        // TODO add your handling code here:
        try {
        File file = new File("src/tampilan/lapwarga.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }      
    }//GEN-LAST:event_bcetakActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
        // TODO add your handling code here:
        Object[] Baris ={"idwarga","namawarga","tempatlahir","tanggallahir","jeniskelamin","alamat"};
        tabmode = new DefaultTableModel(null,Baris);
        ttable.setModel(tabmode);
        String sql ="select * from datawarga where namawarga like '%"+tcari.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("idwarga");
                String b = hasil.getString("namawarga");
                String c = hasil.getString("tempatlahir");
                String d = hasil.getString("tanggallahir");
                String e = hasil.getString("jeniskelamin");
                String f = hasil.getString("alamat");
                
                
                
                String [] data = {a,b,c,d,e,f};
                tabmode.addRow(data);
            }
            } catch (Exception e){
                
        }
    }//GEN-LAST:event_tcariKeyReleased

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
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pendataanwarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pendataanwarga().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTable ttable;
    private com.toedter.calendar.JDateChooser ttanggal;
    private javax.swing.JTextField ttempat;
    // End of variables declaration//GEN-END:variables
}
