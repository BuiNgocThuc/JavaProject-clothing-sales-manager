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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class KHUYENMAIGUI extends JPanel implements  MouseListener{
    JPanel pnTool = new JPanel();
    JScrollPane spnList = new JScrollPane();
    JTable tblList = new JTable();

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

    public KHUYENMAIGUI() {
        initComponents();
        
        

       jf.setSize(800,500);
        jf.setLayout(new BorderLayout());
        jf.add(panelTool(), BorderLayout.NORTH);
        jf.add(tableList(), BorderLayout.CENTER);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelTool(), BorderLayout.NORTH);
        this.add(tableList(), BorderLayout.CENTER);
        this.setVisible(true);
        
        lblAdd.addMouseListener(this);
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

        pnPopUp.add(lblAdd);
        pnPopUp.add(lblRemove);
        pnPopUp.add(lblFix);
        pnPopUp.add(lblImport);
        pnPopUp.add(lblExport);
        pnPopUp.add(lblPDF);

        JPanel pnFrameSearch = new JPanel();
        pnFrameSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        pnFrameSearch.setBackground(Color.white);
        pnFrameSearch.setOpaque(true);

        cbSearch.setBackground(Color.white);
        cbSearch.setOpaque(true);
        cbSearch.setBounds(40, 30, 120, 20);
        cbSearch.setModel(new DefaultComboBoxModel<>(new String[]{"Tất cả", "Mã Khuyến Mại", "Tên Khuyến Mại", "Điều Kiện", "Phần Trăm Giảm Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc"}));

        txtSearch.setBackground(Color.white);
        txtSearch.setOpaque(true);
        txtSearch.setForeground(Color.black);
        txtSearch.setBounds(190, 15, 180, 40);
        txtSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "tất cả", TitledBorder.LEFT, TitledBorder.TOP));

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

    public JScrollPane tableList() {

        tblList.setModel(new DefaultTableModel(
                new Object[][]{
//                    {"1", "admin", "admin", "NV1", "Q1"},
//                    {"2", "quanly", "quanly", "NV2", " Q2"},
//                    {"3", "nhanvien", "nhanvien", "NV3", " Q3"},
                    {null, null, null, null, null}
                },
                new String[]{
                    "STT",  "Mã Khuyến Mại", "Tên Khuyến Mại", "Điều Kiện", "Phần Trăm Giảm Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc"
                }
        ));
        
        spnList.setBorder(BorderFactory.createLineBorder(Color.black));
        spnList.setViewportView(tblList);
        return spnList;
    }
    
    public static void main(String[] args) {
        new KHUYENMAIGUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       if(e.getSource() == lblAdd) {
           
           new createKMform();
       }
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
