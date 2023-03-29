/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.HOADON;

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
public class HOADONGUI {
	private JPanel pnl, pnl1, pnl2;
	private JTable tbl;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btn1;
	private JTextField txt1, txt2, txt3, txt4;
	
	public HOADONGUI(JFrame f) {
		innit(f);
	}
	
	private void innit(JFrame f) {
		pnl = new JPanel(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(600,100));
				
		lbl1 = new JLabel("Mã: ");
		lbl1.setBounds(40, 20, 40, 20);
		lbl2 = new JLabel("KH: ");
		lbl2.setBounds(310, 20, 40, 20);
		lbl3 = new JLabel("NV: ");
		lbl3.setBounds(40, 60, 40, 20);
		lbl4 = new JLabel("Ngày: ");
		lbl4.setBounds(310, 60, 40, 20);
		
		txt1 = new JTextField();
		txt1.setBounds(80, 20, 210, 20);
		txt2 = new JTextField();
		txt2.setBounds(350, 20, 210, 20);
		txt3 = new JTextField();
		txt3.setBounds(80, 60, 210, 20);
		txt4 = new JTextField();
		txt4.setBounds(350, 60, 210, 20);
		
		btn1 = new JButton("Tìm kiếm");
		btn1.setPreferredSize(new Dimension(100, 30));
		
		String[][] data = {
				{"2", "KH2", "Nguyễn Văn A", "17/8/2022", "17000000vnđ"},
				{"3", "KH3", "Nguyễn Văn B", "20/2/2023", "15000000vnđ"},
				{"1", "KH1", "Nguyễn Văn B", "15/6/2022", "10000000vnđ"}
		};
		String[] columnNames = {"Mã hóa đơn", "Khách hàng", "Nhân viên lập hóa đơn", "Ngày nhập", "Tổng tiền"};
		tbl = new JTable(data, columnNames);
		tbl.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(tbl);
				
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
		
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new HOADONGUI(f);
		f.setVisible(true);
	}
}
