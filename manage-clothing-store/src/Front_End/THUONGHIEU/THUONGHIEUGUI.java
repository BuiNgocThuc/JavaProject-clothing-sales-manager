/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.THUONGHIEU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEUGUI extends JPanel {

    private JPanel pnl, pnl1, pnl2, pnl3;
    private JTable tbl;
    private JLabel lbl1, lbl2;
    private JButton btn1, btn2, btn3, btn4;
    private JTextField txt1, txt2;
    JFrame f = new JFrame();

    public THUONGHIEUGUI() {
        this.setLayout(new BorderLayout());

        innit();
        f.add(this);
        f.setSize(new Dimension(500, 500));
        f.setVisible(true);
    }

    private void innit() {
        pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        pnl2 = new JPanel(null);
        pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnl2.setPreferredSize(new Dimension(350, 100));

        pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        lbl1 = new JLabel("Mã: ");
        lbl1.setBounds(50, 25, 40, 30);
        lbl2 = new JLabel("Tên: ");
        lbl2.setBounds(50, 55, 40, 30);

        txt1 = new JTextField();
        txt1.setBounds(90, 33, 210, 20);

        txt2 = new JTextField();
        txt2.setBounds(90, 63, 210, 20);

        btn1 = new JButton("Tìm kiếm");
        btn1.setPreferredSize(new Dimension(100, 30));

        btn2 = new JButton("Thêm");
        btn2.setPreferredSize(new Dimension(100, 30));

        btn3 = new JButton("Sửa");
        btn3.setPreferredSize(new Dimension(100, 30));

        btn4 = new JButton("Xóa");
        btn4.setPreferredSize(new Dimension(100, 30));

        String[][] data = {
            {"2", "TH2"},
            {"3", "TH3"},
            {"1", "TH1"}
        };
        String[] columnNames = {"Mã thương hiệu", "Tên thương hiệu"};
        tbl = new JTable(data, columnNames);
        tbl.setAutoCreateRowSorter(true);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane sp = new JScrollPane(tbl);
        sp.setBackground(Color.red);
        sp.setPreferredSize(new Dimension(1010, 444));
        
        System.out.println("Jtable" + tbl.getSize());

        pnl3.add(btn2);
        pnl3.add(btn3);
        pnl3.add(btn4);
        pnl2.add(lbl1);
        pnl2.add(lbl2);
        pnl2.add(txt1);
        pnl2.add(txt2);
        pnl1.add(pnl2);
        pnl1.add(btn1);
        this.add(pnl1, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(pnl3, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        new THUONGHIEUGUI();
    }
}
