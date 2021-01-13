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
public class Pendataansumbangan extends javax.swing.JFrame {
 private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
private JasperReport jasperReport;
private JasperPrint jasperPrint;
private final Map<String, Object> param = new HashMap<>();
private JasperDesign jasperDesign;
    /**
     * Creates new form Pendataansumbangan
     */
    public Pendataansumbangan() {
        initComponents();
         datatable();
        setVisible(true);
        setEditStatus(false);
        id_auto();
    }

    protected void aktif(){
         
        tno.setEnabled(true);
        tnama.setEnabled(true);        
        cjk.setEnabled(true);
        tsumbangan.setEnabled(true);
        tjumlah.setEnabled(true);
        thari.setEnabled(true);
        ttanggal.setEnabled(true);
        talamat.setEnabled(true);
        tnosumbang.requestFocus();
     }
     
      protected void kosong(){
          
          tnosumbang.setText("");
        tno.setText("");
        tnama.setText("");
        cjk.setSelectedItem("-Pilih-");
        tsumbangan.setText("");
        tjumlah.setText("");
        thari.setText("");
        ttanggal.setDate(null);
        talamat.setText("");
      }
      
      protected void datatable(){
        Object[] Baris ={"NO SUMBANG","ID WARGA","NAMA","JENIS KELAMIN","SUMBANGAN","JUMLAH","HARI","TANGGAL","ALAMAT","ID PETUGAS","NAMA PETUGAS"};
        tabmode = new DefaultTableModel (null, Baris);
        ttable.setModel(tabmode);
        String sql ="select * from datasumbangan";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                 String nosumbang = hasil.getString("nosumbang");
                String idwarga = hasil.getString("idwarga");
                String namapenyumbang = hasil.getString("namapenyumbang");
                String jeniskelamin = hasil.getString("jeniskelamin");
                String sumbangan = hasil.getString("sumbangan");
                String jumlah = hasil.getString("jumlah");
                String hari = hasil.getString("hari");
                String tanggal = hasil.getString("tanggal"); 
                String alamat = hasil.getString("alamat");
                String idpetugas = hasil.getString("idpetugas"); 
                String namapetugas = hasil.getString("namapetugas");
                
                
                
                String[] data={nosumbang,idwarga,namapenyumbang,jeniskelamin,sumbangan,jumlah,hari,tanggal,alamat,idpetugas,namapetugas};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }}
      
      
      protected void datatable1(){
        Object[] Baris ={"ID","NAMA","TEMPAT LAHIR","TANGGAL LAHIR","JENIS KELAMIN","ALAMAT"};
        tabmode = new DefaultTableModel (null, Baris);
        tviewwarga.setModel(tabmode);
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
      
       protected void datatable2(){
        Object[] Baris ={"ID","NAMA","JENIS KELAMIN","TEMPAT LAHIR","TANGGAL LAHIR","ALAMAT"};
        tabmode = new DefaultTableModel (null, Baris);
        tviewpetugas.setModel(tabmode);
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
        String sql = "SELECT MAX(right(nosumbang,2)) Asno FROM datasumbangan";
        java.sql.Statement stat= conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            if (rs.first()==false){
                tnosumbang.setText("0");
            }else{
            rs.last();
            int auto_id = rs.getInt(1)+1;
            String no = String.valueOf(auto_id);
            int noLong = no.length();
            for (int a = 0; a<3-noLong; a++){
                no = "0" +no;
               
            }
             tnosumbang.setText("0" +no);
            }
        } 
    }catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error :\n" + e.toString(),"kesalahan",JOptionPane.WARNING_MESSAGE);
}
    }
      
       private void BersihkanSemuaField() {
           tno.setText("");
        tnama.setText("");
        cjk.setSelectedItem("-Pilih-");
        tsumbangan.setText("");
        tjumlah.setText("");
        thari.setText("");
        ttanggal.setDate(null);
        talamat.setText("");
        tidpetugas.setText("");
        tnamapetugas.setText("");
      }
       
       private void setEditStatus(boolean status) {
        if (status == false) {
            bsimpan.setEnabled(false);
            btambah.setEnabled(true);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(false);
            bcetak.setEnabled(true);
            tnosumbang.setEnabled(true);
            tno.setEnabled(true);
            tnama.setEnabled(false);
        cjk.setEnabled(false);
        tsumbangan.setEnabled(false);
        tjumlah.setEnabled(false);
        thari.setEnabled(false);
        ttanggal.setEnabled(false);
        talamat.setEnabled(false);
        tidpetugas.setEnabled(false);
        tnamapetugas.setEnabled(false);
        bcariwarga.setEnabled(false);
        bcaripetugas.setEnabled(false);
        
        } else {
            
            bsimpan.setEnabled(true);
            btambah.setEnabled(false);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(true);
            bcetak.setEnabled(true);
            tnosumbang.setEnabled(true);
            tno.setEnabled(true);
            tnama.setEnabled(true);
        cjk.setEnabled(true);
        tsumbangan.setEnabled(true);
        tjumlah.setEnabled(true);
        thari.setEnabled(true);
        ttanggal.setEnabled(true);
        talamat.setEnabled(true);
        tidpetugas.setEnabled(true);
        tnamapetugas.setEnabled(true);
        bcariwarga.setEnabled(true);
        bcaripetugas.setEnabled(true);
        }
       }
       
         void cetak_nota(){
         
              
              try {
                  param.put("notsumb",tnosumbang.getText());
        File file = new File("src/tampilan/notasumbangan.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
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

        jDialog1 = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tviewpetugas = new javax.swing.JTable();
        jDialog2 = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tviewwarga = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tsumbangan = new javax.swing.JTextField();
        tjumlah = new javax.swing.JTextField();
        thari = new javax.swing.JTextField();
        cjk = new javax.swing.JComboBox<>();
        ttanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tidpetugas = new javax.swing.JTextField();
        tnamapetugas = new javax.swing.JTextField();
        bcaripetugas = new javax.swing.JButton();
        bcariwarga = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tnosumbang = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ttable = new javax.swing.JTable();
        bbersih = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bcetak = new javax.swing.JButton();
        bcetak1 = new javax.swing.JButton();
        tgl1 = new com.toedter.calendar.JDateChooser();
        tgl2 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(472, 401));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/petugas.png"))); // NOI18N
        jLabel12.setText("DATA PETUGAS");

        tviewpetugas.setModel(new javax.swing.table.DefaultTableModel(
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
        tviewpetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tviewpetugasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tviewpetugas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(426, 336));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/warga.png"))); // NOI18N
        jLabel13.setText("DATA WARGA");

        tviewwarga.setModel(new javax.swing.table.DefaultTableModel(
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
        tviewwarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tviewwargaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tviewwarga);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/sumbangan.png"))); // NOI18N
        jLabel1.setText("DATA SUMBANGAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(892, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID WARGA :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("JENIS KELAMIN:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("SUMBANGAN :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("JUMLAH :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("HARI :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("TANGGAL :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ALAMAT :");

        tno.setEditable(false);

        cjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIA", "WANITA" }));

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane1.setViewportView(talamat);

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("ID PETUGAS :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("NAMA :");

        bcaripetugas.setText("...");
        bcaripetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripetugasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcaripetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaripetugas))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        bcariwarga.setText("...");
        bcariwarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariwargaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("No :");

        tnosumbang.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(thari)
                                    .addComponent(tjumlah)
                                    .addComponent(tsumbangan)
                                    .addComponent(tnama)
                                    .addComponent(tno)
                                    .addComponent(cjk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(bcariwarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(128, 128, 128)
                        .addComponent(tnosumbang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tnosumbang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcariwarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tsumbangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(thari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/add.png"))); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
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

        bsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
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

        bcetak1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bcetak1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/print.png"))); // NOI18N
        bcetak1.setText("Cetak");
        bcetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak1ActionPerformed(evt);
            }
        });

        jLabel14.setText("s/d");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btambah)
                        .addGap(18, 18, 18)
                        .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcetak))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bcetak1)
                        .addGap(198, 198, 198))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(bbersih)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bcetak))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(bcetak1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
         setEditStatus(true);
        BersihkanSemuaField();
        
    }//GEN-LAST:event_btambahActionPerformed

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        setEditStatus(false);
         id_auto() ;
        BersihkanSemuaField();
        
    }//GEN-LAST:event_bbersihActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
         String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgll = String.valueOf(fm.format(ttanggal.getDate()));

        String sql ="insert into datasumbangan values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString (1, tnosumbang.getText());
            stat.setString (2, tno.getText());
            stat.setString (3, tnama.getText());
            stat.setString (4, (String) cjk.getSelectedItem());
            stat.setString (5, tsumbangan.getText());
            stat.setString (6, tjumlah.getText());
            stat.setString (7, thari.getText());
            stat.setString (8, tgll);
            stat.setString (9, talamat.getText());
            stat.setString (10, tidpetugas.getText());
            stat.setString (11, tnamapetugas.getText());

            stat.executeUpdate();
            int pesan =JOptionPane.showConfirmDialog(null, "Cetak Bukti Sumbangan", "Cetak",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION) {
            cetak_nota();
        }
            kosong();
