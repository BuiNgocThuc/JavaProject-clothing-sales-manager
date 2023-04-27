/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.THUONGHIEU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Front_End.THUONGHIEU.THUONGHIEUGUI;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEUBUS {
	public static ArrayList<THUONGHIEU> arrTH;
	
	public void uploadData() {
		arrTH = THUONGHIEUDAO.getInstance().selectAll();
		DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();

		if(arrTH.size() == 0) {
			String[] arrStr = {"Louis Vuitton", "Hermès", "Prada", "Chanel", "Gucci", "Versace", "Christian Dior", "Burberry"};
			
			for(int i=1; i<9; i++) {
				THUONGHIEU thuonghieu = new THUONGHIEU("TH" + (i+1000), arrStr[i-1], "Còn");
				THUONGHIEUDAO.getInstance().insert(thuonghieu);
			}
			arrTH = THUONGHIEUDAO.getInstance().selectAll();
		}
		
		dtm.setRowCount(0);
		for (THUONGHIEU thuonghieu : arrTH) {
			if((thuonghieu.getTrangthai()).equals("Còn")) {
				dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
			}
		}
	}
	
	public void timKiem(JTextField txt, JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(null);
				uploadData();
				txt.requestFocus();
			}
		});
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList<THUONGHIEU> arrTimKiem = new ArrayList<>();
				DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
				String text;
				text = txt.getText().toLowerCase();
				
				for (THUONGHIEU thuonghieu : arrTH) {
					if((((thuonghieu.getMaTH()).toLowerCase().contains(text) || (thuonghieu.getTenTH()).toLowerCase().contains(text))) && (thuonghieu.getTrangthai().equals("Còn"))) {
						arrTimKiem.add(thuonghieu);
					}
				}

				dtm.setRowCount(0);
				for (THUONGHIEU thuonghieu : arrTimKiem) {
					dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {				
			}
		});
	}
	
	public void them(JButton btn, JPanel pnl, JPanel tmp) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tmp.setVisible(false);
				pnl.remove(tmp);
				JPanel pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
				pnl1.setBorder(new TitledBorder(BorderFactory.createRaisedBevelBorder(), "Thêm thương hiệu", TitledBorder.LEADING, TitledBorder.TOP, new Font(null, Font.BOLD, 15), null));
				pnl1.setPreferredSize(new Dimension(0, 90));
				
				JLabel lbl = new JLabel("Tên thương hiệu:");
				lbl.setPreferredSize(new Dimension(155, 30));
				lbl.setFont(new Font(null, Font.PLAIN, 20));
				
				JTextField txt = new JTextField();
				txt.setPreferredSize(new Dimension(200, 30));
				
				txt.addKeyListener(new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER) {
							if(txt.getText().equals("")) {
								JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Vui lòng nhập tên thương hiệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
							}else {
								DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
								THUONGHIEU thuonghieu = new THUONGHIEU("TH" + (arrTH.size()+1+1000), txt.getText(), "Còn");
								THUONGHIEUDAO.getInstance().insert(thuonghieu);
								arrTH.add(thuonghieu);
								dtm.setRowCount(dtm.getRowCount());
								dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
								
								pnl1.setVisible(false);
								pnl.remove(pnl1);
		 						pnl.add(tmp, BorderLayout.NORTH);
		 						tmp.setVisible(true);
							}
						}
					}
				});

				
				JButton btnThem = new JButton("Thêm");
				btnThem.setPreferredSize(new Dimension(100, 30));
				btnThem.setBackground(Color.WHITE);
				btnThem.setMargin(new Insets(0, 0, 0, 0));
				btnThem.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-32 (1).png")));
				
				btnThem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(txt.getText().equals("")) {
							JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Vui lòng nhập tên thương hiệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
						}else {
							DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
							THUONGHIEU thuonghieu = new THUONGHIEU("TH" + (arrTH.size()+1+1000), txt.getText(), "Còn");
							THUONGHIEUDAO.getInstance().insert(thuonghieu);
							arrTH.add(thuonghieu);
							dtm.setRowCount(dtm.getRowCount());
							dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
							
							pnl1.setVisible(false);
							pnl.remove(pnl1);
	 						pnl.add(tmp, BorderLayout.NORTH);
	 						tmp.setVisible(true);
						}
					}
				});
				
				JButton btnHuy = new JButton("Hủy");
				btnHuy.setPreferredSize(new Dimension(100, 30));
				btnHuy.setBackground(Color.WHITE);
				btnHuy.setMargin(new Insets(0, 0, 0, 0));
				btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-close-window-32.png")));
				
				btnHuy.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnl1.setVisible(false);
						pnl.remove(pnl1);
 						pnl.add(tmp, BorderLayout.NORTH);
 						tmp.setVisible(true);
					}
				});

				pnl1.add(lbl);
				pnl1.add(txt);
				pnl1.add(btnThem);
				pnl1.add(btnHuy);
				pnl.add(pnl1, BorderLayout.NORTH);
				txt.requestFocus();
			}
		});
	}
	
	public void sua(JButton btn, JPanel pnl, JPanel tmp) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String ma, ten;
					DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
					ma = String.valueOf(THUONGHIEUGUI.tbl.getValueAt(THUONGHIEUGUI.tbl.getSelectedRow(), 0));
					ten = String.valueOf(THUONGHIEUGUI.tbl.getValueAt(THUONGHIEUGUI.tbl.getSelectedRow(), 1));
					tmp.setVisible(false);
					pnl.remove(tmp);
					JPanel pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
					pnl1.setBorder(new TitledBorder(BorderFactory.createRaisedBevelBorder(), "Sửa thương hiệu", TitledBorder.LEADING, TitledBorder.TOP, new Font(null, Font.BOLD, 15), null));
					pnl1.setPreferredSize(new Dimension(0, 90));
					
					JLabel lbl = new JLabel("Tên thương hiệu:");
					lbl.setPreferredSize(new Dimension(155, 30));
					lbl.setFont(new Font(null, Font.PLAIN, 20));
					
					JTextField txt = new JTextField();
					txt.setPreferredSize(new Dimension(200, 30));
					txt.setText(ten);
					
					txt.addKeyListener(new KeyListener() {
						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							// TODO Auto-generated method stub
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode() == KeyEvent.VK_ENTER) {
								if(txt.getText().equals("")) {
									JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Không được để trống tên thương hiệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
								}else {
									THUONGHIEU thuonghieu = new THUONGHIEU(ma, txt.getText(), "Còn");
									THUONGHIEUDAO.getInstance().update(thuonghieu);
									for (THUONGHIEU thuonghieu2 : arrTH) {
										if(thuonghieu2.getMaTH().equals(ma)) {
											thuonghieu2.setTenTH(txt.getText());
										}
									}
									
									dtm.setRowCount(0);
									for (THUONGHIEU thuonghieu3 : arrTH) {
										if((thuonghieu3.getTrangthai()).equals("Còn")) {
											dtm.addRow(new Object[] {thuonghieu3.getMaTH(), thuonghieu3.getTenTH()});
										}
									}
									
									pnl1.setVisible(false);
									pnl.remove(pnl1);
			 						pnl.add(tmp, BorderLayout.NORTH);
			 						tmp.setVisible(true);
								}
							}
						}
					});
					
					JButton btnSua = new JButton("Sửa");
					btnSua.setPreferredSize(new Dimension(100, 30));
					btnSua.setBackground(Color.WHITE);
					btnSua.setMargin(new Insets(0, 0, 0, 0));
					btnSua.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-tools-28.png")));
					
					btnSua.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(txt.getText().equals("")) {
								JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Không được để trống tên thương hiệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
							}else {
								THUONGHIEU thuonghieu = new THUONGHIEU(ma, txt.getText(), "Còn");
								THUONGHIEUDAO.getInstance().update(thuonghieu);
								for (THUONGHIEU thuonghieu2 : arrTH) {
									if(thuonghieu2.getMaTH().equals(ma)) {
										thuonghieu2.setTenTH(txt.getText());
									}
								}
								
								dtm.setRowCount(0);
								for (THUONGHIEU thuonghieu3 : arrTH) {
									if((thuonghieu3.getTrangthai()).equals("Còn")) {
										dtm.addRow(new Object[] {thuonghieu3.getMaTH(), thuonghieu3.getTenTH()});
									}
								}
								
								pnl1.setVisible(false);
								pnl.remove(pnl1);
		 						pnl.add(tmp, BorderLayout.NORTH);
		 						tmp.setVisible(true);
							}
						}
					});
					
					JButton btnHuy = new JButton("Hủy");
					btnHuy.setPreferredSize(new Dimension(100, 30));
					btnHuy.setBackground(Color.WHITE);
					btnHuy.setMargin(new Insets(0, 0, 0, 0));
					btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-close-window-32.png")));
					
					btnHuy.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							pnl1.setVisible(false);
							pnl.remove(pnl1);
	 						pnl.add(tmp, BorderLayout.NORTH);
	 						tmp.setVisible(true);
						}
					});

					pnl1.add(lbl);
					pnl1.add(txt);
					pnl1.add(btnSua);
					pnl1.add(btnHuy);
					pnl.add(pnl1, BorderLayout.NORTH);
					txt.requestFocus();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Vui lòng chọn thương hiệu cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	public void xoa(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel dtm = (DefaultTableModel) THUONGHIEUGUI.tbl.getModel();
					String ma, ten;
					ma = String.valueOf(THUONGHIEUGUI.tbl.getValueAt(THUONGHIEUGUI.tbl.getSelectedRow(), 0));
					ten = String.valueOf(THUONGHIEUGUI.tbl.getValueAt(THUONGHIEUGUI.tbl.getSelectedRow(), 1));

					for(int i=0; i<arrTH.size(); i++) {
						if((arrTH.get(i).getMaTH()).equals(ma) && (arrTH.get(i).getTenTH()).equals(ten)) {
							arrTH.get(i).setTrangthai("Đã xóa");
							THUONGHIEUDAO.getInstance().update(arrTH.get(i));
						}
					}
					
					dtm.setRowCount(0);
					for (THUONGHIEU thuonghieu : arrTH) {
						if((thuonghieu.getTrangthai()).equals("Còn")) {
							dtm.addRow(new Object[] {thuonghieu.getMaTH(), thuonghieu.getTenTH()});
						}
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(THUONGHIEUGUI.tbl, "Vui lòng chọn thương hiệu cần xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
