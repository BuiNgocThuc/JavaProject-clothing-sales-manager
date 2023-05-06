package Front_End.NHAPHANG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Back_End.NHACUNGCAP.NHACUNGCAP;
import Back_End.NHACUNGCAP.NHACUNGCAPDAO;

public class FormChonNCC extends JFrame{
	JTable tbNCC = new JTable();
	JButton btnHuy = new JButton("Huỷ");
	JButton btnChon = new JButton("Chọn");
	public FormChonNCC(JTextField txtData)
	{
		init(txtData);
	}
	
	public void init(JTextField txtData)
	{
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setTitle("Thông tin nhân viên");
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NCC");
		model.addColumn("Tên NCC");
		model.addColumn("SĐT");
		model.addColumn("Địa chỉ");
		model.addColumn("Trạng thái");
		
		ArrayList<NHACUNGCAP> arrNCC = NHACUNGCAPDAO.getInstance().selectAll();
		for (NHACUNGCAP nhacungcap : arrNCC) {
			model.addRow(new Object[] {nhacungcap.getMaNCC(),nhacungcap.getTenNCC(),nhacungcap.getSdt(),nhacungcap.getDiaChi(),nhacungcap.getTrangThai()});
		}
		tbNCC.setModel(model);
		JScrollPane pane = new JScrollPane(tbNCC);
		
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btnHuy.setBorder(BorderFactory.createLineBorder(Color.black));
		btnHuy.setBackground(Color.white);
		btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
		
		btnChon.setBorder(BorderFactory.createLineBorder(Color.black));
		btnChon.setBackground(Color.white);
		btnChon.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
		panelButton.add(btnHuy);
		panelButton.add(btnChon);
		
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHUY();
			}
		});
		
		btnChon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOK(txtData);	
			}
		});
		this.add(pane,BorderLayout.CENTER);
		this.add(panelButton,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private void btnHUY()
	{
		this.dispose();
	}
	
	private void btnOK(JTextField txt)
	{
		int index = tbNCC.getSelectedRow();
		String id = String.valueOf(tbNCC.getValueAt(index, 0));
		txt.setText(id);
		this.dispose();
	}

}
