/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.NHAPHANG;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Front_End.SANPHAM.SANPHAMGUI;
/**
 *
 * @author NGOC THUC
 */
public class NHAPHANGGUI {
	JLabel labelMaSP, labelMaTH, labelTenSP, labelSize, labelColor, labelSoLuong, labelGia;
	JTextField txtMaSP, txtMaTH, txtTenSP, txtSize, txtColor, txtSoLuong, txtGia;
	
    public NHAPHANGGUI(JFrame f) {
		initComponent(f);
    }
		
	public void initComponent(JFrame f)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,2,5,5));
		panel.setBounds(0,220 , 300, 200);
		labelMaSP = new JLabel("Mã SP", JLabel.CENTER);
		labelMaTH = new JLabel("Mã TH", JLabel.CENTER);
		labelTenSP = new JLabel("Tên SP", JLabel.CENTER);
		labelSize = new JLabel("Size", JLabel.CENTER);
		labelColor = new JLabel("Màu sắc", JLabel.CENTER);
		labelSoLuong = new JLabel("Số lượng", JLabel.CENTER);
		labelGia = new JLabel("Đơn giá", JLabel.CENTER);
		
		txtMaSP = new JTextField(6);
		txtMaTH = new JTextField(6);
		txtTenSP = new JTextField(6);
		txtSize = new JTextField(6);
		txtColor = new JTextField(6);
		txtSoLuong = new JTextField(6);
		txtGia = new JTextField(6);
		
		panel.add(labelMaSP);
		panel.add(txtMaSP);
		panel.add(labelMaTH);
		panel.add(txtMaTH);
		panel.add(labelTenSP);
		panel.add(txtTenSP);
		panel.add(labelSize);
		panel.add(txtSize);
		panel.add(labelColor);
		panel.add(txtColor);
		panel.add(labelSoLuong);
		panel.add(txtSoLuong);
		panel.add(labelGia);
		panel.add(txtGia);
		
		SANPHAMGUI a = new SANPHAMGUI();
		a.createTbale(f);
		
		
		f.add(panel);
		
	}
		
}
