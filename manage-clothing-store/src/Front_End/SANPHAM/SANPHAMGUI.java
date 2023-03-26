/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.SANPHAM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import SANPHAM.SANPHAM;



/**
 *
 * @author NGOC THUC
 */
public class SANPHAMGUI {
	private JTable tableSP;
	private JLabel labelAdd, labelDelete, labelUpdate, labelFind;
	static DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane ;
	public  SANPHAMGUI(JFrame f)
	{
		initConponenrt(f);
	}
	public SANPHAMGUI()
	{
		
	}
	
	public void createTbale(JFrame f) {
		tableSP = new JTable();
		defaultTableModel = new DefaultTableModel();
		tableSP.setModel(defaultTableModel);
		defaultTableModel.addColumn("Mã SP");
		defaultTableModel.addColumn("Mã TH");
		defaultTableModel.addColumn("Tên SP");
		defaultTableModel.addColumn("Size");
		defaultTableModel.addColumn("Màu sắc");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Đơn giá");
		defaultTableModel.addColumn("Trạng thái");
		scrollPane = new JScrollPane(tableSP);
		scrollPane.setBounds(0, 0, f.getWidth(), (f.getHeight())/2);
		tableSP.setFillsViewportHeight(true);
		f.add(scrollPane);
	}

	private void initConponenrt(JFrame f) {
		
		createTbale(f);
		JPanel panelBottom = new JPanel();
		labelAdd = new JLabel("THÊM", JLabel.CENTER);
		labelAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labelAdd.setPreferredSize(new Dimension(40, 40));
		
		labelDelete = new JLabel("XÓA", JLabel.CENTER);
		labelDelete.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labelDelete.setPreferredSize(new Dimension(40, 40));
		
		labelUpdate = new JLabel("SỬA", JLabel.CENTER);
		labelUpdate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labelUpdate.setPreferredSize(new Dimension(40, 40));
		
		labelFind = new JLabel("TÌM KIẾM", JLabel.CENTER);
		labelFind.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labelFind.setPreferredSize(new Dimension(60, 40));
		
		panelBottom.setBounds(0, scrollPane.getHeight() + f.getHeight()/4, f.getWidth(), 100);
		panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBottom.add(labelAdd);
		panelBottom.add(labelUpdate);
		panelBottom.add(labelDelete);
		panelBottom.add(labelFind);
		f.add(panelBottom);
		
	}
	
	public void createValue(SANPHAM t) {
		String maSP = t.getMaSP();
		String maTH = t.getMaTH();
		String tenSP = t.getTenSP();
		String size = t.getKichCo();
		String color = t.getMauSac();
		int soLuong = t.getSoLuongSP();
		float gia = t.getGiaSP();
		String trangThai = t.getTrangThai();
		Vector<SANPHAM> sanpham = new Vector<>();
		sanpham.add(t);
		defaultTableModel.addRow(new Object[] {maSP,maTH,tenSP,size,color,soLuong,gia, trangThai});
	}

}
