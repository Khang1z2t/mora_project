/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import dao.KhoDAO;
import dao.SachDAO;
import dao.ThongKeDAO;
import entities.Kho;
import entities.Sach;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.XDate;

/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class TonKhoJDialog extends javax.swing.JDialog {
    DefaultTableModel tblModel;
    int index = 0;
    ArrayList <Sach> temp = new ArrayList<>();
    List<Sach> unsavedData = new ArrayList<>();
    DefaultComboBoxModel cbxModel;
    /**
     * Creates new form TonKhoJDialog
     */
    public TonKhoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        initCBXDates();
        initTable();
        initComboBox();
        DBFillToList();
    }
    private void DBFillToList() {
        SachDAO cdd = new SachDAO();
        temp = (ArrayList<Sach>) cdd.SelectAll();
    }
private void initCBXDates() {
    cbxModel = new DefaultComboBoxModel();
    // Get today's date
    Date today = new Date();
    // Add today's date to the model
    cbxModel.addElement(today);
    // Calculate yesterday's date
    Date yesterday = XDate.addDays(today, -1);
    // Add yesterday's date to the model
    cbxModel.addElement(yesterday);
    // Retrieve distinct dates from SQL and add them to the model
    List<Date> listDate = new SachDAO().selectDate();
    if (listDate != null && !listDate.isEmpty()) {
        for (Date date : listDate) {
            // Avoid adding duplicates (today and yesterday already added)
            if (!date.equals(today) && !date.equals(yesterday)) {
                cbxModel.addElement(date);
            }
        }
    }

    cbxDate.setModel(cbxModel);
}


//Phần lưu hàng tồn
//    private void saveHangTon() {
//        try {
//            // Gọi stored procedure để lưu dữ liệu từ danh sách chưa lưu
//            List<Object[]> resultList = new SachDAO().saveHangTon(unsavedData);
//            unsavedData.clear(); // Xóa dữ liệu đã lưu khỏi danh sách chưa lưu
//            utils.DialogHelper.alert(this, "Lưu kiểm kê thành công!");
//        } catch (Exception e) {
//            utils.DialogHelper.alert(this, "Đã xảy ra lỗi khi lưu kiểm kê!");
//            e.printStackTrace();
//        }
//    }
    // Phương thức fill dữ liệu từ stored procedure vào bảng
private void fillTableDate() {
    // Clear existing rows from the table
    tblModel.setRowCount(0);

    // Get the selected date from cbxDate
    Date selectedDate = (Date) cbxDate.getSelectedItem();

    // Check if a date is selected
    if (selectedDate == null) {
        // Handle the case where no date is selected
        return;
    }
    SachDAO sachDAO = new SachDAO();
    // Call the stored procedure to get data for the selected date
    List<Object[]> lst = sachDAO.getHangTon(selectedDate);

    // Iterate through the result and add rows to tblModel
    for (Object[] objects : lst) {
        tblModel.addRow(new Object[]{
            // Adjust the indices based on the structure of lst
            objects[0],  // Assuming it's "masach"
            objects[1],  // Assuming it's "tensach"
            objects[2],  // Assuming it's "soluong"
            selectedDate // You might want to display the selected date
        });
    }
}

    private void chooseCBX(){
      Sach sach =  (Sach) cbxModel.getSelectedItem();
      Date ngayton = sach.getNgayton();
      new SachDAO().getHangTon(ngayton);
      fillTableDate();
}
    void showDetail(int index) {
        Sach sach = (Sach) cbxSach.getSelectedItem();
        cbxDate.setSelectedItem(sach.getNgayton());
        txtSoLuong.setText(String.valueOf(sach.getSoluong()));
        txtSoLuong.requestFocus();
    }
//    private void fillTableDate() {
//        DefaultTableModel tblModel = (DefaultTableModel) tblTon.getModel();
//        tblModel.setRowCount(0);
//        try {
//            Date date = (Date) cbxDate.getSelectedItem();
//            temp = new SachDAO().getHangTon(date);
//            for (Object[] objects : lst) {
//                tblModel.addRow(objects);
//            }
//        } catch (Exception e) {
//        }
//    }
//    
//    private void saveHangTon(){
//    try {
//            Sach sach = (Sach) cbxSach.getSelectedItem();
//            // Gọi stored procedure để lưu tồn kho
//            String masach = sach.getMaSach();
//            String tensach = sach.getTenSach();
//            int soluong = sach.getSoluong();
//             
//            // Gọi stored procedure để lưu tồn kho
//            new SachDAO().saveHangTon((int) new Date().getTime());
//
//        utils.DialogHelper.alert(this, "Lưu kiểm kê thành công!");
//    } catch (Exception e) {
//        utils.DialogHelper.alert(this, "Đã xảy ra lỗi khi lưu kiểm kê!");
//        e.printStackTrace();
//    }
//    }
    private void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{
            "STT",
            "Mã sách",
            "Tên sách",
            "Số lượng",
            "Ngày tồn",
        });
        tblTon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblTon.getTableHeader().setOpaque(false);
        tblTon.getTableHeader().setBackground(new Color(240, 183, 28));
        tblTon.getTableHeader().setForeground(new Color(255, 255, 255));
        tblTon.setRowHeight(25);
        tblTon.setModel(tblModel);
    }
    private void initComboBox() {
        cbxModel = new DefaultComboBoxModel();
        cbxModel.removeAllElements();
        List<Sach> lst = new SachDAO().SelectAll();
        for (Sach sach : lst) {
            cbxModel.addElement(sach);
        }
        cbxSach.setModel(cbxModel);
    }
