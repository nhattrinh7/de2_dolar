
package de2_dolar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class JFNhanvien extends javax.swing.JFrame {
    String filePath = "E:\\netbeans\\de2_dolar\\nhanvien.dat" ;

    ArrayList<NhanVien> list = new ArrayList<>();
    

    public JFNhanvien() {
        initComponents();
        ViewTable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnReadFile = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HO TEN", "NGAY SINH", "DIA CHI", "GIOI TINH", "PHONG BAN", "HE SO LUONG", "THAM NIEN", "LUONG CO BAN"
            }
        ));
        jScrollPane1.setViewportView(tblNhanVien);

        btnReadFile.setText("Read File");
        btnReadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadFileActionPerformed(evt);
            }
        });

        btnShow.setText("Show after read file");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnReadFile)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnReadFile)
                        .addGap(18, 18, 18)
                        .addComponent(btnShow)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadFileActionPerformed
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Đọc từng dòng trong file
            while ((line = br.readLine()) != null) {
                // Tách các thuộc tính bằng ký tự '$'
                String[] data = line.split("\\$");

                // Tạo đối tượng NhânVien từ dữ liệu và thêm vào ArrayList
                NhanVien nhanVien = new NhanVien(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Float.parseFloat(data[5]),
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7])
                );
                list.add(nhanVien);
            }
            
        } catch (IOException e) {
            System.out.println("Xay ra loi khi doc file: " + e.getMessage());
        }
    }//GEN-LAST:event_btnReadFileActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        ViewTable();
    }//GEN-LAST:event_btnShowActionPerformed

    void ViewTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblNhanVien.getModel();
        model.setNumRows(0);
        for(NhanVien x: list) {
            model.addRow(new Object[] {x.getHoTen(), x.getNgaySinh(), x.getDiaChi(), x.getGioiTinh(), x.getPhongBan(), x.getHeSoLuong(), x.getThamNien(), x.getLuongCoBan()});
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFNhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReadFile;
    private javax.swing.JButton btnShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNhanVien;
    // End of variables declaration//GEN-END:variables
}
