/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.NHAPHANG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Back_End.CTPhieuNhap.CTPhieuNhap;
import Back_End.CTPhieuNhap.CTPhieuNhapBUS;
import Back_End.CTPhieuNhap.CTPhieuNhapDAO;
import Back_End.PHIEUNHAP.PHIEUNHAP;
import Back_End.PHIEUNHAP.PHIEUNHAPBUS;
import Back_End.PHIEUNHAP.PHIEUNHAPDAO;
import Back_End.SANPHAM.SANPHAMBUS;
import Back_End.TAIKHOAN.TAIKHOANBUS;
import Front_End.SANPHAM.SANPHAMGUI;

public class NHAPHANGGUI extends JPanel {

    String curentUser = TAIKHOANBUS.tenTK;
    JPanel panelCenter = new JPanel();
    JPanel panelRight = new JPanel();
    JPanel inforSP = new JPanel();
    JPanel panelPhieuNhap = new JPanel();
    JPanel panelChucNang = new JPanel();

    JTable tableSP = new JTable();
    DefaultTableModel model1 = new DefaultTableModel();
    JTable tableNhapHang = new JTable();
    DefaultTableModel model2 = new DefaultTableModel();

    JPanel panelMaSP = new JPanel();
    JLabel labelMaSP = new JLabel("", JLabel.CENTER);
    JPanel panelTenTH = new JPanel();
    JLabel labelTenTH = new JLabel("", JLabel.CENTER);
    JPanel panelTenSP = new JPanel();
    JLabel labelTenSP = new JLabel("", JLabel.CENTER);
    JPanel panelSize = new JPanel();
    JLabel labelSize = new JLabel("", JLabel.CENTER);
    JPanel panelMau = new JPanel();
    JLabel labelMau = new JLabel("", JLabel.CENTER);
    JPanel panelSoLuong = new JPanel();
    JTextField txtSoLuong = new JTextField(10);
    JPanel panelGiaNhap = new JPanel();
    JTextField txtGiaNhap = new JTextField(10);

    JButton btnThem = new JButton("Thêm");
    JButton btnXoa = new JButton("Xóa");
    JButton btnSua = new JButton("Sửa");
    JButton btnNhapHang = new JButton("Nhập hàng");
    JButton btnLamMoi = new JButton("Làm mới");

    // Phiếu nhập
    JPanel panelMaPN = new JPanel();
    JLabel labelMaPN = new JLabel("", JLabel.CENTER);
    JPanel panelMaNCC = new JPanel();
    JTextField txtMaNCC = new JTextField(10);
    JButton btnMoreNCC = new JButton();
    JLabel labelNgayNhap = new JLabel("Ngày nhập", JLabel.CENTER);
    JDateChooser txtNgayNhap = new JDateChooser();
    JPanel panelTongTien = new JPanel();
    JLabel labelTongTien = new JLabel("", JLabel.CENTER);
    JPanel panelNhanVien = new JPanel();
    JTextField txtNhanVien = new JTextField(10);
    JButton btnChonNhanVien = new JButton();

    Float giaNhap;

    SANPHAMBUS spb = new SANPHAMBUS();
    PHIEUNHAPBUS pnb = new PHIEUNHAPBUS();
    CTPhieuNhapBUS ctpnb = new CTPhieuNhapBUS();

    Locale locale = new Locale("en", "EN");
    String pattern = "### ###.###";
    DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    public NHAPHANGGUI() {
        init();
        txtNhanVien.setText(curentUser);
    }

