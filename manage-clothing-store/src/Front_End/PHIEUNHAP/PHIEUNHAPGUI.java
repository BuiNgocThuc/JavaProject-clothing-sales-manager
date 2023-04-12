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
	private JPanel pnl, pnl1, pnl2;
	private JTable tbl;
	private JButton btn1;
	private JTextField txt1;
	
	public PHIEUNHAPGUI(JFrame f) {
		innit(f);
	}
	
	private void innit(JFrame f) {
		pnl = new JPanel(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(800,100));
				
		txt1 = new JTextField();
		txt1.setBounds(50, 35, 555, 35);
		
		btn1 = new JButton("Làm mới");
		btn1.setBounds(645, 35, 105, 35);
				
		String[][] data = {
				{"2", "NNC2", "Nguyễn Văn A", "17/8/2022", "17000000vnđ"},
				{"3", "NCC1", "Nguyễn Văn B", "20/2/2023", "15000000vnđ"},
				{"1", "NCC1", "Nguyễn Văn B", "15/6/2022", "10000000vnđ"}
		};
		String[] columnNames = {"Mã phiếu nhập", "Nhà cung cấp", "Nhân viên nhập phiếu", "Ngày nhập", "Tổng tiền"};
		tbl = new JTable(data, columnNames);
		tbl.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(tbl);
				
		pnl2.add(txt1);
		pnl2.add(btn1);
		
		pnl1.add(pnl2);
		
		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(sp, BorderLayout.CENTER);
		
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new PHIEUNHAPGUI(f);
		f.setVisible(true);
	}
}
