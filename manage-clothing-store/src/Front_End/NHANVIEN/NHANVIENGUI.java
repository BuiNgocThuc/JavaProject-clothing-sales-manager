/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.NHANVIEN;

import Back_End.NHANVIEN.NHANVIENBUS;
import Back_End.NHANVIEN.NHANVIENDAO;
import Import_Export.IOExcel;
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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class NHANVIENGUI extends JPanel {

    NHANVIENBUS nvb = new NHANVIENBUS();

    private JPanel jp, jp1, jp2, jp3;
    private JLabel labelNhanVien, labelHoTen, labelDate, labelPhone, labelAddress, labelStatus;
    public static JTextField textNhanVien, textHoTen, textDate, textPhone, textAddress, textStatus, textFind;
    private JButton addBtn, editBtn, deleteBtn, searchBtn, importBtn, exportBtn, resetBtn;
    public static JTable tb;
    private JScrollPane jsp;
    private JComboBox choose;

    public NHANVIENGUI() {
        init();

        nvb.loadData();

    }

    private void init() {
        jp = new JPanel(new BorderLayout());
        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400, 550));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

        labelNhanVien = new JLabel("Mã nhân viên: ");
        labelNhanVien.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelNhanVien);

        textNhanVien = new JTextField();
        textNhanVien.setPreferredSize(new Dimension(270, 30));
        jp1.add(textNhanVien);

        labelHoTen = new JLabel("Họ và tên: ");
        labelHoTen.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelHoTen);

        textHoTen = new JTextField();
        textHoTen.setPreferredSize(new Dimension(270, 30));
        jp1.add(textHoTen);

        labelDate = new JLabel("Ngày sinh: ");
        labelDate.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelDate);

        textDate = new JTextField();
        textDate.setPreferredSize(new Dimension(270, 30));
        jp1.add(textDate);

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
        importBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<ArrayList<Object>> data = null;
                try {
                    data = IOExcel.readExcel(0);
                } catch (IOException ex) {
                    Logger.getLogger(NHANVIENGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(NHANVIENGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                nvb.insertDTO(data);
            }
        });
        jp1.add(importBtn);

        exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(120, 50));
        exportBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IOExcel.writeExcel(tb, "Danh Sách Nhân Viên", "DSNV");
            }
        });
        jp1.add(exportBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setPreferredSize(new Dimension(120, 50));
        resetBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
        resetBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               resetBtnActionPerformed(e);
           }
        });
        jp1.add(resetBtn);

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
        
        jp1.add(jp2);
        
        jp3 = new JPanel(new BorderLayout());
        jp3.setPreferredSize(new Dimension(400, 550));
        jp3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp3.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
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
        jp3.add(jsp);

        jp.add(jp1, BorderLayout.WEST);
        jp.add(jp3, BorderLayout.CENTER);
        this.add(jp);
    }

    private void addBtnActionPerformed(ActionEvent e) {
        if (checkValue() == true){
            String id = textNhanVien.getText();
            String fullname = textHoTen.getText();
            String date = textDate.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

//        NHANVIEN nv = new NHANVIEN(id, fullname, date, phone, address, status);
//
//        NHANVIENDAO.getInstance().insert(nv);
            if (nvb.add(id, fullname, date, phone, address, status)== true) {
                JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

            nvb.reset();

            nvb.loadData();
        }
        else {
            JOptionPane.showMessageDialog(null, "Thêm không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
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
        textNhanVien.setEditable(false);
        textHoTen.setText(tennv);
        textDate.setText(ngaysinh);
        textPhone.setText(sdt);
        textAddress.setText(diachi);
        textStatus.setText(trangthai);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        if (checkValue() == true){
            String id = textNhanVien.getText();
            String fullname = textHoTen.getText();
            String date = textDate.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

            if (nvb.edit(id, fullname, date, phone, address, status) == true) {
                JOptionPane.showMessageDialog(null, "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

            nvb.reset();

            nvb.loadData();
        }
        else {
            JOptionPane.showMessageDialog(null, "Sửa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        int selectedIndex = tb.getSelectedRow();
        if (selectedIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(tb, "Xóa nhân viên này?");
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
    
    public void resetBtnActionPerformed(ActionEvent e){
        nvb.reset();
        textNhanVien.setEditable(true);
        nvb.loadData();
    }
    
    private boolean checkValue() {
        if (textNhanVien.getText().isEmpty() || textHoTen.getText().isEmpty() || textPhone.getText().isEmpty() || textAddress.getText().isEmpty() || textStatus.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(textDate.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày sinh không đúng! (yyyy-MM-dd)", "Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regex = "^\\d{10}$";
        if (!textPhone.getText().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng! (10 chữ số)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    } 
}
