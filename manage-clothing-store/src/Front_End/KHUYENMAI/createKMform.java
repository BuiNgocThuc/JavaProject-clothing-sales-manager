/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.KHUYENMAI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author NGOC THUC
 */
public class createKMform extends JFrame {

    JTextField txtMaKM = new JTextField();
    JTextField txtTenKM = new JTextField();
    JTextField txtDieuKien = new JTextField();
    JTextField txtPhanTramGiamGia = new JTextField();
    JTextField txtNgayBatDau = new JTextField();
    JTextField txtNgayKetThuc = new JTextField();

    JLabel lblCalendar_Start = new JLabel();
    JLabel lblCalendar_End = new JLabel();
    JLabel lblAdd = new JLabel("Thêm", JLabel.CENTER);
    JLabel lblCancel = new JLabel("Hủy", JLabel.CENTER);

    JPanel pnDate = new JPanel();
    JPanel pnText = new JPanel();
    JPanel pnTool = new JPanel();

    ArrayList<JTextField> txtList = new ArrayList<>();

    public createKMform() {
        this.setUndecorated(true);
        initComponents();

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        txtList.add(txtMaKM);
        txtList.add(txtTenKM);
        txtList.add(txtDieuKien);
        txtList.add(txtPhanTramGiamGia);

        this.setSize(600, 400);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());

        pnText.setPreferredSize(new Dimension(0, 300));
        pnText.setBackground(Color.white);
        pnText.setOpaque(true);
        pnText.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        for (JTextField txtObject : txtList) {
            txtObject.setPreferredSize(new Dimension(200, 50));
            txtObject.setBackground(Color.white);
            txtObject.setOpaque(true);
            txtObject.setForeground(Color.black);
            pnText.add(txtObject);
        }

        txtMaKM.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "mã khuyến mại", TitledBorder.LEFT, TitledBorder.TOP));
        txtTenKM.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "tên khuyến mại", TitledBorder.LEFT, TitledBorder.TOP));
        txtDieuKien.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "điều kiện khuyến mại", TitledBorder.LEFT, TitledBorder.TOP));
        txtPhanTramGiamGia.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "phần trăm giảm giá", TitledBorder.LEFT, TitledBorder.TOP));
        txtNgayBatDau.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "ngày bắt đầu", TitledBorder.LEFT, TitledBorder.TOP));
        txtNgayKetThuc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "ngày kết thúc", TitledBorder.LEFT, TitledBorder.TOP));

        lblCalendar_Start.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-calendar-32.png"));
        lblCalendar_Start.setBackground(Color.WHITE);
        lblCalendar_Start.setOpaque(true);

        lblCalendar_End.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-calendar-32.png"));
        lblCalendar_End.setBackground(Color.WHITE);
        lblCalendar_End.setOpaque(true);

        txtNgayBatDau.setPreferredSize(new Dimension(150, 40));
        txtNgayBatDau.setBackground(Color.WHITE);
        txtNgayBatDau.setOpaque(true);
        txtNgayBatDau.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Từ Ngày", TitledBorder.LEFT, TitledBorder.TOP));

        txtNgayKetThuc.setPreferredSize(new Dimension(150, 40));
        txtNgayKetThuc.setBackground(Color.WHITE);
        txtNgayKetThuc.setOpaque(true);
        txtNgayKetThuc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Đến Ngày", TitledBorder.LEFT, TitledBorder.TOP));

        pnDate.setPreferredSize(new Dimension(450, 80));
        pnDate.setBackground(Color.white);
        pnDate.setOpaque(true);
        pnDate.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Trong Khoảng", TitledBorder.LEFT, TitledBorder.TOP));
        pnDate.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnDate.add(txtNgayBatDau);
        pnDate.add(lblCalendar_Start);
        pnDate.add(txtNgayKetThuc);
        pnDate.add(lblCalendar_End);

        lblAdd.setPreferredSize(new Dimension(100, 40));
        lblAdd.setBackground(Color.white);
        lblAdd.setOpaque(true);
        lblAdd.setForeground(Color.black);
        lblAdd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblAdd.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-new-32.png"));
        lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblCancel.setPreferredSize(new Dimension(100, 40));
        lblCancel.setBackground(Color.white);
        lblCancel.setOpaque(true);
        lblCancel.setForeground(Color.black);
        lblCancel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblCancel.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-close-window-32.png"));
        lblCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                createKMform.this.setVisible(false);
            }
        });

        pnTool.setPreferredSize(new Dimension(0, 100));
        pnTool.setBackground(Color.white);
        pnTool.setOpaque(true);
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
        pnTool.add(lblAdd);
        pnTool.add(lblCancel);

        pnText.add(pnDate);
        this.add(pnText, BorderLayout.CENTER);
        this.add(pnTool, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new createKMform();
    }
}
