/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.NHACUNGCAP;

import Back_End.NHACUNGCAP.NHACUNGCAPBUS;
import Back_End.NHACUNGCAP.NHACUNGCAPDAO;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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

public class NHACUNGCAPGUI {

    NHACUNGCAPBUS nccb = new NHACUNGCAPBUS();

    private JPanel jp, jp1, jp2;
    private JLabel labelMaNCC, labelTenNCC, labelPhone, labelAddress, labelStatus;
    public static JTextField textMaNCC, textTenNCC, textPhone, textAddress, textStatus, textFind;
    private JButton addBtn, editBtn, deleteBtn, searchBtn, importBtn, exportBtn, pdfBtn;
    public static JTable tb;
    private JScrollPane jsp;
    private JComboBox choose;

    public NHACUNGCAPGUI(JFrame f) {
        init(f);

        nccb.loadData();

        nccb.showConsole();
    }

    private void init(JFrame f) {
        jp = new JPanel();

        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400, 480));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin"));

        labelMaNCC = new JLabel("Mã nhà cung cấp: ");
        labelMaNCC.setBounds(10, 10, 50, 30);
        jp1.add(labelMaNCC);

        textMaNCC = new JTextField(33);

        jp1.add(textMaNCC);

        labelTenNCC = new JLabel("Tên nhà cung cấp: ");
        labelTenNCC.setBounds(10, 70, 50, 30);
        jp1.add(labelTenNCC);

        textTenNCC = new JTextField(33);
        jp1.add(textTenNCC);

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
        jp1.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBtnActionPerformed(e);
            }
        });

        editBtn = new JButton("Sửa");
        editBtn.setPreferredSize(new Dimension(70, 30));
        jp1.add(editBtn);

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBtnActionPerformed(e);
            }
        });

        deleteBtn = new JButton("Xóa");
        deleteBtn.setPreferredSize(new Dimension(70, 30));
        jp1.add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBtnActionPerformed(e);
            }
        });

        importBtn = new JButton("Import");
        importBtn.setPreferredSize(new Dimension(70, 30));
        jp1.add(importBtn);

        exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(70, 30));
        jp1.add(exportBtn);

        pdfBtn = new JButton("PDF");
        pdfBtn.setPreferredSize(new Dimension(70, 30));
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
                    "Mã NCC", "Tên NCC", "Số điện thoại", "Địa chỉ", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
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

        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.SOUTH);
        f.add(jp);
    }

    private void addBtnActionPerformed(ActionEvent e) {
        String id = textMaNCC.getText();
        String name = textTenNCC.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String status = textStatus.getText();

        if (nccb.add(id, name, phone, address, status)) {
            JOptionPane.showMessageDialog(tb, "Thêm thành công");
        }

        nccb.reset();

        nccb.loadData();
    }

    private void tableMouseCliked(MouseEvent e) {
        int selectedRow = tb.getSelectedRow();
        String mancc = tb.getModel().getValueAt(selectedRow, 0).toString();
        String tenncc = tb.getModel().getValueAt(selectedRow, 1).toString();
        String sdt = tb.getModel().getValueAt(selectedRow, 2).toString();
        String diachi = tb.getModel().getValueAt(selectedRow, 3).toString();
        String trangthai = tb.getModel().getValueAt(selectedRow, 4).toString();
        textMaNCC.setText(mancc);
        textTenNCC.setText(tenncc);
        textPhone.setText(sdt);
        textAddress.setText(diachi);
        textStatus.setText(trangthai);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        String id = textMaNCC.getText();
        String name = textTenNCC.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String status = textStatus.getText();
        
        if (nccb.edit(id, name, phone, address, status)) {
            JOptionPane.showMessageDialog(tb, "Sửa thành công");
        }

        nccb.reset();

        nccb.loadData();
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        int selectedIndex = tb.getSelectedRow();
        if (selectedIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(tb, "Xóa nhà cung cấp này?");
            if (option == 0) {
                nccb.delete(selectedIndex);
                nccb.loadData();
                nccb.reset();
            }
        }
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        String input = textFind.getText();
        String selectedValue = (String) choose.getSelectedItem();
        if (input.trim().length() == 0) {
            NHACUNGCAPBUS.dsncc = NHACUNGCAPDAO.getInstance().selectAll();
        } else {
            if (selectedValue == "Tìm kiếm theo tên") {
                NHACUNGCAPBUS.dsncc = NHACUNGCAPDAO.getInstance().selectByName(input);
            }
            if (selectedValue == "Tìm kiếm theo mã") {
                NHACUNGCAPBUS.dsncc = NHACUNGCAPDAO.getInstance().selectByID(input);
            }
        }

        NHACUNGCAPBUS.model.setRowCount(0);
        NHACUNGCAPBUS.dsncc.forEach((ncc) -> {
            NHACUNGCAPBUS.model.addRow(new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(), ncc.getDiaChi(), ncc.getTrangThai()});
        });
        
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1200, 600);
        new NHACUNGCAPGUI(f);
        f.setVisible(true);
    }
}
