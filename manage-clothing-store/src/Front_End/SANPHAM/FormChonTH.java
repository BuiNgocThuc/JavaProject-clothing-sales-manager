package Front_End.SANPHAM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Back_End.THUONGHIEU.THUONGHIEU;
import Back_End.THUONGHIEU.THUONGHIEUBUS;
import Back_End.THUONGHIEU.THUONGHIEUDAO;

public class FormChonTH extends JFrame{
	JTextField txtData = new JTextField();
	JTable tbTH = new JTable();
	JButton btnOK = new JButton("CHỌN"); 
	JButton btnHuy = new JButton("HỦY");
	
	public FormChonTH(JTextField txtData)
	{
		init(txtData);
	}
	
	public void init(JTextField txtData)
	{
		this.setSize(1000, 700);
		this.setTitle("Chọn thương hiệu");
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		DefaultTableModel dModel = new DefaultTableModel();
		dModel.addColumn("Mã TH");
		dModel.addColumn("Tên TH");
		ArrayList<THUONGHIEU> arr = THUONGHIEUDAO.getInstance().selectAll();
		for (THUONGHIEU thuonghieu : arr) {
			dModel.addRow(new Object[] {thuonghieu.getMaTH(),thuonghieu.getTenTH()});
		}
		tbTH.setModel(dModel);
		JScrollPane pane = new JScrollPane(tbTH);
		
		// Buttons panel 
		JPanel panelButton = new JPanel();
		btnHuy.setBorder(BorderFactory.createLineBorder(Color.black));
		btnHuy.setBackground(Color.white);
		btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
		
		btnOK.setBorder(BorderFactory.createLineBorder(Color.black));
		btnOK.setBackground(Color.white);
		btnOK.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
		panelButton.add(btnHuy);
		panelButton.add(btnOK);
		
		this.add(pane,BorderLayout.CENTER);
		this.add(panelButton,BorderLayout.SOUTH);
		
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHUY();				
			}
		});
		
		btnOK.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOK(txtData);				
			}
		});
		
		this.setVisible(true);
		
	}

	private void btnHUY()
	{
		this.dispose();
	}
	
	private void btnOK(JTextField txt)
	{
		int index = tbTH.getSelectedRow();
		String id = String.valueOf(tbTH.getValueAt(index, 1));
		txt.setText(id);
		this.dispose();
	}
}
