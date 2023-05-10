/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.TAIKHOAN;

import Back_End.NHANVIEN.NHANVIEN;
import Back_End.NHANVIEN.NHANVIENBUS;
import Back_End.NHANVIEN.NHANVIENDAO;
import Back_End.NHOMQUYEN.NHOMQUYEN;
import Back_End.NHOMQUYEN.NHOMQUYENBUS;
import Back_End.TAIKHOAN.TAIKHOAN;
import Back_End.TAIKHOAN.TAIKHOANBUS;
import Front_End.PHANQUYEN.CHUCNANGGUI;
import Front_End.PHANQUYEN.PHANQUYENGUI;
import static Front_End.PHANQUYEN.PHANQUYENGUI.tblList;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    NHANVIENDAO nvDAO = new NHANVIENDAO();
    NHANVIENBUS nvBUS = new NHANVIENBUS();
    NHOMQUYENBUS nqBus = new NHOMQUYENBUS();

    public newAccount() {
        initComponents();
    }

    void initComponents() {
        this.setUndecorated(true);
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
        btnMaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new newEmployee(getTxtMaNV());
            }
        });

        pnMaNV.add(txtMaNV);
        pnMaNV.add(btnMaNV);
        return pnMaNV;
    }

    public JTextField getTxtMaNV() {
        return txtMaNV;
    }

    public void setTxtMaNV(JTextField txtMaNV) {
        this.txtMaNV = txtMaNV;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtMaQuyen() {
        return txtMaQuyen;
    }

    public void setTxtMaQuyen(JTextField txtMaQuyen) {
        this.txtMaQuyen = txtMaQuyen;
    }

    JPanel MaQuyen() {
        pnMaQuyen.setSize(300, 30);
        pnMaQuyen.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnMaQuyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mã Quyền"));

        txtMaQuyen.setPreferredSize(new Dimension(180, 35));
        btnMaQuyen.setPreferredSize(new Dimension(20, 20));
        btnMaQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new newRole(getTxtMaQuyen());
            }
        });

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
                if (userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mã nhân viên không để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    txtMaNV.requestFocus();
                    return;
                }
                if (passWord.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "mật khẩu không để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    txtPassword.requestFocus();
                    return;
                }
                if (maQuyen.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "mã quyền không để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    txtMaQuyen.requestFocus();
                    return;
                }
                boolean isValid = false;
                ArrayList<NHANVIEN> dsnv = nvDAO.selectAll();
                for (NHANVIEN nv : dsnv) {
                    System.out.println(nv.getMaNV());
                    if (nv.getMaNV().equals(userName)) {

                        isValid = true;
                        break;
                    }
                }
                System.out.println(userName + " " + isValid);
                if (!isValid) {
                    JOptionPane.showMessageDialog(null, "mã nhân viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    isValid = false;
                    ArrayList<NHOMQUYEN> dsnq = nqBus.getDsnq();
                    for (NHOMQUYEN nq : dsnq) {
                        if (nq.getMaQuyen().equals(maQuyen)) {
                            isValid = true;
                            break;
                        }
                    }
                    if (!isValid) {
                        JOptionPane.showMessageDialog(null, "nhóm quyền không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                ArrayList<TAIKHOAN> dstk = tk.getDstk();
                for (TAIKHOAN acc : dstk) {
                    if (acc.getUserName().equals(userName)) {
                        JOptionPane.showMessageDialog(null, "Tài Khoản này đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                String trangthai = "Đang hoạt động";
                boolean success = tk.add(userName, passWord, maQuyen, trangthai);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Tạo tài khoản người dùng thành công!!! Nhấn 'Làm mới' để cập nhật");
                    newAccount.this.dispose();
                } else {
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
                newAccount.this.dispose();
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
