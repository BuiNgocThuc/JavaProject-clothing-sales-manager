/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.KHUYENMAI;

import Back_End.KHUYENMAI.KHUYENMAIBUS;
import Back_End.KHUYENMAI.KHUYENMAI;
import static Back_End.KHUYENMAI.KHUYENMAIBUS.dskm;
import Import_Export.IOExcel;
import Import_Export.writePDF;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author NGOC THUC
 */
public class KHUYENMAIGUI extends JPanel implements MouseListener {

    JPanel pnTool = new JPanel();
    JScrollPane spnList = new JScrollPane();
   static JTable tblList = new JTable();

    JLabel lblAdd = new JLabel("Thêm", JLabel.CENTER);
    JLabel lblRemove = new JLabel("Xóa", JLabel.CENTER);
    JLabel lblFix = new JLabel("Sửa", JLabel.CENTER);
    JLabel lblImport = new JLabel("Nhập Excel", JLabel.CENTER);
    JLabel lblExport = new JLabel("Xuất Excel", JLabel.CENTER);
    JLabel lblPDF = new JLabel("Xuất PDF", JLabel.CENTER);
    JLabel lblReset = new JLabel("Làm mới", JLabel.CENTER);
    JPopupMenu pmAdd = new JPopupMenu();
    JPopupMenu pmRemove = new JPopupMenu();
    JPopupMenu pmFIx = new JPopupMenu();
    JPanel pnSearch = new JPanel();
    JTextField txtSearch = new JTextField();
    JComboBox<String> cbSearch = new JComboBox<>();

    JFrame jf = new JFrame();
    KHUYENMAIBUS km = new KHUYENMAIBUS();
    ArrayList<KHUYENMAI> dskm = km.getDskm();
    String[] titles = km.getTitle();

    public KHUYENMAIGUI() {

        initComponents(titles, dskm);
//        jf.setSize(800, 500);
//        jf.setLayout(new BorderLayout());
//        jf.add(panelTool(), BorderLayout.NORTH);
//        jf.add(tableList(titles, dskm), BorderLayout.CENTER);
//        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
    }

    void initComponents(String[] titles, ArrayList<KHUYENMAI> dskm) {
        this.setLayout(new BorderLayout());
        this.add(panelTool(), BorderLayout.NORTH);
        this.add(tableList(titles, dskm), BorderLayout.CENTER);
        this.setVisible(true);

    }

    public JPanel panelTool() {
        JPanel pnPopUp = new JPanel();
        pnPopUp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnPopUp.setPreferredSize(new Dimension(0, 50));
        pnPopUp.setBackground(Color.white);
        pnPopUp.setOpaque(true);

        lblAdd.setPreferredSize(new Dimension(100, 30));
        lblAdd.setBackground(Color.white);
        lblAdd.setOpaque(true);
        lblAdd.setBorder(BorderFactory.createLineBorder(Color.black));
        lblAdd.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-new-32b.png"));
        lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(this);

        lblRemove.setPreferredSize(new Dimension(100, 30));
        lblRemove.setBackground(Color.white);
        lblRemove.setOpaque(true);
        lblRemove.setBorder(BorderFactory.createLineBorder(Color.black));
        lblRemove.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-remove-28.png"));
        lblRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblRemove.addMouseListener(this);

        lblFix.setPreferredSize(new Dimension(100, 30));
        lblFix.setBackground(Color.white);
        lblFix.setOpaque(true);
        lblFix.setBorder(BorderFactory.createLineBorder(Color.black));
        lblFix.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-tools-28.png"));
        lblFix.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblFix.addMouseListener(this);

        lblImport.setPreferredSize(new Dimension(100, 30));
        lblImport.setBackground(Color.white);
        lblImport.setOpaque(true);
        lblImport.setBorder(BorderFactory.createLineBorder(Color.black));
        lblImport.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-microsoft-excel-2019-28.png"));
        lblImport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblImport.addMouseListener(this);

        lblExport.setPreferredSize(new Dimension(100, 30));
        lblExport.setBackground(Color.white);
        lblExport.setOpaque(true);
        lblExport.setBorder(BorderFactory.createLineBorder(Color.black));
        lblExport.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-microsoft-excel-2019-28.png"));
        lblExport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblExport.addMouseListener(this);

        lblPDF.setPreferredSize(new Dimension(100, 30));
        lblPDF.setBackground(Color.white);
        lblPDF.setOpaque(true);
        lblPDF.setBorder(BorderFactory.createLineBorder(Color.black));
        lblPDF.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-pdf-28.png"));
        lblPDF.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblPDF.addMouseListener(this);

        pnPopUp.add(lblAdd);
        pnPopUp.add(lblRemove);
        pnPopUp.add(lblFix);
        pnPopUp.add(lblImport);
        pnPopUp.add(lblExport);
//        pnPopUp.add(lblPDF);

        JPanel pnFrameSearch = new JPanel();
        pnFrameSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        pnFrameSearch.setBackground(Color.white);
        pnFrameSearch.setOpaque(true);

        cbSearch.setBackground(Color.white);
        cbSearch.setOpaque(true);
        cbSearch.setBounds(40, 30, 120, 20);
        cbSearch.setModel(new DefaultComboBoxModel<>(new String[]{"Tất cả", "Mã Khuyến Mại", "Tên Khuyến Mại"}));
        cbSearch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = (String) e.getItem();
                    txtSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), selectedOption, TitledBorder.LEFT, TitledBorder.TOP));
                }
            }
        });

