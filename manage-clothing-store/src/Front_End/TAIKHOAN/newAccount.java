/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.TAIKHOAN;

import Back_End.TAIKHOAN.TAIKHOANBUS;
import Front_End.PHANQUYEN.CHUCNANGGUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author NGOC THUC
 */
public class newAccount extends JFrame {

    JTextField txtMaNV = new JTextField();
    JTextField txtMaQuyen = new JTextField();
    JTextField txtPassword = new JTextField();

    JPanel pnMaNV = new JPanel();
    JPanel pnMaQuyen = new JPanel();
    JPanel pnTool = new JPanel();
    JPanel pnPassword = new JPanel();

    JButton btnMaNV = new JButton("...");
    JButton btnMaQuyen = new JButton("...");
    
    JLabel lblAdd = new JLabel("Thêm");
    JLabel lblCancel = new JLabel("Hủy");
    
    TAIKHOANBUS tk = new TAIKHOANBUS();

    public newAccount() {
        initComponents();
    }

    void initComponents() {
        this.setSize(350, 450);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        this.add(MaNV());
        this.add(password());
        this.add(MaQuyen());
        this.add(tools());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    JPanel password() {
        pnPassword.setPreferredSize(new Dimension(250, 70));
        pnPassword.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mật khẩu"));
        pnPassword.setLayout(new FlowLayout(FlowLayout.CENTER));
        txtPassword.setPreferredSize(new Dimension(200, 35));
        pnPassword.add(txtPassword);
        return pnPassword;
    }

    JPanel MaNV() {
        pnMaNV.setSize(300, 30);
        pnMaNV.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnMaNV.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mã Nhân Viên"));

        txtMaNV.setPreferredSize(new Dimension(180, 35));
        btnMaNV.setPreferredSize(new Dimension(20, 20));

        pnMaNV.add(txtMaNV);
        pnMaNV.add(btnMaNV);
        return pnMaNV;
    }

    JPanel MaQuyen() {
        pnMaQuyen.setSize(300, 30);
        pnMaQuyen.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnMaQuyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mã Quyền"));

        txtMaQuyen.setPreferredSize(new Dimension(180, 35));
        btnMaQuyen.setPreferredSize(new Dimension(20, 20));

        pnMaQuyen.add(txtMaQuyen);
        pnMaQuyen.add(btnMaQuyen);

        return pnMaQuyen;
    }
    
   JPanel tools() {
        lblAdd.setPreferredSize(new Dimension(100, 40));
        lblAdd.setBackground(Color.white);
        lblAdd.setOpaque(true);
        lblAdd.setForeground(Color.black);
        lblAdd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblAdd.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-new-32.png"));
        lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String userName = txtMaNV.getText();
                String passWord = txtPassword.getText();
                String maQuyen = txtMaQuyen.getText();
                String trangthai = "Đang hoạt động";
                boolean success = tk.add(userName, passWord, maQuyen, trangthai);
                if(success) {
                    JOptionPane.showMessageDialog(null, "Tạo tài khoản người dùng thành công");
                }else {
                    JOptionPane.showMessageDialog(null, "Tạo tài khoản thất bại");
                }
            }
        });

        lblCancel.setPreferredSize(new Dimension(100, 40));
        lblCancel.setBackground(Color.white);
        lblCancel.setOpaque(true);
        lblCancel.setForeground(Color.black);
        lblCancel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblCancel.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-close-window-32.png"));
        lblCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                newAccount.this.setVisible(false);
            }
        });

        pnTool.setPreferredSize(new Dimension(500, 100));
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnTool.add(lblAdd);
        pnTool.add(lblCancel);
        return pnTool;
    }

    public static void main(String[] args) {
        new newAccount();
    }
}
