/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.THONGKE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Back_End.THONGKE.ThongKeBUS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author NGOC THUC
 */
public class THONGKEGUI extends JPanel implements ChangeListener {

    public static JTable tblList;
    JTabbedPane tpStatistic = new JTabbedPane();
    JPanel pnKhachHang = new JPanel();
    JPanel pnNhaCungCap = new JPanel();
    JPanel pnSanPham = new JPanel();
//    JPanel pnTool = new JPanel();
//
//    JPanel pnDate = new JPanel();
//    JLabel lblCalendar_Start = new JLabel();
//    JLabel lblCalendar_End = new JLabel();
//    JTextField txtDate_Start = new JTextField();
//    JTextField txtDate_End = new JTextField();
//    JLabel lblReset = new JLabel("Làm mới", JLabel.CENTER);

    JLabel lblProduct = new JLabel("SẢN PHẨM", JLabel.CENTER);
    JLabel lblCustomer = new JLabel("KHÁCH HÀNG", JLabel.CENTER);
    JLabel lblProvider = new JLabel("NHÀ CUNG CẤP", JLabel.CENTER);
    JLabel lblProdData = new JLabel("0", JLabel.CENTER);
    JLabel lblCusData = new JLabel("0", JLabel.CENTER);
    JLabel lblProvData = new JLabel("0", JLabel.CENTER);

    JPanel pnProdSta = new JPanel();
    JPanel pnCusSta = new JPanel();
    JPanel pnProvSta = new JPanel();
    JPanel pnGeneralStatistic = new JPanel();
    JPanel pnTongKet = new JPanel();

    JDateChooser Date_Start;
    JDateChooser Date_End;
    JLabel lblReset;
    JLabel lblApplyDate;
    JComboBox<String> cb_thongKe;
    JTextField txtTopSP;
//    JComboBox<String> cb_thongKe = new JComboBox<>();
    JFrame jf = new JFrame();

    public THONGKEGUI() {
        ThongKeBUS a = new ThongKeBUS();
        initComponents();
        a.uploadData();
        a.allEvent(Date_Start, Date_End, lblApplyDate, lblReset, cb_thongKe, txtTopSP);

//        jf.setSize(800, 500);
//        jf.setLayout(new BorderLayout());
//        jf.add(paneStatistic(), BorderLayout.CENTER);
//        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
    }

