/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.io.File;
import java.io.InputStream;
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
public class Pendataankegiatan extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
private JasperReport jasperReport;
private JasperPrint jasperPrint;
private final Map<String, Object> param = new HashMap<>();
private JasperDesign jasperDesign;

    /**
     * Creates new form Pendataankegiatan
     */
    public Pendataankegiatan() {
        initComponents();
        datatable();
        
        
        setVisible(true);
        setEditStatus(false);
         id_auto();
        
         
    }

    protected void aktif(){
        tidp.setEnabled(true);
        tid_.setEnabled(true);        
        tnama_.setEnabled(true);
        talamat_.setEnabled(false);
        tkegiatan.setEnabled(false);
        thari.setEnabled(true);
        ttanggal.setEnabled(true);
        tjamul.setEnabled(true);
        tjamsel.setEnabled(true);
        tketerangan.setEnabled(true);
        tnoo.requestFocus();
     }
    
    protected void kosong(){
       tnoo.setText("");
        tidp.setText("");
        tid_.setText("");
        tnama_.setText("");
        talamat_.setText("");
        tkegiatan.setText("");
        thari.setText("");
        ttanggal.setDate(null);
        tjamul.setText("");
        tjamsel.setText("");
        tketerangan.setText("");
      }
    
    protected void datatable(){
        Object[] Baris ={"NO","ID PENANGGUNG JAWAB","ID WARGA","NAMA","ALAMAT","KEGIATAN","HARI","TANGGAL","JAM MULAI","JAM SELESAI","KETERANGAN"};
        tabmode = new DefaultTableModel (null, Baris);
        jtable.setModel(tabmode);
        String sql ="select * from datakegiatan";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                 String no = hasil.getString("no");
                String idpenanggungjawab = hasil.getString("idpenanggungjawab");
                String idwarga = hasil.getString("idwarga");
                String namawarga = hasil.getString("namawarga");
                String alamat = hasil.getString("alamat");
                String jeniskegiatan = hasil.getString("jeniskegiatan");
                String hari = hasil.getString("hari");
                String tanggal = hasil.getString("tanggal");
                String jammulai = hasil.getString("jammulai");
                String jamselesai = hasil.getString("jamselesai");
                String keterangan = hasil.getString("keterangan");
                
                String[] data={no,idpenanggungjawab,idwarga,namawarga,alamat,jeniskegiatan,hari,tanggal,jammulai,jamselesai,keterangan};
                tabmode.addRow(data);
            }
            } catch (Exception e) {
        }}
    
     protected void datatable1(){
        Object[] Baris ={"ID","NAMA","TEMPAT LAHIR","TANGGAL LAHIR","JENIS KELAMIN","ALAMAT"};
        tabmode = new DefaultTableModel (null, Baris);
        tableviewwarga.setModel(tabmode);
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
        Object[] Baris ={"ID","NAMA","TEMPAT LAHIR","TANGGAL LAHIR","JENIS KELAMIN","ALAMAT","IDW","NAMA WARGA","KEGIATAN","HARI"};
        tabmode = new DefaultTableModel (null, Baris);
        tviewpj.setModel(tabmode);
        String sql ="select * from datapenanggungjawab";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idpenanggungjawab = hasil.getString("idpenanggungjawab");
                String namapenanggungjawab = hasil.getString("namapenanggungjawab");
                String tempatlahir = hasil.getString("tempatlahir");
                String tanggallahir = hasil.getString("tanggallahir");
                String jeniskelamin = hasil.getString("jeniskelamin");
                String alamat = hasil.getString("alamat");
                String idpetugas = hasil.getString("idpetugas");
                String namapetugas = hasil.getString("namapetugas");
                
                
                
                
                String[] data={idpenanggungjawab,namapenanggungjawab,tempatlahir,tanggallahir,jeniskelamin,alamat,idpetugas,namapetugas};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }}
     
      private void id_auto(){
    try {
        String sql = "SELECT MAX(right(no,2)) Asno FROM datakegiatan";
        java.sql.Statement stat= conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            if (rs.first()==false){
                tnoo.setText("0");
            }else{
            rs.last();
            int auto_id = rs.getInt(1)+1;
            String no = String.valueOf(auto_id);
            int noLong = no.length();
            for (int a = 0; a<3-noLong; a++){
                no = "0" +no;
               
            }
             tnoo.setText("0" +no);
            }
        } 
    }catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error :\n" + e.toString(),"kesalahan",JOptionPane.WARNING_MESSAGE);
}
    }
      
      void cetak_nota(){
         
              
              try {
                  param.put("notakeg",tnoo.getText());
        File file = new File("src/tampilan/notakegiatan.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }      
              
          
      }
     
     
     private void BersihkanSemuaField() {
        
          tidp.setText("");
        tid_.setText("");
        tnama_.setText("");
        talamat_.setText("");
        tkegiatan.setText("");
        thari.setText("");
        ttanggal.setDate(null);
        tjamul.setText("");
        tjamsel.setText("");
        tketerangan.setText("");
     
 
    }
    
    private void setEditStatus(boolean status) {
        if (status == false) {
            bsimpan.setEnabled(false);
            btambah.setEnabled(true);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(false);
            bcetak.setEnabled(true);
            tcariidwarga.setEnabled(false);
            tnoo.setEnabled(true);
            tidp.setEnabled(false);
            tid_.setEnabled(false);
            tnama_.setEnabled(false);
            talamat_.setEnabled(false);
            tkegiatan.setEnabled(false);
            thari.setEnabled(false);
            ttanggal.setEnabled(false);
            tjamul.setEnabled(false);
            tjamsel.setEnabled(false);
            tketerangan.setEnabled(false);
            tcaripj.setEnabled(false);
        

        } else {
            bsimpan.setEnabled(true);
            btambah.setEnabled(false);
            bhapus.setEnabled(false);
            bubah.setEnabled(false);
            bbersih.setEnabled(true);
            bcetak.setEnabled(true);
            tcariidwarga.setEnabled(true);
            tnoo.setEnabled(true);
            tidp.setEnabled(true);
            tid_.setEnabled(true);
            tnama_.setEnabled(false);
            talamat_.setEnabled(false);
            tkegiatan.setEnabled(true);
            thari.setEnabled(true);
            ttanggal.setEnabled(true);
            tjamul.setEnabled(true);
            tjamsel.setEnabled(true);
            tketerangan.setEnabled(true);
            tcaripj.setEnabled(true);
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
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableviewwarga = new javax.swing.JTable();
        jDialog2 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tviewpj = new javax.swing.JTable();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tidp = new javax.swing.JTextField();
        tid_ = new javax.swing.JTextField();
        tnama_ = new javax.swing.JTextField();
        tkegiatan = new javax.swing.JTextField();
        thari = new javax.swing.JTextField();
        tjamsel = new javax.swing.JTextField();
        tjamul = new javax.swing.JTextField();
        ttanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tketerangan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat_ = new javax.swing.JTextArea();
        tcariidwarga = new javax.swing.JButton();
        tcaripj = new javax.swing.JButton();
        tnoo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btambah = new javax.swing.JButton();
        bcetak = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        tgl1 = new com.toedter.calendar.JDateChooser();
        tgl2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        cetaktgl = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(601, 449));
        jDialog1.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/warga.png"))); // NOI18N
        jLabel14.setText("DATA WARGA");

        tableviewwarga.setModel(new javax.swing.table.DefaultTableModel(
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
        tableviewwarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableviewwargaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableviewwarga);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 111, Short.MAX_VALUE))
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

        jDialog2.setMinimumSize(new java.awt.Dimension(754, 579));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/penanggungjawab.png"))); // NOI18N
        jLabel12.setText("DATA PENANGGUNG JAWAB");

        tviewpj.setModel(new javax.swing.table.DefaultTableModel(
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
        tviewpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tviewpjMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tviewpj);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kegiatan.png"))); // NOI18N
        jLabel1.setText("DATA KEGIATAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(902, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID PJ :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID WARGA :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAMA :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ALAMAT :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("JENIS KEGIATAN :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("HARI :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("TANGGAL :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("JAM MULAI :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("JAM SELESAI :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("KETERANGAN :");

        tid_.setEditable(false);

        tketerangan.setColumns(20);
        tketerangan.setRows(5);
        jScrollPane1.setViewportView(tketerangan);

        talamat_.setColumns(20);
        talamat_.setRows(5);
        jScrollPane2.setViewportView(talamat_);

        tcariidwarga.setText("...");
        tcariidwarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariidwargaActionPerformed(evt);
            }
        });

        tcaripj.setText("...");
        tcaripj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcaripjActionPerformed(evt);
            }
        });

        tnoo.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("NO :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tjamsel)
                        .addComponent(thari)
                        .addComponent(tkegiatan)
                        .addComponent(tnama_)
                        .addComponent(tid_)
                        .addComponent(tidp)
                        .addComponent(tjamul)
                        .addComponent(ttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addComponent(tnoo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tcariidwarga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcaripj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tidp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tcaripj))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tid_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tcariidwarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tnama_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tkegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tjamul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tjamsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtable);

        btambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/add.png"))); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
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

        bubah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
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

        bhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/delete.png"))); // NOI18N
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        jLabel13.setText("s/d");

        cetaktgl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cetaktgl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/print.png"))); // NOI18N
        cetaktgl.setText("Cetak");
        cetaktgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetaktglActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btambah)
                        .addGap(18, 18, 18)
                        .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcetak, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel13)
                        .addGap(29, 29, 29)
                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cetaktgl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(bbersih)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bcetak))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(cetaktgl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Delete","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql ="delete from datakegiatan where no ='"+tnoo.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                tnoo.requestFocus();
                datatable();
                id_auto() ;
                
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

            String sql ="update datakegiatan set idpenanggungjawab=?,idwarga =?,namawarga=?,alamat=?,jeniskegiatan=?,hari=?,tanggal=?,jammulai=?,jamselesai=?,keterangan=? where no ='"+tnoo.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString (1, tidp.getText());
            stat.setString (2, tid_.getText());
            stat.setString (3, tnama_.getText());
            stat.setString (4, talamat_.getText());
            stat.setString (5, tkegiatan.getText());
            stat.setString (6, thari.getText());
            stat.setString (7, tgl);
            stat.setString (8, tjamul.getText());
            stat.setString (9, tjamsel.getText());
            stat.setString (10, tketerangan.getText());
            

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            kosong();
            tnoo.requestFocus();
            datatable();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah"+e);

        }
        
    }//GEN-LAST:event_bubahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        
        
        
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgll = String.valueOf(fm.format(ttanggal.getDate()));

        String sql ="insert into datakegiatan values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString (1, tnoo.getText());
            stat.setString (2, tidp.getText());
            stat.setString (3, tid_.getText());
            stat.setString (4, tnama_.getText());
            stat.setString (5, talamat_.getText());
            stat.setString (6, tkegiatan.getText());
            stat.setString (7, thari.getText());
            stat.setString (8, tgll);
            stat.setString (9, tjamul.getText());
            stat.setString (10, tjamsel.getText());
            stat.setString (11, tketerangan.getText());
            

            stat.executeUpdate();
            int pesan =JOptionPane.showConfirmDialog(null, "Cetak Bukti Kegiatan", "Cetak",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION) {
            cetak_nota();
        }
            
            kosong();
