/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.TAIKHOAN;

import Back_End.NHOMQUYEN.NHOMQUYEN;
import Back_End.TAIKHOAN.TAIKHOANBUS;
import Back_End.TAIKHOAN.TAIKHOAN;
import Front_End.KHUYENMAI.KHUYENMAIGUI;
import Front_End.PHANQUYEN.PHANQUYENGUI;
import Import_Export.IOExcel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author NGOC THUC
 */
public class TAIKHOANGUI extends JPanel implements MouseListener {

    JPanel pnTool = new JPanel();
    JScrollPane spnList = new JScrollPane();
    public static JTable tblList = new JTable();

    JLabel lblAdd = new JLabel("Thêm", JLabel.CENTER);
    JLabel lblRemove = new JLabel("Xóa", JLabel.CENTER);
    JLabel lblFix = new JLabel("Sửa", JLabel.CENTER);
    JLabel lblImport = new JLabel("Nhập Excel", JLabel.CENTER);
    JLabel lblExport = new JLabel("Xuất Excel", JLabel.CENTER);
    JLabel lblPDF = new JLabel("Xuất PDF", JLabel.CENTER);
    JLabel lblReset = new JLabel("Làm mới", JLabel.CENTER);

    JPanel pnSearch = new JPanel();
    JTextField txtSearch = new JTextField();
    JComboBox<String> cbSearch = new JComboBox<>();

    JFrame jf = new JFrame();
    TAIKHOANBUS tk = new TAIKHOANBUS();
    ArrayList<TAIKHOAN> dstk = tk.getDstk();
    String[] titles = tk.getTitle();

    public TAIKHOANGUI() {

        initComponents(titles, dstk);

//        jf.setSize(800, 500);
//        jf.setLayout(new BorderLayout());
//        jf.add(panelTool(), BorderLayout.NORTH);
//        jf.add(tableList(titles, dstk), BorderLayout.CENTER);
//        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
    }

    void initComponents(String[] titles, ArrayList<TAIKHOAN> dstk) {
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());
        this.add(panelTool(), BorderLayout.NORTH);
        this.add(tableList(titles, dstk), BorderLayout.CENTER);
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
        cbSearch.setModel(new DefaultComboBoxModel<>(new String[]{"Tất cả", "Mã Quyền", "Tên Đăng Nhập"}));

        txtSearch.setBackground(Color.white);
        txtSearch.setOpaque(true);
        txtSearch.setForeground(Color.black);
        txtSearch.setBounds(190, 15, 180, 40);
        txtSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "tất cả", TitledBorder.LEFT, TitledBorder.TOP));
        txtSearch.addKeyListener(new KeyAdapter() {
             public void keyReleased(KeyEvent e) {
                String selectedOption = cbSearch.getSelectedItem().toString();
                ArrayList<TAIKHOAN> arrTimKiem = new ArrayList<>();
                DefaultTableModel dtm = (DefaultTableModel) TAIKHOANGUI.tblList.getModel();
                String text;
                text = txtSearch.getText().toLowerCase();
                int[] arrSTT = new int[dstk.size()];
                int i = 0;
//                JOptionPane.showMessageDialog(null, selectedOption);
                switch (selectedOption) {
                    case "Tất cả":
                        for (TAIKHOAN km : dstk) {
                            if (((km.getMaQuyen()).toLowerCase().contains(text) || (km.getUserName()).toLowerCase().contains(text))) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dstk.indexOf(km);
                            }
                        }
                        break;
                    case "Tên Đăng Nhập":
                        for (TAIKHOAN km : dstk) {
                            if ((km.getUserName()).toLowerCase().contains(text)) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dstk.indexOf(km);
                            }
                        }
                        break;
                    case "Mã Quyền":
                        for (TAIKHOAN km : dstk) {
                            if ((km.getMaQuyen()).toLowerCase().contains(text)) {
                                arrTimKiem.add(km);
                                arrSTT[i++] = dstk.indexOf(km);
                            }
                        }
                        break;
                }
                dtm.setRowCount(0);
                i = 0;
                for (TAIKHOAN km : arrTimKiem) {
                    dtm.addRow(new Object[]{arrSTT[i++], km.getUserName(), km.getPassWord(), km.getMaQuyen()});
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

    public JScrollPane tableList(String[] titles, ArrayList<TAIKHOAN> dstk) {
        Object[][] data = new Object[dstk.size()][];
        int i = 0;
        for (TAIKHOAN tk : dstk) {
            data[i++] = new Object[]{
                i, // số thứ tự tài khoản
                tk.getUserName(), // tên đăng nhập
                tk.getPassWord(), // mật khẩu
                tk.getMaQuyen(), // mã quyền
            };
        }

        tblList.setModel(new DefaultTableModel(data, titles));
        spnList.setBorder(BorderFactory.createLineBorder(Color.black));
        spnList.setViewportView(tblList);
        return spnList;
    }

    public static void main(String[] args) {
        new TAIKHOANGUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        if (e.getSource() == lblAdd) {
            new newAccount();
        }
        if (e.getSource() == lblRemove) {
            int selectedRow = tblList.getSelectedRow();
            if (selectedRow != -1) {
                int choice = JOptionPane.showConfirmDialog(null, "Xác nhận xóa tài khoản này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Xóa dữ liệu
                    int columnIndex = tblList.getColumnModel().getColumnIndex("Tên tài khoản");
                    Object value = tblList.getModel().getValueAt(selectedRow, columnIndex);
                    String stringValue = value.toString();
                    boolean remove = tk.delete(stringValue);
                    if (remove) {
                        JOptionPane.showMessageDialog(null, "Xóa Thành Công!! Nhấn 'Làm Mới' để cập nhật");
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa Thất Bại!!!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn hàng muốn xóa");
                return;
            }
        }
        if (e.getSource() == lblFix) {
            int selectedRow = tblList.getSelectedRow();
            if (selectedRow != -1) {
                TableModel model = tblList.getModel();
                String username = model.getValueAt(selectedRow, 1).toString();
                String password = model.getValueAt(selectedRow, 2).toString();
                String roleID = model.getValueAt(selectedRow, 3).toString();

                updateAccount newAcc = new updateAccount();
                newAcc.getTxtMaNV().setText(username);
                newAcc.getTxtPassword().setText(password);
                newAcc.getTxtMaQuyen().setText(roleID);
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn hàng muốn sửa");
                return;
            }

        }
        if (e.getSource() == lblReset) {
            ArrayList<TAIKHOAN> dstkNew = tk.getDstk();
//            for (TAIKHOAN nq : dstkNew) { 
//                System.out.println(nq.getMaQuyen());
//            }
//            spnList.removeAll();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            Object[][] data = new Object[dstkNew.size()][];
            int i = 0;
            for (TAIKHOAN km : dstkNew) {
                data[i++] = new Object[]{
                    i, // số thứ tự tkhuyến mại
                    km.getUserName(),
                    km.getPassWord(),
                    km.getMaQuyen(),};
            }
            tblList.setModel(new DefaultTableModel(
                    data,
                    titles
            ));
            spnList.setViewportView(tblList);
            spnList.validate();
            spnList.repaint();
        }
         if (e.getSource() == lblExport) {
            IOExcel.writeExcel(tblList, "Danh Sách Tài Khoản", "DSTK");
        }
         if(e.getSource() == lblImport) {
               ArrayList<ArrayList<Object>> data = null;
            try {
                data = IOExcel.readExcel(0);
            } catch (IOException ex) {
                Logger.getLogger(TAIKHOANGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(TAIKHOANGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            tk.insertDTO(data);
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
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
