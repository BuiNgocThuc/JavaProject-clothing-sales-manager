/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.HOADON;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Front_End.HOADON.HOADONGUI;

/**
 *
 * @author NGOC THUC
 */
public class HOADONBUS {
    public static ArrayList<HOADON> arrHD;
    
    public void uploadData() {
    	ArrayList<HOADON> arrHD = HOADONDAO.getInstance().selectAll();
    	DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();
    	
    	dtm.setRowCount(0);
    	for (HOADON hoadon : arrHD) {
			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), hoadon.getTongTien()});
		}
    }
    
    public void timKiem(JTextField txt, JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(null);
				uploadData();
			}
		});
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
//				ArrayList<THUONGHIEU> arrTimKiem = new ArrayList<>();
//				DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
//				String text;
//				text = txt.getText().toLowerCase();
//				
//				for (THUONGHIEU thuonghieu : arrTH) {
//					if((((thuonghieu.getMaTH()).toLowerCase().contains(text) || (thuonghieu.getTenTH()).toLowerCase().contains(text))) && (thuonghieu.getTrangthai().equals("Còn"))) {
//						arrTimKiem.add(thuonghieu);
//					}
//				}
//
//				dtm.setRowCount(0);
//				for (THUONGHIEU thuonghieu : arrTimKiem) {
//					dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
//				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {				
			}
		});
	}
}