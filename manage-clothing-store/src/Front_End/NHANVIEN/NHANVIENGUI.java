/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.NHANVIEN;

import Back_End.NHANVIEN.NHANVIENBUS;
import Back_End.NHANVIEN.NHANVIENDAO;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NHANVIENGUI extends JPanel {

    NHANVIENBUS nvb = new NHANVIENBUS();

    private JPanel jp1, jp2;
    private JLabel labelNhanVien, labelHoTen, labelDate, labelPhone, labelAddress, labelStatus;
    public static JTextField textNhanVien, textHoTen, textDate, textPhone, textAddress, textStatus, textFind;
    private JButton addBtn, editBtn, deleteBtn, searchBtn, importBtn, exportBtn, pdfBtn;
    public static JTable tb;
    private JScrollPane jsp;
    private JComboBox choose;

    public NHANVIENGUI() {
        init();

        nvb.loadData();

        nvb.showConsole();
    }

    private void init() {

        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400, 480));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin"));

        labelNhanVien = new JLabel("Mã nhân viên: ");
        labelNhanVien.setBounds(10, 10, 50, 30);
        jp1.add(labelNhanVien);

        textNhanVien = new JTextField(33);

        jp1.add(textNhanVien);

        labelHoTen = new JLabel("Họ và tên: ");
        labelHoTen.setBounds(10, 70, 50, 30);
        jp1.add(labelHoTen);

        textHoTen = new JTextField(33);
        jp1.add(textHoTen);

        labelDate = new JLabel("Ngày sinh: ");
        labelDate.setBounds(10, 130, 50, 30);
        jp1.add(labelDate);

        textDate = new JTextField(33);
        jp1.add(textDate);

        labelPhone = new JLabel("Số điện thoại: ");
        labelPhone.setBounds(10, 240, 50, 30);
        jp1.add(labelPhone);

        textPhone = new JTextField(33);
        jp1.add(textPhone);

        labelAddress = new JLabel("Địa chỉ");
        labelAddress.setBounds(10, 270, 50, 30);
        jp1.add(labelAddress);

        textAddress = new JTextField(33);
        jp1.add(textAddress);

        labelStatus = new JLabel("Trạng thái");
        labelStatus.setBounds(10, 300, 50, 30);
        jp1.add(labelStatus);

        textStatus = new JTextField(33);
        jp1.add(textStatus);

        addBtn = new JButton("Thêm");
        addBtn.setPreferredSize(new Dimension(70, 30));
        addBtn.setIcon(new ImageIcon(getClass().getResource("Icon/icon_img/icon8-add-new-32.png")));
        jp1.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBtnActionPerformed(e);
            }
        });

        editBtn = new JButton("Sửa");
        editBtn.setPreferredSize(new Dimension(70, 30));
        editBtn.setIcon(new ImageIcon(getClass().getResource("Icon/icon_img/icons8-tools-28.png")));
        jp1.add(editBtn);

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBtnActionPerformed(e);
            }
        });

        deleteBtn = new JButton("Xóa");
        deleteBtn.setPreferredSize(new Dimension(70, 30));
        deleteBtn.setIcon(new ImageIcon(getClass().getResource("Icon/icon_img/icons8-remove-28.png")));
        jp1.add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBtnActionPerformed(e);
            }
        });

        importBtn = new JButton("Import");
        importBtn.setPreferredSize(new Dimension(70, 30));
        importBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        jp1.add(importBtn);

        exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(70, 30));
        exportBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        jp1.add(exportBtn);

        pdfBtn = new JButton("PDF");
        pdfBtn.setPreferredSize(new Dimension(70, 30));
        pdfBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));
        jp1.add(pdfBtn);

        jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp2.setPreferredSize(new Dimension(350, 100));
        jp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp2.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo tên"));

        textFind = new JTextField(29);
        jp2.add(textFind);

        searchBtn = new JButton("Tìm kiếm");
        searchBtn.setPreferredSize(new Dimension(100, 30));
        choose = new JComboBox<String>();
        choose.addItem("Tìm kiếm theo tên");
        choose.addItem("Tìm kiếm theo mã");
        jp2.add(searchBtn);
        jp2.add(choose);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBtnActionPerformed(e);
            }
        });

        jp1.add(jp2);

        tb = new JTable();
        tb.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã NV", "Họ tên NV", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseCliked(e);
            }
        });

        jsp = new JScrollPane(tb);
        tb.setFillsViewportHeight(true);

        this.add(jp1, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.SOUTH);
    }

    private void addBtnActionPerformed(ActionEvent e) {
        String id = textNhanVien.getText();
        String fullname = textHoTen.getText();
        String date = textDate.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String status = textStatus.getText();

//        NHANVIEN nv = new NHANVIEN(id, fullname, date, phone, address, status);
//
//        NHANVIENDAO.getInstance().insert(nv);
        if (nvb.add(id, fullname, date, phone, address, status)) {
            JOptionPane.showMessageDialog(tb, "Thêm thành công");
        }

        nvb.reset();

        nvb.loadData();
    }

    private void tableMouseCliked(MouseEvent e) {
        int selectedRow = tb.getSelectedRow();
        String manv = tb.getModel().getValueAt(selectedRow, 0).toString();
        String tennv = tb.getModel().getValueAt(selectedRow, 1).toString();
        String ngaysinh = tb.getModel().getValueAt(selectedRow, 2).toString();
        String sdt = tb.getModel().getValueAt(selectedRow, 3).toString();
        String diachi = tb.getModel().getValueAt(selectedRow, 4).toString();
        String trangthai = tb.getModel().getValueAt(selectedRow, 5).toString();
        textNhanVien.setText(manv);
        textHoTen.setText(tennv);
        textDate.setText(ngaysinh);
        textPhone.setText(sdt);
        textAddress.setText(diachi);
        textStatus.setText(trangthai);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        String id = textNhanVien.getText();
        String fullname = textHoTen.getText();
        String date = textDate.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String status = textStatus.getText();

        if (nvb.edit(id, fullname, date, phone, address, status)) {
            JOptionPane.showMessageDialog(tb, "Sửa thành công");
        }

        nvb.reset();

        nvb.loadData();
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        int selectedIndex = tb.getSelectedRow();
        if (selectedIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(tb, "Xoa nhan vien nay?");
            if (option == 0) {
                nvb.delete(selectedIndex);
                nvb.loadData();
                nvb.reset();
            }
        }
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        String input = textFind.getText();
        String selectedValue = (String) choose.getSelectedItem();
        if (input.trim().length() == 0) {
            NHANVIENBUS.dsnv = NHANVIENDAO.getInstance().selectAll();
        } else {
            if (selectedValue == "Tìm kiếm theo tên") {
                NHANVIENBUS.dsnv = NHANVIENDAO.getInstance().selectByName(input);
            }
            if (selectedValue == "Tìm kiếm theo mã") {
                NHANVIENBUS.dsnv = NHANVIENDAO.getInstance().selectByID(input);
            }
        }

        NHANVIENBUS.model.setRowCount(0);
        NHANVIENBUS.dsnv.forEach((nv) -> {
            NHANVIENBUS.model.addRow(new Object[]{nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getSdt(), nv.getDiaChi(), nv.getTrangThai()});
        });
    }
}