//    km.timKiem(txtSearch, selectedOption);
        txtSearch.setBackground(Color.white);
        txtSearch.setOpaque(true);
        txtSearch.setForeground(Color.black);
        txtSearch.setBounds(190, 15, 180, 40);
        txtSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "tất cả", TitledBorder.LEFT, TitledBorder.TOP));
        txtSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String selectedOption = cbSearch.getSelectedItem().toString();
                ArrayList<KHUYENMAI> arrTimKiem = new ArrayList<>();
                DefaultTableModel dtm = (DefaultTableModel) KHUYENMAIGUI.tblList.getModel();
                String text;
                text = txtSearch.getText().toLowerCase();
                int[] arrSTT = new int[dskm.size()];
                int i = 0;
//                JOptionPane.showMessageDialog(null, selectedOption);
                switch (selectedOption) {
                    case "Tất cả":
                        for (KHUYENMAI km : dskm) {
                            if (((km.getMaKM()).toLowerCase().contains(text) || (km.getTenKM()).toLowerCase().contains(text)) && (km.getTrangThai().equals("Đang hoạt động"))) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dskm.indexOf(km);
                            }
                        }
                        break;
                    case "Mã Khuyến Mại":
                        for (KHUYENMAI km : dskm) {
                            if ((km.getMaKM()).toLowerCase().contains(text) && (km.getTrangThai().equals("Đang hoạt động"))) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dskm.indexOf(km);
                            }
                        }
                        break;
                    case "Tên Khuyến Mại":
                        for (KHUYENMAI km : dskm) {
                            if ((km.getTenKM()).toLowerCase().contains(text) && (km.getTrangThai().equals("Đang hoạt động"))) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dskm.indexOf(km);
                            }
                        }
                        break;

                }
                dtm.setRowCount(0);
                i = 0;
                for (KHUYENMAI km : arrTimKiem) {
                    dtm.addRow(new Object[]{arrSTT[i++], km.getMaKM(), km.getTenKM(), km.getDieuKien(), km.getPhanTramGiamGia(), km.getNgayBD(), km.getNgayKT()});
                }
            }
        });

        pnSearch.setPreferredSize(new Dimension(400, 80));
        pnSearch.setBackground(Color.white);
        pnSearch.setOpaque(true);
        pnSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP));
        pnSearch.setLayout(null);
        pnSearch.add(cbSearch);
        pnSearch.add(txtSearch);

        lblReset.setPreferredSize(new Dimension(100, 30));
        lblReset.setBackground(Color.white);
        lblReset.setOpaque(true);
        lblReset.setBorder(BorderFactory.createLineBorder(Color.black));
        lblReset.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-reset-32.png"));
        lblReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblReset.addMouseListener(this);

        pnFrameSearch.add(pnSearch);
        pnFrameSearch.add(lblReset);

        pnTool.setPreferredSize(new Dimension(400, 150));
        pnTool.setBackground(Color.red);
        pnTool.setOpaque(true);
        pnTool.setLayout(new BorderLayout());
        pnTool.setBorder(BorderFactory.createDashedBorder(Color.gray));
        pnTool.add(pnPopUp, BorderLayout.NORTH);
        pnTool.add(pnFrameSearch, BorderLayout.CENTER);

        return pnTool;
    }

    public JScrollPane tableList(String[] titles, ArrayList<KHUYENMAI> dskm) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(localeVN);
        nf.setMaximumFractionDigits(0);
        nf.setCurrency(Currency.getInstance("VND"));
        NumberFormat percentFormat = NumberFormat.getPercentInstance(); // format phần trăm
        percentFormat.setMaximumFractionDigits(0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Object[][] data = new Object[dskm.size()][];
        int i = 0;
        String dieukien = null;
        String phanTram = null;
        for (KHUYENMAI km : dskm) {
            dieukien = nf.format(km.getDieuKien());
            phanTram = percentFormat.format(km.getPhanTramGiamGia() * 1.0 / 100.0);
            data[i++] = new Object[]{
                i, // số thứ tự tkhuyến mại
                km.getMaKM(),
                km.getTenKM(),
                dieukien,
                phanTram,
                km.getNgayBD(),
                km.getNgayKT(),};
        }
        tblList.setModel(new DefaultTableModel(
                data,
                titles
        ));

        for (int j = 0; j < tblList.getColumnCount(); j++) {
            tblList.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }

        TableColumn column = tblList.getColumnModel().getColumn(2); // Lấy cột thứ 3
        column.setPreferredWidth(220); // Thiết lập chiều rộng ưu tiên là 200

        spnList.setBorder(BorderFactory.createLineBorder(Color.black));
        spnList.setViewportView(tblList);
        return spnList;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException ignored) {
        }

        new KHUYENMAIGUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource() == lblAdd) {
            new createKMform();
        }

        // Remove 1 row
        if (e.getSource() == lblRemove) {
            int selectedRow = tblList.getSelectedRow();
            if (selectedRow != -1) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khuyến mại này không?", "Xác nhận xóa khuyến mại", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    int columnIndex = tblList.getColumnModel().getColumnIndex("Mã khuyến mãi"); // Lấy chỉ số của cột dựa trên tên của cột
                    int rowIndex = tblList.getSelectedRow(); // Lấy chỉ số của hàng được chọn
                    Object value = tblList.getModel().getValueAt(rowIndex, columnIndex); // Lấy giá trị của ô tương ứng trong cột đó
                    String stringValue = value.toString();
                    boolean remove = km.delete(stringValue);
                    if (remove) {
                        JOptionPane.showMessageDialog(null, "Xóa Thành Công!! Nhấn 'Làm Mới' để cập nhật");
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn hàng muốn xóa");
            }
        }

        //Update 1 Row
        if (e.getSource() == lblFix) {
            int selectedRow = tblList.getSelectedRow();
            if (selectedRow != -1) {
                TableModel model = tblList.getModel();
                String maKM = model.getValueAt(selectedRow, 1).toString();
                String tenKM = model.getValueAt(selectedRow, 2).toString();
                double dieuKien = 0;
                try {
                    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                    Number number = format.parse(model.getValueAt(selectedRow, 3).toString());
                    dieuKien = number.doubleValue();
                } catch (ParseException ex) {
                    Logger.getLogger(KHUYENMAIGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                double phanTram = 0;
                try {
                    NumberFormat percentFormat = NumberFormat.getPercentInstance(); 
                    Number number = percentFormat.parse(model.getValueAt(selectedRow, 4).toString());
                    phanTram = number.doubleValue() * 100;
                } catch (ParseException ex) {
                    Logger.getLogger(KHUYENMAIGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                LocalDate startDate = LocalDate.parse(model.getValueAt(selectedRow, 5).toString());
                LocalDate endDate = LocalDate.parse(model.getValueAt(selectedRow, 6).toString());
                KHUYENMAI kmNew = new KHUYENMAI(maKM, tenKM, dieuKien, phanTram, startDate, endDate);
                new updateKMform(kmNew);
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn hàng muốn sửa");
            }
        }
        if (e.getSource() == lblReset) {
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat nf = NumberFormat.getCurrencyInstance(localeVN); // format tiền tệ
            nf.setMaximumFractionDigits(0);
            nf.setCurrency(Currency.getInstance("VND"));
            NumberFormat percentFormat = NumberFormat.getPercentInstance(); // format phần trăm
            percentFormat.setMaximumFractionDigits(0);
            ArrayList<KHUYENMAI> dsnqNew = km.refresh();
//            spnList.removeAll();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            Object[][] data = new Object[dsnqNew.size()][];
            int i = 0;
            String dieukien = null;
            String phanTram = null;
            for (KHUYENMAI dis : dsnqNew) {
                dieukien = nf.format(dis.getDieuKien());
                phanTram = percentFormat.format(dis.getPhanTramGiamGia() * 1.0  / 100.0);
                data[i++] = new Object[]{
                    i, // số thứ tự tkhuyến mại
                    dis.getMaKM(),
                    dis.getTenKM(),
                    dieukien,
                    phanTram,
                    dis.getNgayBD(),
                    dis.getNgayKT()};
            }
            tblList.setModel(new DefaultTableModel(
                    data,
                    titles
            ));
            for (int j = 0; j < tblList.getColumnCount(); j++) {
                tblList.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
            }
            TableColumn column = tblList.getColumnModel().getColumn(2); // Lấy cột thứ 3
            column.setPreferredWidth(220); // Thiết lập chiều rộng ưu tiên là 200

            spnList.setBorder(BorderFactory.createLineBorder(Color.black));
            spnList.setViewportView(tblList);
            spnList.validate();
            spnList.repaint();
        }

        if (e.getSource() == lblExport) {
            IOExcel.writeExcel(tblList, "Danh Sách Khuyến Mại", "DSKM");
        }

        if (e.getSource() == lblImport) {
            ArrayList<ArrayList<Object>> data = null;
            try {
                data = IOExcel.readExcel(0);
            } catch (IOException ex) {
                Logger.getLogger(KHUYENMAIGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(KHUYENMAIGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            km.insertDTO(data);

        }
//        if (e.getSource() == lblPDF) {
//            writePDF.writeHD();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
