/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.PHIEUNHAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
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
public class PHIEUNHAPGUI {
	private JPanel pnl, pnl1, pnl2, pnl3;
	private JTable tbl;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btn1, btn2;
	private JTextField txt1, txt2, txt3, txt4;
	
	public PHIEUNHAPGUI(JFrame f) {
		innit(f);
	}
	
	private void innit(JFrame f) {
		pnl = new JPanel(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(350,100));
		
		pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		lbl1 = new JLabel("Mã: ");
		lbl1.setBounds(50, 14, 40, 20);
		lbl2 = new JLabel("NCC: ");
		lbl2.setBounds(50, 34, 40, 20);
		lbl3 = new JLabel("NV: ");
		lbl3.setBounds(50, 54, 40, 20);
		lbl4 = new JLabel("Ngày: ");
		lbl4.setBounds(50, 74, 40, 20);
		
		txt1 = new JTextField();
		txt1.setBounds(90, 14, 210, 20);
		txt2 = new JTextField();
		txt2.setBounds(90, 34, 210, 20);
		txt3 = new JTextField();
		txt3.setBounds(90, 54, 210, 20);
		txt4 = new JTextField();
		txt4.setBounds(90, 74, 210, 20);
		
		btn1 = new JButton("Tìm kiếm");
		btn1.setPreferredSize(new Dimension(100, 30));
		btn2 = new JButton("Xem chi tiết");
		btn2.setPreferredSize(new Dimension(100, 30));
				
		String[][] data = {
				{"2", "NNC2", "Nguyễn Văn A", "17/8/2022", "17000000vnđ"},
				{"3", "NCC1", "Nguyễn Văn B", "20/2/2023", "15000000vnđ"},
				{"1", "NCC1", "Nguyễn Văn B", "15/6/2022", "10000000vnđ"}
		};
		String[] columnNames = {"Mã phiếu nhập", "Nhà cung cấp", "Nhân viên nhập phiếu", "Ngày nhập", "Tổng tiền"};
		tbl = new JTable(data, columnNames);
		tbl.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(tbl);
		
		pnl3.add(btn2);
		
		pnl2.add(lbl1);
		pnl2.add(lbl2);
		pnl2.add(lbl3);
		pnl2.add(lbl4);
		pnl2.add(txt1);
		pnl2.add(txt2);
		pnl2.add(txt3);
		pnl2.add(txt4);
		
		pnl1.add(pnl2);
		pnl1.add(btn1);
		
		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(sp, BorderLayout.CENTER);
		pnl.add(pnl3, BorderLayout.SOUTH);
		
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new PHIEUNHAPGUI(f);
		f.setVisible(true);
	}
}
