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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEUGUI {
	private JPanel pnl, pnl1, pnl2, pnl3;
	private JTable tbl;
	private JLabel lbl1, lbl2, lbl3;
	private JButton btn1, btn2, btn3, btn4;
	private JTextField txt1, txt2;
	private JComboBox<?> cb;
	
	public THUONGHIEUGUI(JFrame f) {
		innit(f);
	}
	
	private void innit(JFrame f) {
		pnl = new JPanel(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(450,120));
		
		pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		lbl1 = new JLabel("Mã: ");
		lbl1.setBounds(40, 15, 40, 30);
		lbl2 = new JLabel("Tên: ");
		lbl2.setBounds(40, 45, 40, 30);
		lbl3 = new JLabel("T.Thái:");
		lbl3.setBounds(40, 75, 40, 30);
		
		txt1 = new JTextField();
		txt1.setBounds(90, 20, 210, 20);
		
		txt2 = new JTextField();
		txt2.setBounds(90, 50, 210, 20);
		
		btn1 = new JButton("Tìm kiếm");
		btn1.setBounds(320, 45, 100, 30);
		
		String[] tt = {"Tất cả", "Hiện", "Ẩn"};
		cb = new JComboBox<>(tt);
		cb.setBounds(90, 80, 210, 20);
		cb.setBackground(Color.white);
		
		btn2 = new JButton("Thêm");
		btn2.setPreferredSize(new Dimension(100, 30));
		
		btn3 = new JButton("Sửa");
		btn3.setPreferredSize(new Dimension(100, 30));
		
		btn4 = new JButton("Xóa");
		btn4.setPreferredSize(new Dimension(100, 30));
		
		String[][] data = {
				{"2", "TH2", "Ẩn"},
				{"3", "TH3", "Hiện"},
				{"1", "TH1", "Hiện"}
		};
		String[] columnNames = {"Mã thương hiệu", "Tên thương hiệu", "Trạng thái"};
		tbl = new JTable(data, columnNames);
		tbl.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(tbl);
		
		pnl3.add(btn2);
		pnl3.add(btn3);
		pnl3.add(btn4);
		pnl2.add(lbl1);
		pnl2.add(lbl2);
		pnl2.add(lbl3);
		pnl2.add(txt1);
		pnl2.add(txt2);
		pnl2.add(cb);
		pnl2.add(btn1);
		pnl1.add(pnl2);
		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(sp, BorderLayout.CENTER);
		pnl1.add(pnl3);
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new THUONGHIEUGUI(f);
		f.setVisible(true);
	}
}
