/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front_End.SANPHAM;

import javax.swing.JFrame;

import Front_End.SANPHAM.SANPHAMGUI;
import Front_End.THUONGHIEU.THUONGHIEUGUI;

/**
 *
 * @author NGOC THUC
 */
public class SanPhamTest {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 800);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		SANPHAMGUI a= new SANPHAMGUI(f);
		//FormNHAPHANG a = new FormNHAPHANG(f);
    	f.setVisible(true);
	}

}
