/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.NHAPHANG;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class NHAPHANGGUI {
	JLabel labelMaSP, labelMaTH, labelTenSP, labelSize, labelColor, labelGia;
	JTable table;
	JTextField txtSoLuong;
	JButton btnAdd;
	
    public NHAPHANGGUI(JFrame f) {
		initComponent(f);
    }
		
	public void initComponent(JFrame f)
	{
		JPanel panelNhapHang = new JPanel();
		panelNhapHang.setLayout(null);
		panelNhapHang.setSize(600, 400);
		
		String columnNames[] = {"Mã SP","Mã TH","Tên SP","Size","Màu sắc","Đơn giá"};
		String data[][] = {{"SP001","DIOR","Jacket","M","Đen","4000000"},{"SP002","GUCCI","Áo","S","Đỏ","500000"}};
		DefaultTableModel dModel = new DefaultTableModel(data, columnNames);
		
		table = new JTable(dModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(32);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 600, 200);
		panelNhapHang.add(scrollPane);
		
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBorder(new TitledBorder(null, "Mã SP", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel1.setBounds(10, scrollPane.getHeight()+20, 79, 46);
		labelMaSP = new JLabel("",JLabel.CENTER);
		jPanel1.add(labelMaSP);
		panelNhapHang.add(jPanel1);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBorder(new TitledBorder(null, "Mã TH", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel2.setBounds(10, scrollPane.getHeight()+20+jPanel1.getHeight(), 79, 46);
		labelMaTH = new JLabel("",JLabel.CENTER);
		jPanel2.add(labelMaTH);
		panelNhapHang.add(jPanel2);
		 
		JPanel jPanel3 = new JPanel();
		jPanel3.setBorder(new TitledBorder(null, "Tên SP", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel3.setBounds(jPanel1.getWidth()+20, scrollPane.getHeight()+20, 102, 46);
		labelTenSP = new JLabel("",JLabel.CENTER);
		jPanel3.add(labelTenSP);
		panelNhapHang.add(jPanel3);
		
		JPanel jPanel4 = new JPanel();
		jPanel4.setBorder(new TitledBorder(null, "Size", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel4.setBounds(jPanel2.getWidth()+20, scrollPane.getHeight()+20+jPanel3.getHeight(), 46, 46);
		labelSize = new JLabel("",JLabel.CENTER);
		jPanel4.add(labelSize);
		panelNhapHang.add(jPanel4);
		
		JPanel jPanel5 = new JPanel();
		jPanel5.setBorder(new TitledBorder(null, "Màu", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel5.setBounds(jPanel2.getWidth()+20+jPanel4.getWidth()+10, scrollPane.getHeight()+20+jPanel3.getHeight(), 46, 46);
		labelColor = new JLabel("",JLabel.CENTER);
		jPanel5.add(labelColor);
		panelNhapHang.add(jPanel5);
		
		JPanel jPanel6 = new JPanel();
		jPanel6.setBorder(new TitledBorder(null, "Số lượng", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel6.setBounds(jPanel1.getWidth()+jPanel3.getWidth()+30, scrollPane.getHeight()+20, 130, 46);
		txtSoLuong = new JTextField(10);
		jPanel6.add(txtSoLuong);
		panelNhapHang.add(jPanel6);
		
		JPanel jPanel7 = new JPanel();
		jPanel7.setBorder(new TitledBorder(null, "Đơn giá", TitledBorder.LEADING, TitledBorder.TOP));
		jPanel7.setBounds(jPanel1.getWidth()+jPanel3.getWidth()+30, scrollPane.getHeight()+20+jPanel6.getHeight(), 130, 46);
		labelGia = new JLabel("",JLabel.CENTER);
		jPanel7.add(labelGia);
		panelNhapHang.add(jPanel7);
		
		// Xự kiện
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row[] = table.getSelectedRows();
				int column[] = table.getSelectedColumns();
				String maSP = String.valueOf(table.getValueAt(row[0], 0));
				String maTH = String.valueOf(table.getValueAt(row[0], 1));
				String tenSP = String.valueOf(table.getValueAt(row[0], 2));
				String size = String.valueOf(table.getValueAt(row[0], 3));
				String mau = String.valueOf(table.getValueAt(row[0], 4));
				String donGia = String.valueOf(table.getValueAt(row[0], 5));
				
				labelMaSP.setText(maSP);
				labelMaTH.setText(maTH);
				labelTenSP.setText(tenSP);
				labelSize.setText(size);
				labelColor.setText(mau);
				labelGia.setText(donGia);
			}
		});
		
		btnAdd = new JButton("THÊM");
		btnAdd.setBounds(jPanel1.getWidth()+jPanel3.getWidth()+jPanel6.getWidth()+100, scrollPane.getHeight()+50, 72, 36);
		panelNhapHang.add(btnAdd);
		
		
		f.add(panelNhapHang);
		
	}
}