//            tnoo.requestFocus();
            datatable();
            id_auto ();
           
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);

        }
       
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        setEditStatus(false);
       id_auto() ;
        BersihkanSemuaField();

        
    }//GEN-LAST:event_bbersihActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        setEditStatus(true);
        BersihkanSemuaField();
    }//GEN-LAST:event_btambahActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:
        setEditStatus(true);
        bsimpan.setEnabled(false);
        bhapus.setEnabled(true);
        bubah.setEnabled(true);
        int bar = jtable.getSelectedRow();
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
       String k = tabmode.getValueAt(bar, 10).toString();

       tnoo.setText(a);
        tidp.setText(b);
        tid_.setText(c);
        tnama_.setText(d);
        talamat_.setText(e);
        tkegiatan.setText(f);
        thari.setText(g);

        try{
            DefaultTableModel tabmode = (DefaultTableModel)jtable.getModel();
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(bar,7));
            ttanggal.setDate(date);} catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Pendataankegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }

        tjamul.setText(i);
        tjamsel.setText(j);
        tketerangan.setText(k);
        
    }//GEN-LAST:event_jtableMouseClicked

    private void tcariidwargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariidwargaActionPerformed
        // TODO add your handling code here:
        jDialog1.setLocationRelativeTo(null);
        datatable1 ();
        jDialog1.setVisible(true);
    }//GEN-LAST:event_tcariidwargaActionPerformed

    private void tableviewwargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableviewwargaMouseClicked
        // TODO add your handling code here:
         int bar= tableviewwarga.getSelectedRow();
        String a= tabmode.getValueAt (bar, 0).toString();
        String b= tabmode.getValueAt(bar, 1).toString();
        String f= tabmode.getValueAt(bar, 5).toString();
        tid_.setText(a);
        tnama_.setText(b);
        talamat_.setText(f);
        
        jDialog1.dispose();
        
    }//GEN-LAST:event_tableviewwargaMouseClicked

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        // TODO add your handling code here:
         try {
        File file = new File("src/tampilan/lapkegiatan.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }      
    }//GEN-LAST:event_bcetakActionPerformed

    private void tcaripjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcaripjActionPerformed
        // TODO add your handling code here:
         jDialog2.setLocationRelativeTo(null);
        datatable2 ();
        jDialog2.setVisible(true);
    }//GEN-LAST:event_tcaripjActionPerformed

    private void tviewpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tviewpjMouseClicked
        // TODO add your handling code here:
        int bar= tviewpj.getSelectedRow();
        String a= tabmode.getValueAt (bar, 0).toString();
        tidp.setText(a);
    }//GEN-LAST:event_tviewpjMouseClicked

    private void cetaktglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetaktglActionPerformed
        // TODO add your handling code here:
        try {
        param.put("tgl",tgl1.getDate());
        param.put("tgll",tgl2.getDate());
        File file = new File("src/tampilan/lapkegiatan1.jrxml");
        jasperDesign = JRXmlLoader.load(file);
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
        JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cetaktglActionPerformed

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
            java.util.logging.Logger.getLogger(Pendataankegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pendataankegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pendataankegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pendataankegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pendataankegiatan().setVisible(true);
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
    private javax.swing.JButton cetaktgl;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtable;
    private javax.swing.JTable tableviewwarga;
    private javax.swing.JTextArea talamat_;
    private javax.swing.JButton tcariidwarga;
    private javax.swing.JButton tcaripj;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    private javax.swing.JTextField thari;
    private javax.swing.JTextField tid_;
    private javax.swing.JTextField tidp;
    private javax.swing.JTextField tjamsel;
    private javax.swing.JTextField tjamul;
    private javax.swing.JTextField tkegiatan;
    private javax.swing.JTextArea tketerangan;
    private javax.swing.JTextField tnama_;
    private javax.swing.JTextField tnoo;
    private com.toedter.calendar.JDateChooser ttanggal;
    private javax.swing.JTable tviewpj;
    // End of variables declaration//GEN-END:variables
}