//            tnosumbang.requestFocus();
            datatable();
             id_auto() ;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);

        }
        

    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgll = String.valueOf(fm.format(ttanggal.getDate()));

        try {

            String sql ="update datasumbangan set nosumbang=?,idwarga=?,namapenyumbang=?,jeniskelamin=?,sumbangan=?,jumlah=?,hari=?,tanggal=?,alamat=?,idpetugas=?,namapetugas=? where nosumbang ='"+tnosumbang.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
stat.setString (1, tnosumbang.getText());
stat.setString (2, tno.getText());
            stat.setString (3, tnama.getText());
            stat.setString (4, (String) cjk.getSelectedItem());
            stat.setString (5, tsumbangan.getText());
            stat.setString (6, tjumlah.getText());
            stat.setString (7, thari.getText());
            stat.setString (8, tgll);
            stat.setString (9, talamat.getText());
               stat.setString (10, tidpetugas.getText());
            stat.setString (11, tnamapetugas.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            kosong();
            tnosumbang.requestFocus();
            datatable();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah"+e);

        }
        

    }//GEN-LAST:event_bubahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Delete","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql ="delete from datasumbangan where nosumbang ='"+tnosumbang.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                tnosumbang.requestFocus();
                datatable();
                 id_auto() ;
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
       
    }//GEN-LAST:event_bhapusActionPerformed

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
        String g= tabmode.getValueAt(bar, 6).toString();
        String h= tabmode.getValueAt(bar, 7).toString();
        String i= tabmode.getValueAt(bar, 8).toString();
        String j= tabmode.getValueAt(bar, 9).toString();
         String k= tabmode.getValueAt(bar, 10).toString();

 tnosumbang.setText(a);
        tno.setText(b);
        tnama.setText(c);
        cjk.setSelectedItem(d);
        tsumbangan.setText(e);
        tjumlah.setText(f);
        thari.setText(g);

        try{
            DefaultTableModel tabmode = (DefaultTableModel)ttable.getModel();
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(bar,7));
            ttanggal.setDate(date);} catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Pendataansumbangan.class.getName()).log(Level.SEVERE, null, ex);
        }

        talamat.setText(i);
        tidpetugas.setText(j);
        tnamapetugas.setText(k);

                          
    }//GEN-LAST:event_ttableMouseClicked

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        // TODO add your handling code here:
        try {
        File file = new File("src/tampilan/lapsumbangan.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }      
    }//GEN-LAST:event_bcetakActionPerformed

    private void bcariwargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariwargaActionPerformed
        // TODO add your handling code here:
         jDialog2.setLocationRelativeTo(null);
        datatable1 ();
        jDialog2.setVisible(true);
    }//GEN-LAST:event_bcariwargaActionPerformed

    private void bcaripetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripetugasActionPerformed
        // TODO add your handling code here:
         jDialog1.setLocationRelativeTo(null);
        datatable2 ();
        jDialog1.setVisible(true);
    }//GEN-LAST:event_bcaripetugasActionPerformed

    private void tviewwargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tviewwargaMouseClicked
        // TODO add your handling code here:
        int bar= tviewwarga.getSelectedRow();
        String a= tabmode.getValueAt (bar, 0).toString();
        tno.setText(a);
    }//GEN-LAST:event_tviewwargaMouseClicked

    private void tviewpetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tviewpetugasMouseClicked
        // TODO add your handling code here:
        int bar = tviewpetugas.getSelectedRow();
        String a= tabmode.getValueAt(bar, 0).toString();
        String b= tabmode.getValueAt(bar, 1).toString();
        tidpetugas.setText(a);
        tnamapetugas.setText(b);
    }//GEN-LAST:event_tviewpetugasMouseClicked

    private void bcetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak1ActionPerformed
        // TODO add your handling code here:
         try {
        param.put("tgl",tgl1.getDate());
        param.put("tgll",tgl2.getDate());
        File file = new File("src/tampilan/lapsumbangan1.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bcetak1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pendataansumbangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pendataansumbangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pendataansumbangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pendataansumbangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pendataansumbangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bcaripetugas;
    private javax.swing.JButton bcariwarga;
    private javax.swing.JButton bcetak;
    private javax.swing.JButton bcetak1;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cjk;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea talamat;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    private javax.swing.JTextField thari;
    private javax.swing.JTextField tidpetugas;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnamapetugas;
    private javax.swing.JTextField tno;
    private javax.swing.JTextField tnosumbang;
    private javax.swing.JTextField tsumbangan;
    private javax.swing.JTable ttable;
    private com.toedter.calendar.JDateChooser ttanggal;
    private javax.swing.JTable tviewpetugas;
    private javax.swing.JTable tviewwarga;
    // End of variables declaration//GEN-END:variables
}
