/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.PHANQUYEN;

import Back_End.CHUCNANG.CHUCNANG;
import Back_End.CHUCNANG.CHUCNANGBUS;
import Back_End.CTPhanQuyen.CTPhanQuyenBUS;
import Back_End.NHOMQUYEN.NHOMQUYEN;
import Back_End.NHOMQUYEN.NHOMQUYENBUS;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

/**
 *
 * @author NGOC THUC
 */
public class updatePQForm extends JFrame {

    JPanel pnText = new JPanel();
    JPanel pnCheckBox = new JPanel();
    JPanel pnTool = new JPanel();

    ArrayList<JCheckBox> chbList = new ArrayList<>();
    JTextField txtRoleID = new JTextField();
    JTextField txtRoleName = new JTextField();
    JTextField txtDescription = new JTextField();

    JLabel lblAdd = new JLabel("Sửa", JLabel.CENTER);
    JLabel lblCancel = new JLabel("Hủy", JLabel.CENTER);

    NHOMQUYENBUS nq = new NHOMQUYENBUS();
    CTPhanQuyenBUS ctpq = new CTPhanQuyenBUS();
    ArrayList<NHOMQUYEN> dsnq = nq.getDsnq();
    CHUCNANGBUS cnBUS = new CHUCNANGBUS();
    ArrayList<CHUCNANG> dscn = cnBUS.getDscn();

    public updatePQForm(NHOMQUYEN role, ArrayList<String> dscnNew) {
        txtRoleID.setText(role.getMaQuyen());
        txtRoleName.setText(role.getTenQuyen());
        txtDescription.setText(role.getMoTaQuyen());
        for (CHUCNANG cn : dscn) {
            JCheckBox cb = new JCheckBox(cn.getTenCN());
            System.out.println(cn.getMaCN());
            for (String maCN : dscnNew) {
                if (cn.getMaCN().equals(maCN)) {
                    cb.setSelected(true);
                    break;
                }
            }
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
        pnText.setPreferredSize(new Dimension(450, 50));

        txtRoleID.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Mã quyền"));
        txtRoleID.setPreferredSize(new Dimension(80, 40));
        txtRoleID.setEnabled(false);

        txtRoleName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tên quyền"));
        txtRoleName.setPreferredSize(new Dimension(150, 40));

        txtDescription.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Mô Tả quyền"));
        txtDescription.setPreferredSize(new Dimension(150, 40));

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
                boolean success = nq.update(maQuyen, tenQuyen, moTaQuyen, trangThai);
                if (success) {
                    ctpq.delete(maQuyen);
                    ArrayList<JCheckBox> selectedCheckboxes = new ArrayList<>();
                    for (JCheckBox checkbox : chbList) {
                        if (checkbox.isSelected()) {
                            selectedCheckboxes.add(checkbox);
                        }
                    }
                    for (CHUCNANG cn : dscn) {
                        for (JCheckBox checkBox : selectedCheckboxes) {
                            if (checkBox.getText().equals(cn.getTenCN())) {
                                ctpq.add(maQuyen, cn.getMaCN());
                                break;
                            }
                        }
                    }
                    
                    JOptionPane.showMessageDialog(null, "Đã sửa nhóm quyền thành công!! Nhấn 'Làm Mới' để cập nhật");
                    updatePQForm.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã sửa nhóm quyền thất bại");
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
                updatePQForm.this.setVisible(false);
            }
        });

        pnTool.setPreferredSize(new Dimension(500, 100));
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnTool.add(lblAdd);
        pnTool.add(lblCancel);
        return pnTool;
    }

    public static void main(String[] args) {
//        new updatePQForm();
    }
}
