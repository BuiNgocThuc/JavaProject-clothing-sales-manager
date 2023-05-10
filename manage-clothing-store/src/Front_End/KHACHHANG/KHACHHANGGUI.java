/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.KHACHHANG;

import Back_End.KHACHHANG.KHACHHANGBUS;
import Back_End.KHACHHANG.KHACHHANGDAO;
import Front_End.NHACUNGCAP.NHACUNGCAPGUI;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class KHACHHANGGUI extends JPanel {

    KHACHHANGBUS khb = new KHACHHANGBUS();

    private JPanel jp, jp1, jp2, jp3;
    private JLabel labelMaKH, labelHoTen, labelPhone, labelAddress, labelStatus;
    public static JTextField textMaKH, textHoTen, textPhone, textAddress, textStatus, textFind;
    private JButton addBtn, editBtn, deleteBtn, searchBtn, importBtn, exportBtn, resetBtn;
    public static JTable tb;
    private JScrollPane jsp;
    private JComboBox choose;

    public KHACHHANGGUI() {
        init();

        khb.loadData();

    }

    private void init() {
        jp = new JPanel(new BorderLayout());
        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400, 550));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

        labelMaKH = new JLabel("Mã khách hàng: ");
        labelMaKH.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelMaKH);

        textMaKH = new JTextField();
        textMaKH.setPreferredSize(new Dimension(270, 30));
        jp1.add(textMaKH);

        labelHoTen = new JLabel("Họ và tên: ");
        labelHoTen.setPreferredSize(new Dimension(100, 30));
        jp1.add(labelHoTen);

        textHoTen = new JTextField();
        textHoTen.setPreferredSize(new Dimension(270, 30));
        jp1.add(textHoTen);

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
            public void actionPerformed(ActionEvent e) {
               ArrayList<ArrayList<Object>> data = null;
                try {
                    data = IOExcel.readExcel(0);
                } catch (IOException ex) {
                    Logger.getLogger(KHACHHANGGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(KHACHHANGGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                khb.insertDTO(data);
            }
        });
        jp1.add(importBtn);

        exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(120, 50));
        exportBtn.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IOExcel.writeExcel(tb, "Danh Sách Khách Hàng", "DSKH");
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
        jp2.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));

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
        jp3.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
        tb = new JTable();
        tb.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã KH", "Họ tên KH", "Số điện thoại", "Địa chỉ", "Trạng thái"
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
        if (checkValue() == true) {
            String id = textMaKH.getText();
            String fullname = textHoTen.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

            if (khb.add(id, fullname, phone, address, status) == true) {
                JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
            khb.reset();
            khb.loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tableMouseCliked(MouseEvent e) {
        int selectedRow = tb.getSelectedRow();
        String makh = tb.getModel().getValueAt(selectedRow, 0).toString();
        String tenkh = tb.getModel().getValueAt(selectedRow, 1).toString();
        String sdt = tb.getModel().getValueAt(selectedRow, 2).toString();
        String diachi = tb.getModel().getValueAt(selectedRow, 3).toString();
        String trangthai = tb.getModel().getValueAt(selectedRow, 4).toString();
        textMaKH.setText(makh);
        textMaKH.setEditable(false);
        textHoTen.setText(tenkh);
        textPhone.setText(sdt);
        textAddress.setText(diachi);
        textStatus.setText(trangthai);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        if (checkValue() == true) {
            String id = textMaKH.getText();
            String fullname = textHoTen.getText();
            String phone = textPhone.getText();
            String address = textAddress.getText();
            String status = textStatus.getText();

            if (khb.edit(id, fullname, phone, address, status) == true) {
                JOptionPane.showMessageDialog(null, "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

            khb.reset();

            khb.loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBtnActionPerformed(ActionEvent e) {
        int selectedIndex = tb.getSelectedRow();
        if (selectedIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(tb, "Xóa khách hàng này?");
            if (option == 0) {
                khb.delete(selectedIndex);
                khb.loadData();
                khb.reset();
            }
        }
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        String input = textFind.getText();
        String selectedValue = (String) choose.getSelectedItem();
        if (input.trim().length() == 0) {
            KHACHHANGBUS.dskh = KHACHHANGDAO.getInstance().selectAll();
        } else {
            if (selectedValue == "Tìm kiếm theo tên") {
                KHACHHANGBUS.dskh = KHACHHANGDAO.getInstance().selectByName(input);
            }
            if (selectedValue == "Tìm kiếm theo mã") {
                KHACHHANGBUS.dskh = KHACHHANGDAO.getInstance().selectByID(input);
            }
        }

        KHACHHANGBUS.model.setRowCount(0);
        KHACHHANGBUS.dskh.forEach((kh) -> {
            KHACHHANGBUS.model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getTrangThai()});
        });
    }
    
    public void resetBtnActionPerformed(ActionEvent e){
        khb.reset();
        textMaKH.setEditable(true);
        khb.loadData();
    }

    private boolean checkValue() {
        if (textMaKH.getText().isEmpty() || textHoTen.getText().isEmpty() || textPhone.getText().isEmpty() || textAddress.getText().isEmpty() || textStatus.getText().isEmpty()) {
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
