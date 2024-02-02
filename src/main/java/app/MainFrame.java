/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import entities.Sach;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class MainFrame extends javax.swing.JFrame {
    DefaultTableModel model;
    
    /**
     * Creates new form Frame
     */
    public MainFrame(int index) {
        initComponents();
        setLocationRelativeTo(null);
        init(index);
        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblTime.setText(format.format(new Date()));
            }
        }).start();
        //214 ; 350
    }
    void init(int index) {
        if(index==0){
            new DangNhapJDialog(this, true).setVisible(true);
        }
        try {
            if (utils.Auth.isLogin()) {
                jMLogin.setVisible(false);
                lblMaNV.setText(utils.Auth.user.getMaNhanVien());
                lblTenNV.setText(utils.Auth.user.getHoVaTen());
            }

            if (!utils.Auth.isManager()) {
                jMDoanhThu.setEnabled(false);
                jMqlnv.setEnabled(false);
                theloai.setEnabled(false);
                Tacgia.setEnabled(false);
                nhaxb.setEnabled(false);
            }
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

        jMenu1 = new javax.swing.JMenu();
        grpRole = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnKho = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        System = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMLogin = new javax.swing.JMenuItem();
        jMLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMExit = new javax.swing.JMenuItem();
        Manage = new javax.swing.JMenu();
        jMqlsach = new javax.swing.JMenuItem();
        Tacgia = new javax.swing.JMenuItem();
        theloai = new javax.swing.JMenuItem();
        nhaxb = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMqlnv = new javax.swing.JMenuItem();
        jMNguoiDung = new javax.swing.JMenuItem();
        jMThongKe = new javax.swing.JMenu();
        jMDoanhThu = new javax.swing.JMenuItem();
        Services = new javax.swing.JMenu();
        jMOpenDis = new javax.swing.JMenuItem();
        jMOpenFB = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(32, 136, 203));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMaximumSize(new java.awt.Dimension(87, 52));
        btnLogout.setMinimumSize(new java.awt.Dimension(87, 52));
        btnLogout.setPreferredSize(new java.awt.Dimension(87, 52));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnSettings.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSettings.setForeground(new java.awt.Color(32, 136, 203));
        btnSettings.setIcon(new javax.swing.ImageIcon("E:\\NMKTPM\\Project\\JavaApplication37\\src\\AppFrame\\icons\\settings-84-16.png")); // NOI18N
        btnSettings.setText("Cài đặt");
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setMaximumSize(new java.awt.Dimension(87, 52));
        btnSettings.setMinimumSize(new java.awt.Dimension(87, 52));
        btnSettings.setPreferredSize(new java.awt.Dimension(87, 52));
        btnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(32, 136, 203));
        btnAccount.setIcon(new javax.swing.ImageIcon("E:\\NMKTPM\\Project\\JavaApplication37\\src\\AppFrame\\icons\\profile.png")); // NOI18N
        btnAccount.setText("Tài khoản");
        btnAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAccount.setMaximumSize(new java.awt.Dimension(87, 52));
        btnAccount.setMinimumSize(new java.awt.Dimension(87, 52));
        btnAccount.setPreferredSize(new java.awt.Dimension(87, 52));
        btnAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAccountMouseEntered(evt);
            }
        });
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnKho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKho.setForeground(new java.awt.Color(32, 136, 203));
        btnKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/storage.png"))); // NOI18N
        btnKho.setText("QUẢN LÝ KHO");
        btnKho.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKho.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoActionPerformed(evt);
            }
        });

        btnInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(32, 136, 203));
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/information.png"))); // NOI18N
        btnInfo.setText("Thông tin");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInfo)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        jPanel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setText("12:00:00 AM");

        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV.setText("MANV");

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenNV.setText("TenNV");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(lblMaNV)
                    .addComponent(lblTenNV)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel3)
                .addContainerGap(591, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 780, 430));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        System.setText("Hệ thống");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon("E:\\NMKTPM\\Project\\JavaApplication37\\src\\AppFrame\\icons\\change-password-27-16.png")); // NOI18N
        jMenuItem2.setText("Đổi mật khẩu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        System.add(jMenuItem2);

        jMLogin.setText("Đăng nhập");
        jMLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMLoginActionPerformed(evt);
            }
        });
        System.add(jMLogin);

        jMLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jMLogout.setText("Đăng xuất");
        jMLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMLogoutActionPerformed(evt);
            }
        });
        System.add(jMLogout);
        System.add(jSeparator1);

        jMExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shutdown.png"))); // NOI18N
        jMExit.setText("Thoát");
        jMExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMExitActionPerformed(evt);
            }
        });
        System.add(jMExit);

        jMenuBar1.add(System);

        Manage.setText("Quản Lý");

        jMqlsach.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMqlsach.setIcon(new javax.swing.ImageIcon("E:\\NMKTPM\\Project\\JavaApplication37\\src\\AppFrame\\icons\\book.png")); // NOI18N
        jMqlsach.setText("Sách");
        jMqlsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMqlsachMouseClicked(evt);
            }
        });
        jMqlsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMqlsachActionPerformed(evt);
            }
        });
        Manage.add(jMqlsach);

        Tacgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/writer.png"))); // NOI18N
        Tacgia.setText("Tác giả");
        Tacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TacgiaActionPerformed(evt);
            }
        });
        Manage.add(Tacgia);

        theloai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/type.png"))); // NOI18N
        theloai.setText("Thể loại");
        theloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theloaiActionPerformed(evt);
            }
        });
        Manage.add(theloai);

        nhaxb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/information.png"))); // NOI18N
        nhaxb.setText("Nhà xuất bản");
        nhaxb.setEnabled(false);
        nhaxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaxbActionPerformed(evt);
            }
        });
        Manage.add(nhaxb);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jMenuItem4.setText("Hóa đơn");
        Manage.add(jMenuItem4);
        Manage.add(jSeparator2);

        jMqlnv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMqlnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        jMqlnv.setText("Nhân viên");
        jMqlnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMqlnvActionPerformed(evt);
            }
        });
        Manage.add(jMqlnv);

        jMNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        jMNguoiDung.setText("Thông tin NV");
        jMNguoiDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNguoiDungActionPerformed(evt);
            }
        });
        Manage.add(jMNguoiDung);

        jMenuBar1.add(Manage);

        jMThongKe.setText("Thống kê");

        jMDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/revenue.png"))); // NOI18N
        jMDoanhThu.setText("Doanh Thu");
        jMDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDoanhThuActionPerformed(evt);
            }
        });
        jMThongKe.add(jMDoanhThu);

        jMenuBar1.add(jMThongKe);

        Services.setText("Hỗ trợ");

        jMOpenDis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/discord.png"))); // NOI18N
        jMOpenDis.setText("Discord");
        jMOpenDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMOpenDisActionPerformed(evt);
            }
        });
        Services.add(jMOpenDis);

        jMOpenFB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/facebook.png"))); // NOI18N
        jMOpenFB.setText("Facebook");
        jMOpenFB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMOpenFBActionPerformed(evt);
            }
        });
        Services.add(jMOpenFB);

        jMenuBar1.add(Services);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMqlsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMqlsachActionPerformed
        new QuanLySachJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMqlsachActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        new NhanVienJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void jMOpenDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMOpenDisActionPerformed
    openWebp("https://discord.gg/S52e5JNcNf");
    }//GEN-LAST:event_jMOpenDisActionPerformed

    private void jMqlsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMqlsachMouseClicked

    }//GEN-LAST:event_jMqlsachMouseClicked

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // TODO add your handling code here:
        new SettingJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jMqlnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMqlnvActionPerformed
    new NhanVienJDialog(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMqlnvActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     // TODO add your handling code here:
     new DoiMatKhauJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMExitActionPerformed
    CloseApp();
    }//GEN-LAST:event_jMExitActionPerformed

    private void btnAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccountMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccountMouseEntered

    private void jMOpenFBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMOpenFBActionPerformed
        // TODO add your handling code here:
        openWebp("https://www.facebook.com/TuanNguyen160804/");
    }//GEN-LAST:event_jMOpenFBActionPerformed

    private void jMLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMLogoutActionPerformed
        utils.DialogHelper.confirm(this, "Đang thực hiện đăng xuất...");  
        utils.Auth.clear();
        dispose();
        new DangNhapJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMLogoutActionPerformed

    private void btnKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoActionPerformed
        // TODO add your handling code here:
        new QuanLyKhoJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnKhoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        utils.DialogHelper.confirm(this, "Đang thực hiện đăng xuất...");  
        utils.Auth.clear();
        dispose();
        new DangNhapJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jMLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMLoginActionPerformed
        // TODO add your handling code here:
        dispose();
        new DangNhapJDialog(this, true).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMLoginActionPerformed

    private void TacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TacgiaActionPerformed
        // TODO add your handling code here:
        new tacgiaJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_TacgiaActionPerformed

    private void theloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theloaiActionPerformed
        // TODO add your handling code here:
        new theloaiJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_theloaiActionPerformed

    private void jMNguoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNguoiDungActionPerformed
        // TODO add your handling code here:
        new NguoiDungJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMNguoiDungActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        // TODO add your handling code here:
        new NguoiDungJDialog(this, true).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void jMDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDoanhThuActionPerformed
        // TODO add your handling code here:
        new ThongKeJDialog(this, true).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMDoanhThuActionPerformed

    private void nhaxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaxbActionPerformed
        // TODO add your handling code here:
        new nhaXBJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_nhaxbActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(0).setVisible(true);
            }
        });
    }
    private void openWebp(String url){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi mở trang");
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Manage;
    private javax.swing.JMenu Services;
    private javax.swing.JMenu System;
    private javax.swing.JMenuItem Tacgia;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnKho;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSettings;
    private javax.swing.ButtonGroup grpRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMDoanhThu;
    private javax.swing.JMenuItem jMExit;
    private javax.swing.JMenuItem jMLogin;
    private javax.swing.JMenuItem jMLogout;
    private javax.swing.JMenuItem jMNguoiDung;
    private javax.swing.JMenuItem jMOpenDis;
    private javax.swing.JMenuItem jMOpenFB;
    private javax.swing.JMenu jMThongKe;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMqlnv;
    private javax.swing.JMenuItem jMqlsach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem nhaxb;
    private javax.swing.JMenuItem theloai;
    // End of variables declaration//GEN-END:variables

    public void CloseApp(){
        int r = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if(r==JOptionPane.YES_OPTION){
            java.lang.System.exit(0);
        }
    }   
}
