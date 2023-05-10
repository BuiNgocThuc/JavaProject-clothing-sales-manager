/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.HOADON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Back_End.CTHoaDon.CTHoaDonBUS;
import Back_End.HOADON.HOADONBUS;

/**
 *
 * @author NGOC THUC
 */
public class HOADONGUI extends JPanel {
	private JPanel pnl1, pnl2, pnl3;
	public static JTable tbl;
	private JButton btn1, btn2, btn3, btn4, btn5;
	private JTextField txt1;
	private JDateChooser dc;
	private JComboBox<String> cb;
	
	public HOADONGUI() {
		HOADONBUS a = new HOADONBUS();
		CTHoaDonBUS b = new CTHoaDonBUS();
		innit();
		a.uploadData();
		a.timKiem(txt1, btn1, dc, cb);
		a.showHDHuy(btn2);
		b.showCTHD(tbl);
	}
	
	private void innit() {
		this.setLayout(new BorderLayout());
		pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		pnl2 = new JPanel(null);
		pnl2.setBorder(new TitledBorder(BorderFactory.createRaisedBevelBorder(), "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl2.setPreferredSize(new Dimension(800,110));
		
		pnl3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
						
		txt1 = new JTextField();
		txt1.setBounds(50, 27, 555, 35);
		
		btn1 = new JButton("Làm mới");
		btn1.setBounds(645, 43, 105, 35);
		btn1.setBackground(Color.WHITE);
		btn1.setMargin(new Insets(0, 0, 0, 0));
		btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
		
		dc = new JDateChooser();
		dc.setBounds(130, 67, 180, 30);
		
		cb = new JComboBox<String>();
		cb.setBounds(353, 67, 150, 30);
		cb.setBackground(Color.WHITE);
		cb.addItem("Lọc theo tổng tiền");
		cb.addItem("Dưới 1.000.000");
		cb.addItem("1.000.000 - 5.000.000");
		cb.addItem("5.000.000 - 10.000.000");
		cb.addItem("10.000.000 - 15.000.000");
		cb.addItem("15.000.000 - 20.000.000");
		cb.addItem("Trên 20.000.000");
		
		btn2 = new JButton("Hóa đơn đã hủy");
		btn2.setPreferredSize(new Dimension(150, 30));
		btn2.setBackground(Color.WHITE);
		btn2.setMargin(new Insets(0, 0, 0, 0));
		btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-bill-32.png")));
		
		btn3 = new JButton("Nhập");
		btn3.setPreferredSize(new Dimension(100, 30));
		btn3.setBackground(Color.WHITE);
		btn3.setMargin(new Insets(0, 0, 0, 0));
		btn3.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
		
		btn4 = new JButton("Xuất");
		btn4.setPreferredSize(new Dimension(100, 30));
		btn4.setBackground(Color.WHITE);
		btn4.setMargin(new Insets(0, 0, 0, 0));
		btn4.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-microsoft-excel-2019-28.png")));
		
//		btn5 = new JButton("Xuất PDF");
//		btn5.setPreferredSize(new Dimension(100, 30));
//		btn5.setBackground(Color.WHITE);
//		btn5.setMargin(new Insets(0, 0, 0, 0));
//		btn5.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-pdf-28.png")));
		
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
		tbl.getTableHeader().setPreferredSize(new Dimension(1000, 40));
		tbl.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
		tbl.setRowHeight(30);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
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
//		pnl3.add(btn5);
		
		pnl2.add(txt1);
		pnl2.add(btn1);
		pnl2.add(dc);
		pnl2.add(cb);
		
		pnl1.add(pnl2);
		
		this.add(pnl1, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(pnl3, BorderLayout.SOUTH);
	}
}
