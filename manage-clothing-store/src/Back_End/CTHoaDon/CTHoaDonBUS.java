/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTHoaDon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Back_End.HOADON.HOADON;
import Back_End.HOADON.HOADONBUS;
import Back_End.HOADON.HOADONDAO;
import Front_End.HOADON.HOADONGUI;

/**
 *
 * @author NGOC THUC
 */
public class CTHoaDonBUS {

    static Locale locale = new Locale("en", "EN");
    static String pattern = "###,###.# VNĐ";
    static DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    public void showCTHD(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog dialog = new JDialog();
                dialog.setLayout(new BorderLayout());
                dialog.setTitle("Chi tiết hóa đơn");
                dialog.setModal(true);
                dialog.setResizable(false);
                dialog.setSize(new Dimension(700, 750));
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int w = d.width;
                int h = d.height;
                int x = (w - dialog.getSize().width) / 2;
                int y = (h - dialog.getSize().height) / 2;
                dialog.setLocation(x, y);

                JPanel pnl1 = new JPanel(null);
                pnl1.setPreferredSize(new Dimension(700, 200));

                JLabel lbl[] = new JLabel[12];
                String strName[] = {"Mã hóa đơn", "Khách hàng", "Nhân viên lập hóa đơn", "Ngày nhập", "Tổng tiền", "Khuyến mãi"};
                int k = 0;

                for (int i = 0; i < 12; i += 2) {
                    lbl[i] = new JLabel(strName[k++], JLabel.CENTER);
                    lbl[i].setFont(new Font(null, Font.BOLD, 13));
                    pnl1.add(lbl[i]);
                }
                lbl[0].setBounds(37, 5, 200, 25);
                lbl[2].setBounds(461, 5, 200, 25);
                lbl[4].setBounds(250, 5, 200, 25);
                lbl[6].setBounds(140, 70, 200, 25);
                lbl[8].setBounds(360, 70, 200, 25);
                lbl[10].setBounds(250, 135, 200, 25);

                k = 0;
                for (int i = 1; i < 10; i += 2) {
                    String str = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), k++));
                    lbl[i] = new JLabel(str, JLabel.CENTER);
                    lbl[i].setFont(new Font(null, Font.PLAIN, 14));
                    lbl[i].setBorder(BorderFactory.createLoweredBevelBorder());
                    pnl1.add(lbl[i]);
                }
                lbl[1].setBounds(37, 30, 200, 30);
                lbl[3].setBounds(461, 30, 200, 30);
                lbl[5].setBounds(250, 30, 200, 30);
                lbl[7].setBounds(140, 95, 200, 30);
                lbl[9].setBounds(360, 95, 200, 30);

                String str = HOADONBUS.getTenKM(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0)));
                lbl[11] = new JLabel(str, JLabel.CENTER);
                lbl[11].setFont(new Font(null, Font.PLAIN, 14));
                lbl[11].setBorder(BorderFactory.createLoweredBevelBorder());
                lbl[11].setBounds(150, 160, 400, 30);
                pnl1.add(lbl[11]);

                JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

                JButton btn1 = new JButton("Hủy HĐ");
                btn1.setPreferredSize(new Dimension(100, 30));
                btn1.setBackground(Color.WHITE);
                btn1.setMargin(new Insets(0, 0, 0, 0));
                btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-close-window-32.png")));
                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int output = JOptionPane.showConfirmDialog(dialog, "Bạn có chắc chắn muốn hủy hóa đơn này?", "Thông báo", JOptionPane.YES_NO_OPTION);
                        if (output == JOptionPane.YES_OPTION) {
                            ArrayList<HOADON> arrHD = new ArrayList<HOADON>();
                            arrHD = HOADONBUS.arrHD;
                            DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();
                            String maHD = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
                            for (HOADON hoadon : arrHD) {
                                if (hoadon.getMaHD().equals(maHD)) {
                                    HOADON hd = new HOADON(maHD, hoadon.getMaNV(), hoadon.getMaKM(), hoadon.getMaKH(), hoadon.getNgayNhap(), hoadon.getTongTien(), "Đã hủy");
                                    HOADONDAO.getInstance().update(hd);
                                    hoadon.setTinhTrang("Đã hủy");
                                    dtm.removeRow(tbl.getSelectedRow());
                                }
                            }
                            dialog.dispose();
                        }
                    }
                });

                JButton btn2 = new JButton("Xuất");
                btn2.setPreferredSize(new Dimension(100, 30));
                btn2.setBackground(Color.WHITE);
                btn2.setMargin(new Insets(0, 0, 0, 0));
                btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));

                JButton btn3 = new JButton("Xuất PDF");
                btn3.setPreferredSize(new Dimension(100, 30));
                btn3.setBackground(Color.WHITE);
                btn3.setMargin(new Insets(0, 0, 0, 0));
                btn3.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));

                JTable tbl1 = new JTable();
                DefaultTableModel dtm = new DefaultTableModel() {
                    /**
                     *
                     */
                    private static final long serialVersionUID = 1L;

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                dtm.addColumn("Sản phẩm");
                dtm.addColumn("Thương hiệu");
                dtm.addColumn("Size");
                dtm.addColumn("Màu sắc");
                dtm.addColumn("Đơn giá");
                dtm.addColumn("Số lượng");
                tbl1.setModel(dtm);
                tbl1.setAutoCreateRowSorter(true);
                tbl1.getTableHeader().setPreferredSize(new Dimension(1000, 40));
                tbl1.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
                tbl1.setRowHeight(30);
                tbl1.getColumnModel().getColumn(0).setPreferredWidth(100);
                tbl1.getColumnModel().getColumn(1).setPreferredWidth(100);
                tbl1.getColumnModel().getColumn(2).setPreferredWidth(50);
                tbl1.getColumnModel().getColumn(3).setPreferredWidth(50);
                tbl1.getColumnModel().getColumn(4).setPreferredWidth(100);
                tbl1.getColumnModel().getColumn(5).setPreferredWidth(50);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                tbl1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tbl1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tbl1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tbl1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tbl1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                tbl1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                tbl1.setBorder(BorderFactory.createRaisedBevelBorder());

                JScrollPane sp = new JScrollPane(tbl1);
                sp.setBorder(BorderFactory.createRaisedBevelBorder());

                String condition = "CTHD_MAHD = '" + String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0)) + "'";
                ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectByCondition(condition);

                dcf.applyPattern(pattern);
                dtm.setRowCount(0);
                for (CTHoaDon cthoadon : arrCTHD) {
                    dtm.addRow(new Object[]{CTHoaDonDAO.getInstance().selectTenSP(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenTH(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenSize(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenMau(cthoadon.getMaSP()), dcf.format(cthoadon.getDonGia()), cthoadon.getSoLuong()});
                }

                pnl2.add(btn1);
                pnl2.add(btn2);
                pnl2.add(btn3);

                dialog.add(pnl1, BorderLayout.NORTH);
                dialog.add(sp, BorderLayout.CENTER);
                dialog.add(pnl2, BorderLayout.SOUTH);
                dialog.setVisible(true);

                super.mouseClicked(e);
            }
        });
    }

    public static void showCTHDHuy(JTable tbl, JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                try {
                    dialog.setLayout(new BorderLayout());
                    dialog.setTitle("Chi tiết hóa đơn");
                    dialog.setModal(true);
                    dialog.setResizable(false);
                    dialog.setSize(new Dimension(700, 750));
                    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                    int w = d.width;
                    int h = d.height;
                    int x = (w - dialog.getSize().width) / 2;
                    int y = (h - dialog.getSize().height) / 2;
                    dialog.setLocation(x, y);

                    JPanel pnl1 = new JPanel(null);
                    pnl1.setPreferredSize(new Dimension(700, 200));

                    JLabel lbl[] = new JLabel[12];
                    String strName[] = {"Mã hóa đơn", "Khách hàng", "Nhân viên lập hóa đơn", "Ngày nhập", "Tổng tiền", "Khuyến mãi"};
                    int k = 0;

                    for (int i = 0; i < 12; i += 2) {
                        lbl[i] = new JLabel(strName[k++], JLabel.CENTER);
                        lbl[i].setFont(new Font(null, Font.BOLD, 13));
                        pnl1.add(lbl[i]);
                    }
                    lbl[0].setBounds(37, 5, 200, 25);
                    lbl[2].setBounds(461, 5, 200, 25);
                    lbl[4].setBounds(250, 5, 200, 25);
                    lbl[6].setBounds(140, 70, 200, 25);
                    lbl[8].setBounds(360, 70, 200, 25);
                    lbl[10].setBounds(250, 135, 200, 25);

                    k = 0;
                    for (int i = 1; i < 10; i += 2) {
                        String str = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), k++));
                        lbl[i] = new JLabel(str, JLabel.CENTER);
                        lbl[i].setFont(new Font(null, Font.PLAIN, 14));
                        lbl[i].setBorder(BorderFactory.createLoweredBevelBorder());
                        pnl1.add(lbl[i]);
                    }
                    lbl[1].setBounds(37, 30, 200, 30);
                    lbl[3].setBounds(461, 30, 200, 30);
                    lbl[5].setBounds(250, 30, 200, 30);
                    lbl[7].setBounds(140, 95, 200, 30);
                    lbl[9].setBounds(360, 95, 200, 30);

                    String str = HOADONBUS.getTenKM(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0)));
                    lbl[11] = new JLabel(str, JLabel.CENTER);
                    lbl[11].setFont(new Font(null, Font.PLAIN, 14));
                    lbl[11].setBorder(BorderFactory.createLoweredBevelBorder());
                    lbl[11].setBounds(150, 160, 400, 30);
                    pnl1.add(lbl[11]);

                    JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

                    JButton btn1 = new JButton("Xuất");
                    btn1.setPreferredSize(new Dimension(100, 30));
                    btn1.setBackground(Color.WHITE);
                    btn1.setMargin(new Insets(0, 0, 0, 0));
                    btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));

                    JButton btn2 = new JButton("Xuất PDF");
                    btn2.setPreferredSize(new Dimension(100, 30));
                    btn2.setBackground(Color.WHITE);
                    btn2.setMargin(new Insets(0, 0, 0, 0));
                    btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));

                    JTable tbl1 = new JTable();
                    DefaultTableModel dtm = new DefaultTableModel() {
                        /**
                         *
                         */
                        private static final long serialVersionUID = 1L;

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    dtm.addColumn("Sản phẩm");
                    dtm.addColumn("Thương hiệu");
                    dtm.addColumn("Size");
                    dtm.addColumn("Màu sắc");
                    dtm.addColumn("Đơn giá");
                    dtm.addColumn("Số lượng");
                    tbl1.setModel(dtm);
                    tbl1.setAutoCreateRowSorter(true);
                    tbl1.getTableHeader().setPreferredSize(new Dimension(1000, 40));
                    tbl1.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
                    tbl1.setRowHeight(30);
                    tbl1.getColumnModel().getColumn(0).setPreferredWidth(100);
                    tbl1.getColumnModel().getColumn(1).setPreferredWidth(100);
                    tbl1.getColumnModel().getColumn(2).setPreferredWidth(50);
                    tbl1.getColumnModel().getColumn(3).setPreferredWidth(50);
                    tbl1.getColumnModel().getColumn(4).setPreferredWidth(100);
                    tbl1.getColumnModel().getColumn(5).setPreferredWidth(50);
                    tbl1.setAlignmentX(20);
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    tbl1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    tbl1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                    tbl1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                    tbl1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    tbl1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                    tbl1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                    tbl1.setBorder(BorderFactory.createRaisedBevelBorder());

                    JScrollPane sp = new JScrollPane(tbl1);
                    sp.setBorder(BorderFactory.createRaisedBevelBorder());

                    String condition = "CTHD_MAHD = '" + String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0)) + "'";
                    ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectByCondition(condition);

                    dcf.applyPattern(pattern);
                    dtm.setRowCount(0);
                    for (CTHoaDon cthoadon : arrCTHD) {
                        dtm.addRow(new Object[]{CTHoaDonDAO.getInstance().selectTenSP(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenTH(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenSize(cthoadon.getMaSP()), CTHoaDonDAO.getInstance().selectTenMau(cthoadon.getMaSP()), dcf.format(cthoadon.getDonGia()), cthoadon.getSoLuong()});
                    }

                    pnl2.add(btn1);
                    pnl2.add(btn2);

                    dialog.add(pnl1, BorderLayout.NORTH);
                    dialog.add(sp, BorderLayout.CENTER);
                    dialog.add(pnl2, BorderLayout.SOUTH);
                    dialog.setVisible(true);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(dialog, "Vui lòng chọn hóa đơn cần xem chi tiết.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
