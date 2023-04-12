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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Back_End.THUONGHIEU.THUONGHIEUBUS;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEUGUI {
	private JPanel pnl, pnl1, pnl2, pnl3;
	public static JTable tbl;
	private JButton btn1, btn2, btn3, btn4;
	private JTextField txt;
	
	public THUONGHIEUGUI(JFrame f) {
		THUONGHIEUBUS a = new THUONGHIEUBUS();
		innit(f);
		a.uploadData();
		a.timKiem(txt, btn1);
		a.them(btn2, pnl, pnl1);
		a.sua(btn3, pnl, pnl1);
		a.xoa(btn4);
	}
	
	private void innit(JFrame f) {
		pnl = new JPanel(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(450,80));
		
		pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		
		txt = new JTextField();
		txt.setBounds(33, 25, 250, 30);
		
		btn1 = new JButton("Làm mới");
		btn1.setBounds(317, 25, 100, 30);
				
		btn2 = new JButton("Thêm");
		btn2.setPreferredSize(new Dimension(100, 30));
		
		btn3 = new JButton("Sửa");
		btn3.setPreferredSize(new Dimension(100, 30));
		
		btn4 = new JButton("Xóa");
		btn4.setPreferredSize(new Dimension(100, 30));
		
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
		
		JScrollPane sp = new JScrollPane(tbl);
		
		pnl3.add(btn2);
		pnl3.add(btn3);
		pnl3.add(btn4);
		pnl2.add(txt);
		pnl2.add(btn1);
		pnl1.add(pnl2);
		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(sp, BorderLayout.CENTER);
		pnl1.add(pnl3);
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new THUONGHIEUGUI(f);
		f.setVisible(true);
	}
}
