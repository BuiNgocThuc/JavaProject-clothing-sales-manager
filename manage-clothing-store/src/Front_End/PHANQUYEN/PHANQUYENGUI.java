/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.PHANQUYEN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author NGOC THUC
 */

import Back_End.NHOMQUYEN.NHOMQUYEN;
import Back_End.NHOMQUYEN.NHOMQUYENBUS;
import Front_End.FrameLayout.LayoutFrame;
import Front_End.HandleEvent.EventInLabel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class PHANQUYENGUI extends JPanel implements MouseListener {

    JPanel nqBusTool = new JPanel();
    JScrollPane spnList = new JScrollPane();
    JTable tblList = new JTable();

    JLabel lblAdd = new JLabel("Thêm", JLabel.CENTER);
    JLabel lblRemove = new JLabel("Xóa", JLabel.CENTER);
    JLabel lblFix = new JLabel("Sửa", JLabel.CENTER);
    JLabel lblImport = new JLabel("Nhập Excel", JLabel.CENTER);
    JLabel lblExport = new JLabel("Xuất Excel", JLabel.CENTER);
    JLabel lblPDF = new JLabel("Xuất PDF", JLabel.CENTER);
    JLabel lblReset = new JLabel("Làm mới", JLabel.CENTER);

    JPanel nqBusSearch = new JPanel();
    JTextField txtSearch = new JTextField();
    JComboBox<String> cbSearch = new JComboBox<>();

    NHOMQUYENBUS nqBus = new NHOMQUYENBUS();
    ArrayList<NHOMQUYEN> dsnq = nqBus.getDsnq();
    String[] titles = nqBus.getTitle();

    JFrame jf = new JFrame();

    public PHANQUYENGUI() {

        initComponents(titles, dsnq);

//        jf.setSize(800, 500);
//        jf.setLayout(new BorderLayout());
//        jf.add(panelTool(), BorderLayout.NORTH);
//        jf.add(tableList(titles, dsnq), BorderLayout.CENTER);
//        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
    }

    void initComponents(String[] titles, ArrayList<NHOMQUYEN> dsnq) {
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());
        this.add(panelTool(), BorderLayout.NORTH);
        this.add(tableList(titles, dsnq), BorderLayout.CENTER);
    }

    public JPanel panelTool() {
        JPanel nqBusPopUp = new JPanel();
        nqBusPopUp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        nqBusPopUp.setPreferredSize(new Dimension(0, 50));
        nqBusPopUp.setBackground(Color.white);
        nqBusPopUp.setOpaque(true);

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

        lblFix.setPreferredSize(new Dimension(100, 30));
        lblFix.setBackground(Color.white);
        lblFix.setOpaque(true);
        lblFix.setBorder(BorderFactory.createLineBorder(Color.black));
        lblFix.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-tools-28.png"));
        lblFix.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblImport.setPreferredSize(new Dimension(100, 30));
        lblImport.setBackground(Color.white);
        lblImport.setOpaque(true);
        lblImport.setBorder(BorderFactory.createLineBorder(Color.black));
        lblImport.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-microsoft-excel-2019-28.png"));
        lblImport.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblExport.setPreferredSize(new Dimension(100, 30));
        lblExport.setBackground(Color.white);
        lblExport.setOpaque(true);
        lblExport.setBorder(BorderFactory.createLineBorder(Color.black));
        lblExport.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-microsoft-excel-2019-28.png"));
        lblExport.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblPDF.setPreferredSize(new Dimension(100, 30));
        lblPDF.setBackground(Color.white);
        lblPDF.setOpaque(true);
        lblPDF.setBorder(BorderFactory.createLineBorder(Color.black));
        lblPDF.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-pdf-28.png"));
        lblPDF.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nqBusPopUp.add(lblAdd);
        nqBusPopUp.add(lblRemove);
        nqBusPopUp.add(lblFix);
        nqBusPopUp.add(lblImport);
        nqBusPopUp.add(lblExport);
        nqBusPopUp.add(lblPDF);

        JPanel nqBusFrameSearch = new JPanel();
        nqBusFrameSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        nqBusFrameSearch.setBackground(Color.white);
        nqBusFrameSearch.setOpaque(true);

        cbSearch.setBackground(Color.white);
        cbSearch.setOpaque(true);
        cbSearch.setBounds(40, 30, 120, 20);
        cbSearch.setModel(new DefaultComboBoxModel<>(new String[]{"Tất cả", "Mã Quyền", "Tên Quyền", "Chi Tiết Quyền"}));

        txtSearch.setBackground(Color.white);
        txtSearch.setOpaque(true);
        txtSearch.setForeground(Color.black);
        txtSearch.setBounds(190, 15, 180, 40);
        txtSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "tất cả", TitledBorder.LEFT, TitledBorder.TOP));

        nqBusSearch.setPreferredSize(new Dimension(400, 80));
        nqBusSearch.setBackground(Color.white);
        nqBusSearch.setOpaque(true);
        nqBusSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP));
        nqBusSearch.setLayout(null);
        nqBusSearch.add(cbSearch);
        nqBusSearch.add(txtSearch);

        lblReset.setPreferredSize(new Dimension(100, 30));
        lblReset.setBackground(Color.white);
        lblReset.setOpaque(true);
        lblReset.setBorder(BorderFactory.createLineBorder(Color.black));
        lblReset.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-reset-32.png"));
        lblReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblReset.addMouseListener(this);

        nqBusFrameSearch.add(nqBusSearch);
        nqBusFrameSearch.add(lblReset);

        nqBusTool.setPreferredSize(new Dimension(400, 150));
        nqBusTool.setBackground(Color.red);
        nqBusTool.setOpaque(true);
        nqBusTool.setLayout(new BorderLayout());
        nqBusTool.setBorder(BorderFactory.createDashedBorder(Color.gray));
        nqBusTool.add(nqBusPopUp, BorderLayout.NORTH);
        nqBusTool.add(nqBusFrameSearch, BorderLayout.CENTER);

        return nqBusTool;
    }

    public JScrollPane tableList(String[] titles, ArrayList<NHOMQUYEN> dsnq) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Object[][] data = new Object[dsnq.size()][];
        int i = 0;
        for (NHOMQUYEN km : dsnq) {
            data[i++] = new Object[]{
                i, // số thứ tự tkhuyến mại
                km.getMaQuyen(),
                km.getTenQuyen(),
                km.getMoTaQuyen(),};
        }
        tblList.setModel(new DefaultTableModel(
                data,
                titles
        ));
        spnList.setBorder(BorderFactory.createLineBorder(Color.black));
        spnList.setViewportView(tblList);
        return spnList;
    }

    public static void main(String[] args) {
        new PHANQUYENGUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource() == lblAdd) {
            new CHUCNANGGUI();
        }
        if (e.getSource() == lblReset) {
            ArrayList<NHOMQUYEN> dsnqNew = nqBus.getDsnq();
            for (NHOMQUYEN nq : dsnqNew) {
                System.out.println(nq.getMaQuyen());
            }
//            spnList.removeAll();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            Object[][] data = new Object[dsnqNew.size()][];
            int i = 0;
            for (NHOMQUYEN km : dsnqNew) {
                data[i++] = new Object[]{
                    i, // số thứ tự tkhuyến mại
                    km.getMaQuyen(),
                    km.getTenQuyen(),
                    km.getMoTaQuyen(),};
            }
            tblList.setModel(new DefaultTableModel(
                    data,
                    titles
            ));
            spnList.setViewportView(tblList);
            spnList.validate();
            spnList.repaint();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