    public void init() {
        this.setLayout(new BorderLayout());

        // Table sản phẩm
        panelCenter.setLayout(new BorderLayout());
        String columnName[] = {"Mã SP", "Tên TH", "Tên SP", "Size", "Màu sắc", "Giá Nhập", "Giá bán"};
        for (int i = 0; i < columnName.length; i++) {
            model1.addColumn(columnName[i]);
        }
        tableSP.setModel(model1);
        tableSP.getColumnModel().getColumn(3).setPreferredWidth(32);
        tableSP.getColumnModel().getColumn(4).setPreferredWidth(32);
        spb.loadDataFormNhapHang(tableSP);
        JScrollPane scrollPane1 = new JScrollPane(tableSP);
        panelCenter.add(scrollPane1, BorderLayout.CENTER);

        // Thông tin sản phẩm
        Border border = BorderFactory.createLineBorder(Color.black);
        inforSP.setLayout(new FlowLayout(20, 20, FlowLayout.CENTER));
        inforSP.setPreferredSize(new Dimension(panelCenter.getWidth(), 200));
        //--Mã SP
        panelMaSP.setBorder(BorderFactory.createTitledBorder(border, "Mã SP", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelMaSP.setPreferredSize(new Dimension(79, 25));
        panelMaSP.add(labelMaSP);
        inforSP.add(panelMaSP);

        // --Tên SP
        panelTenSP.setBorder(BorderFactory.createTitledBorder(border, "Tên SP", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelTenSP.setPreferredSize(new Dimension(79, 25));
        panelTenSP.add(labelTenSP);
        inforSP.add(panelTenSP);

        // --Tên TH
        panelTenTH.setBorder(BorderFactory.createTitledBorder(border, "Tên TH", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelTenTH.setPreferredSize(new Dimension(79, 25));
        panelTenTH.add(labelTenTH);
        inforSP.add(panelTenTH);

        // --Size
        panelSize.setBorder(BorderFactory.createTitledBorder(border, "Size", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelSize.setPreferredSize(new Dimension(30, 25));
        panelSize.add(labelSize);
        inforSP.add(panelSize);

        // --Màu
        panelMau.setBorder(BorderFactory.createTitledBorder(border, "Màu sắc", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelMau.setPreferredSize(new Dimension(55, 25));
        panelMau.add(labelMau);
        inforSP.add(panelMau);

        // --Giá nhập
        panelGiaNhap.setBorder(BorderFactory.createTitledBorder(border, "Giá nhập", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelGiaNhap.add(txtGiaNhap);
        inforSP.add(panelGiaNhap);

        // --Số lượng
        panelSoLuong.setBorder(BorderFactory.createTitledBorder(border, "Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelSoLuong.add(txtSoLuong);
        inforSP.add(panelSoLuong);

        // --button thêm
        btnThem.setPreferredSize(new Dimension(72, 36));
        btnThem.setBackground(Color.white);
        btnThem.setBorder(border);
        btnThem.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-28.png")));
        inforSP.add(btnThem);
        panelCenter.add(inforSP, BorderLayout.SOUTH);

        this.add(panelCenter, BorderLayout.CENTER);

        // Phiếu nhập
        panelRight.setLayout(new BorderLayout(0, 10));
        panelRight.setPreferredSize(new Dimension(400, 600));
        panelPhieuNhap.setLayout(new FlowLayout(10, 10, FlowLayout.LEADING));
        panelPhieuNhap.setPreferredSize(new Dimension(panelRight.getWidth(), 200));
        panelPhieuNhap.setBorder(border);

        panelMaPN.setBorder(BorderFactory.createTitledBorder(null, "Mã PN", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
        labelMaPN.setPreferredSize(new Dimension(150, 25));
        labelMaPN.setText(pnb.autoID());
        panelMaPN.add(labelMaPN);
        panelPhieuNhap.add(panelMaPN);

        panelMaNCC.setBorder(BorderFactory.createTitledBorder(null, "Mã NCC", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
        panelMaNCC.setPreferredSize(new Dimension(175, 55));
        btnMoreNCC.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_more_20px.png")));
        btnMoreNCC.setBackground(Color.white);
        btnMoreNCC.setPreferredSize(new Dimension(22, 22));
        panelMaNCC.add(txtMaNCC);
        panelMaNCC.add(btnMoreNCC);
        panelPhieuNhap.add(panelMaNCC);

        txtNgayNhap.setDateFormatString("yyyy-MM-dd");
        txtNgayNhap.setPreferredSize(new Dimension(100, 30));
        panelPhieuNhap.add(labelNgayNhap);
        panelPhieuNhap.add(txtNgayNhap);

        panelNhanVien.setBorder(BorderFactory.createTitledBorder(null, "Nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
        panelNhanVien.setPreferredSize(new Dimension(175, 55));
        btnChonNhanVien.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_more_20px.png")));
        btnChonNhanVien.setBackground(Color.white);
        btnChonNhanVien.setPreferredSize(new Dimension(22, 22));
        panelNhanVien.add(txtNhanVien);
        panelNhanVien.add(btnChonNhanVien);
        panelPhieuNhap.add(panelNhanVien);

        panelTongTien.setBorder(BorderFactory.createTitledBorder(null, "Tổng tiền", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
        labelTongTien.setPreferredSize(new Dimension(150, 25));
        panelTongTien.add(labelTongTien);
        panelPhieuNhap.add(panelTongTien);
        panelRight.add(panelPhieuNhap, BorderLayout.NORTH);

        // Table nhập hàng
        String column[] = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        for (int i = 0; i < column.length; i++) {
            model2.addColumn(column[i]);
        }
        tableNhapHang.setModel(model2);
        JScrollPane scrollPane2 = new JScrollPane(tableNhapHang);
        panelRight.add(scrollPane2, BorderLayout.CENTER);

        // panel chức năng
        panelChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelChucNang.setBorder(border);
        panelChucNang.setPreferredSize(new Dimension(panelPhieuNhap.getWidth(), 100));
        btnXoa.setBackground(Color.white);
        btnXoa.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-remove-28.png")));
        btnXoa.setPreferredSize(new Dimension(90, 30));
        btnSua.setBackground(Color.white);
        btnSua.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-edit-30.png")));
        btnSua.setPreferredSize(new Dimension(100, 30));
        btnNhapHang.setBackground(Color.white);
        btnNhapHang.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
        btnNhapHang.setPreferredSize(new Dimension(140, 30));
        btnLamMoi.setBackground(Color.white);
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
        btnLamMoi.setPreferredSize(new Dimension(140, 30));

        panelChucNang.add(btnXoa);
        panelChucNang.add(btnSua);
        panelChucNang.add(btnNhapHang);
        panelChucNang.add(btnLamMoi);
        panelRight.add(panelChucNang, BorderLayout.SOUTH);
        this.add(panelRight, BorderLayout.EAST);

        // Xử lý sự kiện
        tableSP.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickTableSP();

            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClickBtnThem();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClickbtnXoa();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClickbtnSua();
            }
        });

        btnNhapHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClickBtnNhapHang();
            }
        });

        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClickBtnLamMoi();
            }
        });

        btnChonNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormChonNhanVien aChonNhanVien = new FormChonNhanVien(txtNhanVien);
            }
        });

        btnMoreNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormChonNCC aChonNCC = new FormChonNCC(txtMaNCC);
            }
        });
    }

    public void mouseClickTableSP() {
        txtGiaNhap.setText("");
        txtSoLuong.setText("");
        int row = tableSP.getSelectedRow();
        labelMaSP.setText(String.valueOf(tableSP.getValueAt(row, 0)));
        labelTenTH.setText(String.valueOf(tableSP.getValueAt(row, 1)));
        labelTenSP.setText(String.valueOf(tableSP.getValueAt(row, 2)));
        labelSize.setText(String.valueOf(tableSP.getValueAt(row, 3)));
        labelMau.setText(String.valueOf(tableSP.getValueAt(row, 4)));
        giaNhap = Float.parseFloat(String.valueOf(tableSP.getValueAt(row, 5)));
    }

    public void mouseClickBtnThem() {
        int row = -1;
        row = tableSP.getSelectedRow();
        if (row >= 0) {
            Float tongTien;
            if (checkInput() == true) {
                loadDataToTableNhapHang();
                int lenght = model2.getRowCount();
                tongTien = Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(0, 4)));
                for (int i = 1; i < lenght; i++) {
                    tongTien = tongTien + Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(i, 4)));
                }
                dcf.applyPattern(pattern);
                String value = dcf.format(tongTien);
                labelTongTien.setText(value);
                labelMaSP.setText("");
                labelTenSP.setText("");
                labelTenTH.setText("");
                labelMau.setText("");
                labelSize.setText("");
                txtGiaNhap.setText("");
                txtSoLuong.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mouseClickbtnXoa() {
        int row = -1;
        row = tableNhapHang.getSelectedRow();
        if (row >= 0) {
            Float tongTien;
            model2.removeRow(row);
            int lenght = model2.getRowCount();
            tongTien = Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(0, 4)));
            for (int i = 1; i < lenght; i++) {
                tongTien = tongTien + Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(i, 4)));
            }
            dcf.applyPattern(pattern);
            String value = dcf.format(tongTien);
            labelTongTien.setText(value);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mouseClickbtnSua() {
        int row = -1;
        row = tableNhapHang.getSelectedRow();
        if (row >= 0) {
            boolean check = false;
            while (check == false) {
                String soLuongStr = JOptionPane.showInputDialog(this, "Nhập số lượng", "Sửa thông tin", JOptionPane.PLAIN_MESSAGE);
                try {
                    int soLuong = Integer.parseInt(soLuongStr);
                    check = true;
                    String maSP = String.valueOf(tableNhapHang.getValueAt(row, 0));
                    String tenSP = String.valueOf(tableNhapHang.getValueAt(row, 1));
                    String giaNhap = String.valueOf(tableNhapHang.getValueAt(row, 3));
                    String soLuongString = String.valueOf(soLuong);
                    String thanhTien = String.valueOf(soLuong * Float.parseFloat(giaNhap));

                    model2.removeRow(row);
                    model2.insertRow(row, new Object[]{maSP, tenSP, soLuongStr, giaNhap, thanhTien});

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ(Phải là số nguyên)", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
            float tongTien;
            int lenght = model2.getRowCount();
            tongTien = Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(0, 4)));
            for (int i = 1; i < lenght; i++) {
                tongTien = tongTien + Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(i, 4)));
            }
            dcf.applyPattern(pattern);
            String value = dcf.format(tongTien);
            labelTongTien.setText(value);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mouseClickBtnNhapHang() {
        if (tableNhapHang.getRowCount() != 0) {
            Float tongTien;
            if (checkInput2() == true) {
//				loadDataToTableNhapHang();
                int lenght = model2.getRowCount();
                tongTien = Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(0, 4)));
                for (int i = 1; i < lenght; i++) {
                    tongTien = tongTien + Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(i, 4)));
                }
                dcf.applyPattern(pattern);
                String value = dcf.format(tongTien);
                labelTongTien.setText(value);
                labelMaSP.setText("");
                labelTenSP.setText("");
                labelTenTH.setText("");
                labelMau.setText("");
                labelSize.setText("");
                txtGiaNhap.setText("");
                txtSoLuong.setText("");
                String maPN = labelMaPN.getText();
                String ma[] = txtNhanVien.getText().split("-");
                String maNV = ma[0];
                String maNCC = txtMaNCC.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String ngayNhap = sdf.format(txtNgayNhap.getDate());
                Float tongTienStr = Float.parseFloat(labelTongTien.getText());
                PHIEUNHAP pn = new PHIEUNHAP(maPN, maNV, maNCC, ngayNhap, tongTienStr);
                PHIEUNHAPDAO.getInstance().insert(pn);

                for (int i = 0; i < tableNhapHang.getRowCount(); i++) {
                    String maSP = String.valueOf(tableNhapHang.getValueAt(i, 0));
                    Float donGia = Float.parseFloat(String.valueOf(tableNhapHang.getValueAt(i, 3)));
                    Integer soLuong = Integer.parseInt(String.valueOf(tableNhapHang.getValueAt(i, 2)));
                    CTPhieuNhap ctpn = new CTPhieuNhap(maPN, maSP, donGia, soLuong);
                    CTPhieuNhapDAO.getInstance().insert(ctpn);
                    spb.updateGiaBan_SoLuong(maSP, soLuong);
                }

                JOptionPane.showMessageDialog(this, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bảng nhập hàng trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mouseClickBtnLamMoi() {
        labelMaPN.setText(pnb.autoID());
        txtMaNCC.setText("");
        txtNgayNhap.setDate(null);
        txtNhanVien.setText("");
        labelTongTien.setText("");
        for (int i = 0; i < model2.getRowCount(); i++) {
            model2.removeRow(i);
        }
        spb.loadDataFormNhapHang(tableSP);
    }

    public void loadDataToTableNhapHang() {
        String maSP = labelMaSP.getText();
        String tenSP = labelTenSP.getText();
        String soLuong = txtSoLuong.getText();
        String giaNhap = txtGiaNhap.getText();
        Float thanhTien = Float.parseFloat(soLuong) * Float.parseFloat(giaNhap);
        dcf.applyPattern(pattern);
        String value = dcf.format(thanhTien);

        model2.addRow(new Object[]{maSP, tenSP, soLuong, giaNhap, value});

    }

    public boolean checkInput() {
        if (txtGiaNhap.getText().trim().equals("")) {
            return showErr(txtGiaNhap, "Giá nhập không được để trống");
        }

        if (txtSoLuong.getText().trim().equals("")) {
            return showErr(txtSoLuong, "Số lượng không được để trống");
        } else {
            try {
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                if (soLuong == 0) {
                    return showErr(txtSoLuong, "Số lượng phải khác 0");
                } else if (soLuong < 0) {
                    return showErr(txtSoLuong, "Số lượng phải là số dương");
                }
            } catch (Exception e) {
                return showErr(txtSoLuong, "Số lượng phải là số nguyên");
            }

        }

        String giaNhapStr = txtGiaNhap.getText();
        try {
            Float giaNhap2 = Float.parseFloat(giaNhapStr);
            if (giaNhap2 == 0) {
                return showErr(txtGiaNhap, "Giá nhập phải khác 0");
            } else if (giaNhap2 < 0) {
                return showErr(txtGiaNhap, "Giá nhập phải là số dương");
            }
            else {
            	 spb.updateGiaNhap(labelMaSP.getText(), giaNhap2);
            }
            if (giaNhap2 - giaNhap > 0) {
                int choose = JOptionPane.showConfirmDialog(this, "Giá nhập mới cao hơn giá nhập cũ(Bạn có muốn thay đổi giá bán?)", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                if (choose == 0) {
                    Boolean check = false;
                    while (check == false) {
                        String giaBanString = JOptionPane.showInputDialog(this, "Nhập giá bán(triệu đồng)", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                        try {
                            Float giaFloat = Float.parseFloat(giaBanString);
                            check = true;
                            JOptionPane.showConfirmDialog(this, "Giá bán đã được thay đổi", "Thông báo", JOptionPane.OK_OPTION);
                            spb.updateGiaBan(labelMaSP.getText(), giaFloat);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            } else if (giaNhap2 - giaNhap < 0) {
                int choose = JOptionPane.showConfirmDialog(this, "Giá nhập mới thấp hơn giá nhập cũ(Bạn có muốn thay đổi giá bán?)", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                if (choose == 0) {
                    Boolean check = false;
                    while (check == false) {
                        String giaBanString = JOptionPane.showInputDialog(this, "Nhập giá bán(triệu đồng)", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                        try {
                            Float giaFloat = Float.parseFloat(giaBanString);
                            check = true;
                            JOptionPane.showConfirmDialog(this, "Giá bán đã được thay đổi", "Thông báo", JOptionPane.OK_OPTION);
                            spb.updateGiaBan(labelMaSP.getText(), giaFloat);
                            spb.updateGiaNhap(labelMaSP.getText(), giaNhap2);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        } catch (NumberFormatException e) {
            return showErr(txtGiaNhap, "Giá nhập không hợp lệ(Phải là số thực)");
        }

        return true;
    }

    public boolean checkInput2() {
        if (txtMaNCC.getText().trim().equals("")) {
            showErr(txtMaNCC, "Mã nhà cung cấp không được để trống");
        } else if (txtNgayNhap.getDate() == null) {
            showErr(txtMaNCC, "Ngày nhập không được để trống");
        } else if (txtNhanVien.getText().trim().equals("")) {
            showErr(txtNhanVien, "Mã nhân viên không được để trống");
        }
        return true;
    }

    private Boolean showErr(JTextField tf, String error) {
        JOptionPane.showMessageDialog(tf, error);
        tf.requestFocus();
        return false;
    }

}
