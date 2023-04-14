/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.PHIEUNHAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Back_End.PHIEUNHAP.PHIEUNHAPBUS;

/**
 *
 * @author NGOC THUC
 */
public class PHIEUNHAPGUI extends JPanel {
	private JPanel pnl1, pnl2, pnl3;
	public static JTable tbl;
	private JButton btn1, btn2, btn3, btn4;
	private JTextField txt1;
	
	public PHIEUNHAPGUI() {
		PHIEUNHAPBUS a = new PHIEUNHAPBUS();
		innit();
		a.uploadData();
		a.timKiem(txt1, btn1);
	}
	
	private void innit() {
		this.setLayout(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(new LineBorder(Color.black), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(800,100));
		
		pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
				
		txt1 = new JTextField();
		txt1.setBounds(50, 35, 555, 35);
		
		btn1 = new JButton("Làm mới");
		btn1.setBounds(645, 35, 105, 35);
		btn1.setBounds(645, 35, 105, 35);
		btn1.setBackground(Color.WHITE);
		btn1.setMargin(new Insets(0, 0, 0, 0));
		btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
		
		btn2 = new JButton("Nhập");
		btn2.setPreferredSize(new Dimension(100, 30));
		btn2.setBackground(Color.WHITE);
		btn2.setMargin(new Insets(0, 0, 0, 0));
		btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
		
		btn3 = new JButton("Xuất");
		btn3.setPreferredSize(new Dimension(100, 30));
		btn3.setBackground(Color.WHITE);
		btn3.setMargin(new Insets(0, 0, 0, 0));
		btn3.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
		
		btn4 = new JButton("Xuất PDF");
		btn4.setPreferredSize(new Dimension(100, 30));
		btn4.setBackground(Color.WHITE);
		btn4.setMargin(new Insets(0, 0, 0, 0));
		btn4.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));

		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		dtm.addColumn("Mã phiếu nhập");
		dtm.addColumn("Nhà cung cấp");
		dtm.addColumn("Nhân viên nhập phiếu");
		dtm.addColumn("Ngày nhập");
		dtm.addColumn("Tổng tiền");
		tbl = new JTable();
		tbl.setModel(dtm);
		tbl.setAutoCreateRowSorter(true);
		tbl.getTableHeader().setPreferredSize(new Dimension(1000, 40));
		tbl.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
		tbl.setRowHeight(30);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
		tbl.setAlignmentX(20);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tbl.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tbl.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JScrollPane sp = new JScrollPane(tbl);
		sp.setBorder(BorderFactory.createRaisedBevelBorder());
				
		pnl3.add(btn2);
		pnl3.add(btn3);
		pnl3.add(btn4);
		
		pnl2.add(txt1);
		pnl2.add(btn1);
		
		pnl1.add(pnl2);
		
		this.add(pnl1, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(pnl3, BorderLayout.SOUTH);
	}
}
