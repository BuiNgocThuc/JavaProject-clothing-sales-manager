/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.THUONGHIEU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Back_End.THUONGHIEU.THUONGHIEUBUS;
import Front_End.TAIKHOAN.TAIKHOANGUI;
import Import_Export.IOExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEUGUI extends JPanel {
    
    private JPanel pnl1, pnl2, pnl3, pnl4;
    public static JTable tbl;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private JTextField txt;
    
    THUONGHIEUBUS a = new THUONGHIEUBUS();
    
    public THUONGHIEUGUI() {
        
        innit();
        a.uploadData();
        a.timKiem(txt, btn1);
        a.them(btn2, this, pnl1);
        a.sua(btn3, this, pnl1);
        a.xoa(btn4);
    }
    
    private void innit() {
        this.setLayout(new BorderLayout());
        pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        pnl2 = new JPanel(null);
        pnl2.setBorder(new TitledBorder(BorderFactory.createRaisedBevelBorder(), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnl2.setPreferredSize(new Dimension(433, 80));
        
        pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        
        pnl4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        txt = new JTextField();
        txt.setBounds(33, 25, 250, 30);
        
        btn1 = new JButton("Làm mới");
        btn1.setBounds(300, 25, 100, 30);
        btn1.setBackground(Color.WHITE);
        btn1.setMargin(new Insets(0, 0, 0, 0));
        btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
        
        btn2 = new JButton("Thêm");
        btn2.setPreferredSize(new Dimension(100, 30));
        btn2.setBackground(Color.WHITE);
        btn2.setMargin(new Insets(0, 0, 0, 0));
        btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-32 (1).png")));
        
        btn3 = new JButton("Sửa");
        btn3.setPreferredSize(new Dimension(100, 30));
        btn3.setBackground(Color.WHITE);
        btn3.setMargin(new Insets(0, 0, 0, 0));
        btn3.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-tools-28.png")));
        
        btn4 = new JButton("Xóa");
        btn4.setPreferredSize(new Dimension(100, 30));
        btn4.setBackground(Color.WHITE);
        btn4.setMargin(new Insets(0, 0, 0, 0));
        btn4.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-remove-28.png")));
        
        btn5 = new JButton("Nhập");
        btn5.setPreferredSize(new Dimension(100, 30));
        btn5.setBackground(Color.WHITE);
        btn5.setMargin(new Insets(0, 0, 0, 0));
        btn5.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ArrayList<Object>> data = null;
            try {
                data = IOExcel.readExcel(0);
            } catch (IOException ex) {
                Logger.getLogger(THUONGHIEUGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(THUONGHIEUGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.insertDTO(data);
            }
        });
        
        btn6 = new JButton("Xuất");
        btn6.setPreferredSize(new Dimension(100, 30));
        btn6.setBackground(Color.WHITE);
        btn6.setMargin(new Insets(0, 0, 0, 0));
        btn6.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị được chọn và hiển thị lên JLabel
               IOExcel.writeExcel(tbl, "Danh Sách Thương Hiệu", "DSTH");
            }
        });
        
        btn7 = new JButton("Xuất PDF");
        btn7.setPreferredSize(new Dimension(100, 30));
        btn7.setBackground(Color.WHITE);
        btn7.setMargin(new Insets(0, 0, 0, 0));
        btn7.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));
        
        tbl = new JTable();
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
        dtm.addColumn("Mã thương hiệu");
        dtm.addColumn("Tên thương hiệu");
        tbl.setModel(dtm);
        tbl.setAutoCreateRowSorter(true);
        tbl.getTableHeader().setPreferredSize(new Dimension(1000, 40));
        tbl.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
        tbl.setRowHeight(30);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(250);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(750);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbl.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JScrollPane sp = new JScrollPane(tbl);
        sp.setBorder(BorderFactory.createRaisedBevelBorder());
        
        pnl4.add(btn5);
        pnl4.add(btn6);
//        pnl4.add(btn7);
        
        pnl3.add(btn2);
        pnl3.add(btn3);
        pnl3.add(btn4);
        
        pnl2.add(txt);
        pnl2.add(btn1);
        
        pnl1.add(pnl2);
        pnl1.add(pnl3);
        
        this.add(pnl1, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(pnl4, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        new THUONGHIEUGUI();
    }
}