    void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(paneStatistic(), BorderLayout.CENTER);
    }

    public JPanel panelTools(String[] items) {
        JPanel pnTool = new JPanel();
        txtTopSP = new JTextField();

        txtTopSP.setBorder(BorderFactory.createTitledBorder("Top sản phẩm"));
        txtTopSP.setPreferredSize(new Dimension(100, 40));

        JPanel pnDate = new JPanel();
        Date_Start = new JDateChooser();
        Date_End = new JDateChooser();
        lblReset = new JLabel("Làm mới", JLabel.CENTER);
        lblApplyDate = new JLabel("Áp dụng", JLabel.CENTER);
        cb_thongKe = new JComboBox<String>(items);

        cb_thongKe.setPreferredSize(new Dimension(135, 30));
        cb_thongKe.setFont(new Font(null, Font.PLAIN, 12));
        cb_thongKe.setBackground(Color.WHITE);
        cb_thongKe.setOpaque(true);
        

        Date_Start.setPreferredSize(new Dimension(120, 45));
        Date_Start.setBackground(Color.WHITE);
        Date_Start.setOpaque(true);
        Date_Start.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Từ ngày", TitledBorder.LEFT, TitledBorder.TOP));

        Date_End.setPreferredSize(new Dimension(120, 45));
        Date_End.setBackground(Color.WHITE);
        Date_End.setOpaque(true);
        Date_End.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Đến ngày", TitledBorder.LEFT, TitledBorder.TOP));

        lblApplyDate.setPreferredSize(new Dimension(80, 30));
        lblApplyDate.setBackground(Color.white);
        lblApplyDate.setOpaque(true);
        lblApplyDate.setBorder(BorderFactory.createLineBorder(Color.black));
        lblApplyDate.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
        lblApplyDate.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnDate.setPreferredSize(new Dimension(420, 80));
        pnDate.setBackground(Color.white);
        pnDate.setOpaque(true);
        pnDate.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Trong khoảng", TitledBorder.LEFT, TitledBorder.TOP));
        pnDate.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        pnDate.add(Date_Start);
        pnDate.add(Date_End);
        pnDate.add(lblApplyDate);

        lblReset.setPreferredSize(new Dimension(100, 40));
        lblReset.setBackground(Color.white);
        lblReset.setOpaque(true);
        lblReset.setBorder(BorderFactory.createLineBorder(Color.black));
        lblReset.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
        lblReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnTool.setPreferredSize(new Dimension(0, 180));
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        pnTool.add(txtTopSP);
        pnTool.add(cb_thongKe);
        pnTool.add(pnDate);
        pnTool.add(lblReset);
        return pnTool;
    }

    public JPanel generalStatistic() {
        lblProduct.setPreferredSize(new Dimension(150, 40));
        lblProduct.setBackground(Color.WHITE);
        lblProduct.setOpaque(true);
        lblProduct.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-product-40.png"));
        lblProduct.setFont(new Font("Serif", Font.BOLD, 14));

        lblProdData.setPreferredSize(new Dimension(80, 30));
        lblProdData.setFont(new Font("Serif", Font.BOLD, 18));

        pnProdSta.setPreferredSize(new Dimension(180, 120));
        pnProdSta.setBackground(Color.WHITE);
        pnProdSta.setOpaque(true);
        pnProdSta.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        pnProdSta.add(lblProduct);
        pnProdSta.add(lblProdData);

        lblCustomer.setPreferredSize(new Dimension(150, 40));
        lblCustomer.setBackground(Color.WHITE);
        lblCustomer.setOpaque(true);
        lblCustomer.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-customer-40.png"));
        lblCustomer.setFont(new Font("Serif", Font.BOLD, 14));

        lblCusData.setPreferredSize(new Dimension(80, 30));
        lblCusData.setFont(new Font("Serif", Font.BOLD, 18));

        pnCusSta.setPreferredSize(new Dimension(180, 120));
        pnCusSta.setBackground(Color.WHITE);
        pnCusSta.setOpaque(true);
        pnCusSta.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        pnCusSta.add(lblCustomer);
        pnCusSta.add(lblCusData);

        lblProvider.setPreferredSize(new Dimension(160, 40));
        lblProvider.setBackground(Color.WHITE);
        lblProvider.setOpaque(true);
        lblProvider.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-salesman-40.png"));
        lblProvider.setFont(new Font("Serif", Font.BOLD, 14));

        lblProvData.setPreferredSize(new Dimension(80, 30));
        lblProvData.setFont(new Font("Serif", Font.BOLD, 18));

        pnProvSta.setPreferredSize(new Dimension(180, 120));
        pnProvSta.setBackground(Color.WHITE);
        pnProvSta.setOpaque(true);
        pnProvSta.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        pnProvSta.add(lblProvider);
        pnProvSta.add(lblProvData);

        pnGeneralStatistic.setPreferredSize(new Dimension(0, 200));
        pnGeneralStatistic.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
        pnGeneralStatistic.add(pnProdSta);
        pnGeneralStatistic.add(pnCusSta);
        pnGeneralStatistic.add(pnProvSta);
        return pnGeneralStatistic;
    }

    public JScrollPane spStatistic(String[] title) {
        tblList = new JTable();

        DefaultTableModel model = new DefaultTableModel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (String str : title) {
            model.addColumn(str);
        }

        tblList.setModel(model);

        JScrollPane spnSta = new JScrollPane(tblList);
        spnSta.setBorder(BorderFactory.createLineBorder(Color.black));

        return spnSta;
    }

    public JPanel panelSummary() {
        String[] items = new String[]{"Tổng Tiền", "Số Lượng Sản Phẩm"};

        pnTongKet.setPreferredSize(new Dimension(800, 500));
        pnTongKet.setLayout(new BorderLayout());
        pnTongKet.add(panelTools(items), BorderLayout.NORTH);
        pnTongKet.add(generalStatistic(), BorderLayout.CENTER);
        return pnTongKet;
    }

    public JPanel panelProduct() {
        String[] itemsPro = new String[]{"Sắp Xếp Theo", "Bán Chạy Nhất", "Doanh Thu Cao Nhất"};
        String[] title = new String[]{"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Tổng tiền"};
        pnSanPham.setPreferredSize(new Dimension(800, 500));
        pnSanPham.setLayout(new BorderLayout());
        pnSanPham.add(panelTools(itemsPro), BorderLayout.NORTH);
        pnSanPham.add(spStatistic(title), BorderLayout.CENTER);
        return pnSanPham;
    }

    public JPanel panelCustomer() {
        String[] itemsPro = new String[]{"Tổng Tiền", "Số Lượng Sản Phẩm"};
        String[] title = new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Mã Hóa Đơn", "Tổng Tiền"};
        pnKhachHang.setPreferredSize(new Dimension(800, 500));
        pnKhachHang.setLayout(new BorderLayout());
        pnKhachHang.add(panelTools(itemsPro), BorderLayout.NORTH);
        pnKhachHang.add(spStatistic(title), BorderLayout.CENTER);
        return pnKhachHang;
    }

    public JPanel panelProvider() {
        String[] itemsPro = new String[]{"Tổng Tiền", "Số Lượng Sản Phẩm"};
        String[] title = new String[]{"Mã Khách Hàng", "Tên Nhà Cung Cấp", "Mã Phiếu Nhập", "Tổng Tiền"};
        pnNhaCungCap.setPreferredSize(new Dimension(800, 500));
        pnNhaCungCap.setLayout(new BorderLayout());
        pnNhaCungCap.add(panelTools(itemsPro), BorderLayout.NORTH);
        pnNhaCungCap.add(spStatistic(title), BorderLayout.CENTER);
        return pnNhaCungCap;

    }

    public JTabbedPane paneStatistic() {
//        tpStatistic.addTab("Thống Kê Tổng Quát", panelSummary());
        tpStatistic.addTab("Sản Phẩm", panelProduct());
//        tpStatistic.addTab("Khách Hàng", panelCustomer());
//        tpStatistic.addTab("Nhà Cung Cấp", panelProvider());

        return tpStatistic;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException ignored) {
        }
        new THONGKEGUI();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int tabIndex = tpStatistic.getSelectedIndex();

        switch (tabIndex) {
            case 0:
//                tpStatistic.addTab("Thống Kê Tổng Quát", panelSummary());
                break;
            default:
                throw new AssertionError();
        }
    }

}
