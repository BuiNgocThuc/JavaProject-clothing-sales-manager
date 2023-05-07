/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.PHANQUYEN;

import Back_End.CHUCNANG.CHUCNANG;
import Back_End.CHUCNANG.CHUCNANGBUS;
import Back_End.CTPhanQuyen.CTPhanQuyen;
import Back_End.CTPhanQuyen.CTPhanQuyenBUS;
import Back_End.NHOMQUYEN.NHOMQUYEN;
import Back_End.NHOMQUYEN.NHOMQUYENBUS;
import Front_End.KHUYENMAI.createKMform;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author NGOC THUC
 */
public class CHUCNANGGUI extends JFrame {

    JPanel pnText = new JPanel();
    JPanel pnCheckBox = new JPanel();
    JPanel pnTool = new JPanel();

    ArrayList<JCheckBox> chbList = new ArrayList<>();
    JTextField txtRoleID = new JTextField();
    JTextField txtRoleName = new JTextField();
    JTextField txtDescription = new JTextField();

//    JCheckBox chbBanHang = new JCheckBox("Bán hàng");
//    JCheckBox chbNhapHang = new JCheckBox("Nhập Hàng");
//    JCheckBox chbSanPham = new JCheckBox("Sản Phẩm");
//    JCheckBox chbThuongHieu = new JCheckBox("Thương Hiệu");
//    JCheckBox chbHoaDon = new JCheckBox("Hóa Đơn");
//    JCheckBox chbPhieuNhap = new JCheckBox("Phiếu Nhập");
//    JCheckBox chbNhanVien = new JCheckBox("Nhân Viên");
//    JCheckBox chbKhachHang = new JCheckBox("Khách Hàng");
//    JCheckBox chbNhaCungCap = new JCheckBox("Nhà Cung Cấp");
//    JCheckBox chbThongKe = new JCheckBox("Thống Kê");
//    JCheckBox chbKhuyenMai = new JCheckBox("Khuyến Mại");
//    JCheckBox chbTaiKhoan = new JCheckBox("Tài Khoản");
//    JCheckBox chbPhanQuyen = new JCheckBox("Phân Quyền");
    JLabel lblAdd = new JLabel("Thêm", JLabel.CENTER);
    JLabel lblCancel = new JLabel("Hủy", JLabel.CENTER);

//    public void createCheckbox() {
//        chbList.add(chbBanHang);
//        chbList.add(chbNhapHang);
//        chbList.add(chbSanPham);
//        chbList.add(chbThuongHieu);
//        chbList.add(chbHoaDon);
//        chbList.add(chbPhieuNhap);
//        chbList.add(chbNhanVien);
//        chbList.add(chbKhachHang);
//        chbList.add(chbNhaCungCap);
//        chbList.add(chbThongKe);
//        chbList.add(chbKhuyenMai);
//        chbList.add(chbTaiKhoan);
//        chbList.add(chbPhanQuyen);
//    }
    NHOMQUYENBUS nq = new NHOMQUYENBUS();
    CTPhanQuyenBUS ctpq = new CTPhanQuyenBUS();
    ArrayList<NHOMQUYEN> dsnq = nq.getDsnq();
    CHUCNANGBUS cnBUS = new CHUCNANGBUS();
    ArrayList<CHUCNANG> dscn = cnBUS.getDscn();

    public CHUCNANGGUI() {

        for (CHUCNANG cn : dscn) {
            JCheckBox cb = new JCheckBox(cn.getTenCN());
            chbList.add(cb);
        }

        initComponents(dsnq);
    }

    public void initComponents(ArrayList<NHOMQUYEN> dsnq) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        this.setSize(500, 750);
        this.add(textInfo(dsnq));
        this.add(selectContent());
        this.add(tools());

        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel textInfo(ArrayList<NHOMQUYEN> dsnq) {
        pnText.setLayout(new FlowLayout());
        pnText.setPreferredSize(new Dimension(350, 50));

        String ID = nq.getNextID();
        txtRoleID.setText(ID);

        txtRoleID.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Mã quyền"));
        txtRoleID.setPreferredSize(new Dimension(100, 40));
        txtRoleID.setEnabled(false);

        txtRoleName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tên quyền"));
        txtRoleName.setPreferredSize(new Dimension(100, 40));
        
        txtDescription.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Mô Tả quyền"));
        txtDescription.setPreferredSize(new Dimension(100, 40));

        pnText.add(txtRoleID);
        pnText.add(txtRoleName);
        pnText.add(txtDescription);
        return pnText;
    }

    public JPanel selectContent() {
        pnCheckBox.setPreferredSize(new Dimension(350, 550));
        pnCheckBox.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chức Năng"));
        pnCheckBox.setLayout(new FlowLayout(FlowLayout.CENTER));

        for (JCheckBox cb : chbList) {
            cb.setPreferredSize(new Dimension(250, 35));
            pnCheckBox.add(cb);
        }

        return pnCheckBox;
    }

    public JPanel tools() {
        lblAdd.setPreferredSize(new Dimension(100, 40));
        lblAdd.setBackground(Color.white);
        lblAdd.setOpaque(true);
        lblAdd.setForeground(Color.black);
        lblAdd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblAdd.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-new-32.png"));
        lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String maQuyen = txtRoleID.getText();
                String tenQuyen = txtRoleName.getText();
                String moTaQuyen = txtDescription.getText();
                 if (tenQuyen.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tên quyền không để trống");
                    txtRoleName.requestFocus();
                    return;
                }
                if (moTaQuyen.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mô tả quyền không để trống");
                    txtDescription.requestFocus();
                    return;
                }
                String trangThai = "ĐANG HOAT ĐỘNG";
                boolean success = nq.add(maQuyen, tenQuyen, moTaQuyen, trangThai);
                if (success) {
                    ArrayList<JCheckBox> selectedCheckboxes = new ArrayList<>();
                    for (JCheckBox checkbox : chbList) {
                        if (checkbox.isSelected()) {
                            selectedCheckboxes.add(checkbox);
                        }
                    }
                    for (CHUCNANG cn : dscn) {
                         for (JCheckBox checkBox : selectedCheckboxes) {
                             if(checkBox.getText() == cn.getTenCN()) {
                                 ctpq.add(maQuyen, cn.getMaCN());
                                 break;
                             }
                        }
                    }
                   
                    JOptionPane.showMessageDialog(null, "Tạo nhóm quyền thành công!! Nhấn 'Làm Mới' để cập nhật");
                    CHUCNANGGUI.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã thêm nhóm quyền thất bại");
                    return;
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
                CHUCNANGGUI.this.setVisible(false);
            }
        });

        pnTool.setPreferredSize(new Dimension(500, 100));
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnTool.add(lblAdd);
        pnTool.add(lblCancel);
        return pnTool;
    }

    public static void main(String[] args) {
        new CHUCNANGGUI();
    }
}
