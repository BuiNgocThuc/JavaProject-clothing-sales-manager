/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.NHACUNGCAP;

import Back_End.NHACUNGCAP.NHACUNGCAPBUS;
import Back_End.NHACUNGCAP.NHACUNGCAPDAO;
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

public class NHACUNGCAPGUI extends JPanel {

    NHACUNGCAPBUS nccb = new NHACUNGCAPBUS();

    private JPanel jp, jp1, jp2, jp3;
    private JLabel labelMaNCC, labelTenNCC, labelPhone, labelAddress, labelStatus;
    public static JTextField textMaNCC, textTenNCC, textPhone, textAddress, textStatus, textFind;
    private JButton addBtn, editBtn, deleteBtn, searchBtn, importBtn, exportBtn, pdfBtn, resetBtn;
    public static JTable tb;
    private JScrollPane jsp;
    private JComboBox choose;

    public NHACUNGCAPGUI() {
        init();

        nccb.loadData();

        nccb.showConsole();
    }

    private void init() {
        jp = new JPanel(new BorderLayout());

        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400, 550));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));

        labelMaNCC = new JLabel("Mã NCC: ");
        labelMaNCC.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelMaNCC);

        textMaNCC = new JTextField();
        textMaNCC.setPreferredSize(new Dimension(270, 30));
        jp1.add(textMaNCC);

        labelTenNCC = new JLabel("Tên NCC: ");
        labelTenNCC.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelTenNCC);

        textTenNCC = new JTextField();
        textTenNCC.setPreferredSize(new Dimension(270, 30));
        jp1.add(textTenNCC);

        labelPhone = new JLabel("Số điện thoại: ");
        labelPhone.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelPhone);

        textPhone = new JTextField();
        textPhone.setPreferredSize(new Dimension(270, 30));
        jp1.add(textPhone);

        labelAddress = new JLabel("Địa chỉ: ");
        labelAddress.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setPreferredSize(new Dimension(270, 30));
        jp1.add(textAddress);

        labelStatus = new JLabel("Trạng thái: ");
        labelStatus.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelStatus);

        textStatus = new JTextField();
        textStatus.setPreferredSize(new Dimension(270, 30));
        jp1.add(textStatus);

        addBtn = new JButton("Thêm");
        addBtn.setPreferredSize(new Dimension(120, 50));
        addBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-32.png")));
        jp1.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBtnActionPerformed(e);
            }
        });

        editBtn = new JButton("Sửa");
        editBtn.setPreferredSize(new Dimension(120, 50));
        editBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-tools-28.png")));
        jp1.add(editBtn);

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBtnActionPerformed(e);
            }
        });

        deleteBtn = new JButton("Xóa");
        deleteBtn.setPreferredSize(new Dimension(120, 50));
        deleteBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-remove-28.png")));
        jp1.add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBtnActionPerformed(e);
            }
        });

        importBtn = new JButton("Import");
        importBtn.setPreferredSize(new Dimension(120, 50));
        importBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        jp1.add(importBtn);

        exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(120, 50));
        exportBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        jp1.add(exportBtn);

        pdfBtn = new JButton("PDF");
        pdfBtn.setPreferredSize(new Dimension(120, 50));
        pdfBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));
        jp1.add(pdfBtn);

        jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp2.setPreferredSize(new Dimension(370, 100));
        jp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp2.setBorder(BorderFactory.createTitledBorder("Tìm kiếm "));

        textFind = new JTextField();
        textFind.setPreferredSize(new Dimension(350, 30));
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

        resetBtn = new JButton("Reset");
        resetBtn.setPreferredSize(new Dimension(120, 50));
        resetBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
        resetBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               resetBtnActionPerformed(e);
           }
        });
        jp1.add(jp2);
        jp1.add(resetBtn);

        jp3 = new JPanel(new BorderLayout());
        jp3.setPreferredSize(new Dimension(400, 550));
        jp3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp3.setBorder(BorderFactory.createTitledBorder("Danh sách nhà cung cấp"));
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
        jp3.add(jsp);

        jp.add(jp1, BorderLayout.WEST);
        jp.add(jp3, BorderLayout.CENTER);
        this.add(jp);
    }

    private void addBtnActionPerformed(ActionEvent e) {
       if (checkValue() == true){
            String id = textMaNCC.getText();
            String name = textTenNCC.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

            if (nccb.add(id, name, phone, address, status)== true) {
                JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

            nccb.reset();

            nccb.loadData();
       }
       else {
            JOptionPane.showMessageDialog(this, "Thêm không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
       }
    }

    private void tableMouseCliked(MouseEvent e) {
        int selectedRow = tb.getSelectedRow();
        String mancc = tb.getModel().getValueAt(selectedRow, 0).toString();
        String tenncc = tb.getModel().getValueAt(selectedRow, 1).toString();
        String sdt = tb.getModel().getValueAt(selectedRow, 2).toString();
        String diachi = tb.getModel().getValueAt(selectedRow, 3).toString();
        String trangthai = tb.getModel().getValueAt(selectedRow, 4).toString();
        textMaNCC.setText(mancc);
        textMaNCC.setEditable(false);
        textTenNCC.setText(tenncc);
        textPhone.setText(sdt);
        textAddress.setText(diachi);
        textStatus.setText(trangthai);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        if (checkValue() == true){
            String id = textMaNCC.getText();
            String name = textTenNCC.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

            if (nccb.edit(id, name, phone, address, status)== true) {
                JOptionPane.showMessageDialog(null, "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

            nccb.reset();

            nccb.loadData();
        }
        else {
            JOptionPane.showMessageDialog(this, "Sửa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
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
    
    public void resetBtnActionPerformed(ActionEvent e){
        nccb.reset();
        textMaNCC.setEditable(true);
        nccb.loadData();
    }
    
    private boolean checkValue() {
        if (textMaNCC.getText().isEmpty() || textTenNCC.getText().isEmpty() || textPhone.getText().isEmpty() || textAddress.getText().isEmpty() || textStatus.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regex = "^\\d{10}$";
        if (!textPhone.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng! (10 chữ số)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
