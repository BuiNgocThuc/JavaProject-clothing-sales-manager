/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.BANHANG;

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
public class BANHANGGUI {
	JLabel labelTenKH, labelSDTKH, labelDiaChi;
	JTextField txtTenKH, txtSDT, txtDiaChi;
	public BANHANGGUI(JFrame f)
	{
		initComponent(f);
	}

	private void initComponent(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2,5,5));
		panel.setBounds(0,220 , 300, 100);
		labelTenKH = new JLabel("HỌ VÀ TÊN",JLabel.CENTER);
		labelTenKH.setSize(80,40);
		labelSDTKH = new JLabel("SDT", JLabel.CENTER);
		labelSDTKH.setSize(80,40);
		labelDiaChi = new JLabel("ĐỊA CHỈ", JLabel.CENTER);
		labelDiaChi.setSize(80,40);
		
		txtTenKH = new JTextField(6);
		txtSDT = new JTextField(6);
		txtDiaChi = new JTextField(6);
		panel.add(labelTenKH);
		panel.add(txtTenKH);
		panel.add(labelSDTKH);
		panel.add(txtSDT);
		panel.add(labelDiaChi);
		panel.add(txtDiaChi);
		
		SANPHAMGUI a = new SANPHAMGUI();
		a.createTable(f);
		
		
		f.add(panel);
	}
}
