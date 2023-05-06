package Front_End.NHAPHANG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
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

import Back_End.NHACUNGCAP.NHACUNGCAPDAO;
import Back_End.NHANVIEN.NHANVIEN;
import Back_End.NHANVIEN.NHANVIENDAO;

public class FormChonNhanVien extends JFrame {
	JTextField txtData = new JTextField();
	JTable tbNV = new JTable();
	JButton btnChon = new JButton("Chọn");
	JButton btnHuy = new JButton("Hủy");
	public FormChonNhanVien(JTextField txtData)
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
		String columnName[] = {"Mã NV","Họ tên","SĐT","Địa chỉ","Trạng thái"};
		for(int i=0; i<columnName.length; i++)
		{
			model.addColumn(columnName[i]);
		}
		ArrayList<NHANVIEN> nv = NHANVIENDAO.getInstance().selectAll();
		for (NHANVIEN nhanvien : nv) {
			model.addRow(new Object[] {nhanvien.getMaNV(),nhanvien.getTenNV(),nhanvien.getSdt(),nhanvien.getDiaChi(),nhanvien.getTrangThai()});
		}
		tbNV.setModel(model);
		JScrollPane pane = new JScrollPane(tbNV);
		
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
		int index = tbNV.getSelectedRow();
		String id = String.valueOf(tbNV.getValueAt(index, 0));
		String tenNV = String.valueOf(tbNV.getValueAt(index, 1 ));
		String result = id + "-" + tenNV;
		txt.setText(result);
		this.dispose();
	}

}
