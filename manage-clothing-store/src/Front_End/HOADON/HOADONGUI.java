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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class HOADONGUI {
	private JPanel pnl, pnl1, pnl2;
	private JTable tbl;
	private JButton btn1;
	private JTextField txt1;
	
	public HOADONGUI(JFrame f) {
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
		dtm.addColumn("Mã hóa đơn");
		dtm.addColumn("Khách hàng");
		dtm.addColumn("Nhân viên lập hóa đơn");
		dtm.addColumn("Ngày nhập");
		dtm.addColumn("Tổng tiền");
		tbl.setModel(dtm);
		tbl.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(tbl);
				
		pnl2.add(txt1);
		pnl2.add(btn1);
		
		pnl1.add(pnl2);
		
		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(sp, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.add(pnl);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(900, 500));
		
		new HOADONGUI(f);
		f.setVisible(true);
	}
}
