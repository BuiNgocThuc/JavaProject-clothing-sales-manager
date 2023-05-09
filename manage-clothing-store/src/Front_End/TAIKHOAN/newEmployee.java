/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.TAIKHOAN;

import Back_End.NHANVIEN.NHANVIEN;
import Back_End.NHANVIEN.NHANVIENBUS;
import Back_End.NHANVIEN.NHANVIEN;
import Back_End.NHANVIEN.NHANVIENBUS;
import Back_End.NHANVIEN.NHANVIENDAO;
import Front_End.PHANQUYEN.PHANQUYENGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author NGOC THUC
 */
public class newEmployee extends JFrame {

    JScrollPane spnList = new JScrollPane();
    public static JTable tblList = new JTable();

    JLabel lblAdd = new JLabel("Chọn");
    JLabel lblCancel = new JLabel("Hủy");
    JPanel pnTool = new JPanel();

    NHANVIENDAO nvDAO = new NHANVIENDAO();

    ArrayList<NHANVIEN> dsnq;
    String[] titlesEmp = new String[]{"STT", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ"};

    public newEmployee(JTextField txtMaNV) {
        dsnq = nvDAO.selectAll();

        this.setUndecorated(true);
        this.setSize(750, 600);
        this.setLayout(new BorderLayout());
        this.add(tableList(titlesEmp, dsnq), BorderLayout.CENTER);
        this.add(tools(txtMaNV), BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JScrollPane tableList(String[] titles, ArrayList<NHANVIEN> dsnq) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Object[][] data = new Object[dsnq.size()][];
        int i = 0;
        for (NHANVIEN km : dsnq) {
            data[i++] = new Object[]{
                i, // số thứ tự tkhuyến mại
                km.getMaNV(),
                km.getTenNV(),
                km.getNgaySinh(),
                km.getSdt(),
                km.getDiaChi(),};
        }
        tblList.setModel(new DefaultTableModel(
                data,
                titles
        ));
        spnList.setBorder(BorderFactory.createLineBorder(Color.black));
        spnList.setViewportView(tblList);
        return spnList;
    }

    JPanel tools(JTextField txtMaNV) {
        lblAdd.setPreferredSize(new Dimension(100, 40));
        lblAdd.setBackground(Color.white);
        lblAdd.setOpaque(true);
        lblAdd.setForeground(Color.black);
        lblAdd.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblAdd.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-new-32.png"));
        lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblList.getSelectedRow();
                TableModel model = tblList.getModel();
                if (selectedRow != -1) {
                    String roleID = model.getValueAt(selectedRow, 1).toString();
                   txtMaNV.setText(roleID);
                    newEmployee.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn quyền muốn");
                }
            }
        });

        lblCancel.setPreferredSize(new Dimension(100, 40));
        lblCancel.setBackground(Color.white);
        lblCancel.setOpaque(true);
        lblCancel.setForeground(Color.black);
        lblCancel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblCancel.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-close-window-32.png"));
        lblCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                newEmployee.this.dispose();
            }
        });

        pnTool.setPreferredSize(new Dimension(400, 60));
        pnTool.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnTool.add(lblAdd);
        pnTool.add(lblCancel);
        return pnTool;
    }

    public static void main(String[] args) {
        //new newEmployee();
    }
}