public void addHang() {
        try {
            // Lấy dữ liệu từ các trường nhập liệu
            Sach sach =  (Sach) cbxSach.getSelectedItem();
            
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            sach.setSoluong(soLuong);
            // Thêm hàng vào bảng
            temp.add(sach);
            new SachDAO().update(sach);
            fillToTableTon();
            // Xóa dữ liệu trên các trường nhập liệu
            txtSoLuong.setText("");
        } catch (NumberFormatException e) {
            utils.DialogHelper.alert(this, "Số lượng không hợp lệ!");
        }
    }

public void removeHang() {
        DefaultTableModel model = (DefaultTableModel) tblTon.getModel();
        int selectedRow = tblTon.getSelectedRow();
        if (selectedRow != -1) {
            if (utils.DialogHelper.confirm(this, "Bạn muốn xóa mục hàng đã được chọn?")) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String masach = (String) tblTon.getValueAt(i,1);
                    Sach sach = new SachDAO().selectById(masach);
                    sach.setSoluong(0);
                    new SachDAO().update(sach);
//                    model.setValueAt(i + 1, i, 0);
                }
                temp.remove(selectedRow);
                fillToTableTon();
            }
        } else {
            utils.DialogHelper.alert(this, "Vui lòng chọn một hàng để xóa.");
        }
    }

    public void fillToTableTon() {
        DefaultTableModel model = (DefaultTableModel) tblTon.getModel();
        model.setRowCount(0);
            try {
                   for(int i=0;i<temp.size();i++){
                       Object[] row = {
                           i+1,
                           temp.get(i).getMaSach(),
                           temp.get(i).getTenSach(),
                           temp.get(i).getSoluong(),
                           XDate.toString(temp.get(i).getNgayton(),"dd-MM-yyyy"),
                       };
                       model.addRow(row);
                   }
            } catch (Exception e) {
        }
    }
    //Còn lỗi ở update So luong - > kh cap nhat duoc,co the fillToTable bi loi
    public void updateSoLuong() {
        try {
            for (int i = 0; i < tblTon.getRowCount(); i++) {
                String ma = (String) tblTon.getValueAt(i, 1);
                
                // Sử dụng ArrayList để chứa kết quả từ selectById
                Sach sach = new SachDAO().selectById(ma);
                
                // Kiểm tra xem danh sách có phần tử không trước khi thực hiện các thao tác
                if (sach != null) {
                    sach.setSoluong(Integer.parseInt(String.valueOf(tblTon.getValueAt(i, 3))));
                    new SachDAO().update(sach);
                    fillToTableTon();
                } else {
                    // Xử lý khi không tìm thấy đối tượng với mã tương ứng
                    System.out.println("Không tìm thấy đối tượng với mã: " + ma);
                }
            }
            utils.DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (NumberFormatException e) {
            utils.DialogHelper.alert(this, "Số lượng không hợp lệ!");
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxDate = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxSach = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THỰC HIỆN KIỂM KÊ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Ngày kiểm kê");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 20, -1, -1));

        cbxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDateActionPerformed(evt);
            }
        });
        jPanel1.add(cbxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 42, 155, -1));

        jLabel3.setText("Thông tin kiểm kê");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        cbxSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSachActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, -1));

        jLabel4.setText("Số lượng");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 181, -1));

        btnSave.setBackground(new java.awt.Color(240, 183, 28));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(32, 136, 203));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSave.setText("LƯU KIỂM KÊ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        tblTon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTon);
        if (tblTon.getColumnModel().getColumnCount() > 0) {
            tblTon.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tblTon.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tblTon.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tblTon.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 640, 410));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/down-arrow.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(32, 136, 203));
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(32, 136, 203));
        btnEdit.setText("SỬA");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 230, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(516, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addHang();
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDateActionPerformed
        // TODO add your handling code here:
         chooseCBX();
    }//GEN-LAST:event_cbxDateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        removeHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        updateSoLuong();
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbxSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSachActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
//        try {
//            // Lấy thông tin từ ComboBox và TextField
//            Sach sach = (Sach) cbxSach.getSelectedItem();
//            int soluong = sach.getSoluong();
//
//            // Lấy ngày hiện tại
//            Date currentDate = new Date();
//
//            sach.setSoluong(soluong);
//            sach.setNgayton(currentDate);
//
//            // Thêm vào danh sách chưa lưu
//            temp.add(sach);
//            new SachDAO().insert(sach);
//            // Xóa dữ liệu trên các trường nhập liệu
//            txtSoLuong.setText("");
//
//            utils.DialogHelper.alert(this, "Thêm vào danh sách chưa lưu thành công!");
//        } catch (NumberFormatException e) {
//            utils.DialogHelper.alert(this, "Số lượng không hợp lệ!");
//        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblTonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTonMouseClicked
        // TODO add your handling code here:
        try {
            index = tblTon.getSelectedRow();
            showDetail(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblTonMouseClicked

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
            java.util.logging.Logger.getLogger(TonKhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TonKhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TonKhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TonKhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TonKhoJDialog dialog = new TonKhoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxDate;
    private javax.swing.JComboBox<String> cbxSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTon;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
