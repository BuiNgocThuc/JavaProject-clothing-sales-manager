package Front_End.BANHANG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Back_End.KHACHHANG.KHACHHANG;
import Back_End.KHACHHANG.KHACHHANGBUS;
import Back_End.KHACHHANG.KHACHHANGDAO;

public class FormChonKH extends JFrame{
	private String maKH;
	ArrayList<KHACHHANG> arrKH = new ArrayList<>();
	JPanel panelMenu = new JPanel();
	JButton btnDSKH = new JButton("Danh sách khách hàng");
	JButton btnTTKH = new JButton("Thông tin khách hàng");
	
	JTable tableNV = new JTable();
	JPanel panelTable = new  JPanel();
	JPanel panelTim1 = new JPanel();
	JTextField txtTim1 = new JTextField(10);
	
	JPanel panelButton = new JPanel();
	JPanel panelButton1 = new JPanel();
	JButton btnChon = new JButton("Chọn");
	JButton btnHuy = new JButton("Hủy");
	
	JButton btnChon1 = new JButton("Chọn");
	JButton btnHuy1 = new JButton("Hủy");
	JPanel panelTTKH = new JPanel();
	JPanel panelmaKH = new JPanel();
	JLabel labelmaKH = new JLabel();
	JPanel panelTenKH = new JPanel();
	JTextField txtTenKH = new JTextField(10);
	JPanel panelSDT = new JPanel();
	JTextField txtSDT = new JTextField(10);
	JPanel panelDiaChi = new JPanel();
	JTextField txtDiaChi = new JTextField(10);
	 
	KHACHHANGBUS khb = new KHACHHANGBUS();
	public FormChonKH(JTextField txtData)
	{
		init(txtData);
	}
	
	public String getmaKH()
	{
		return maKH;
	}
	
	public void init(JTextField txtData)
	{
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setTitle("Thông tin khách hàng");
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelMenu.setLayout(new FlowLayout(0,0,FlowLayout.LEFT));
		btnDSKH.setBackground(Color.LIGHT_GRAY);
		btnTTKH.setBackground(Color.white);
		panelMenu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		panelMenu.add(btnDSKH);
		panelMenu.add(btnTTKH);
		this.add(panelMenu,BorderLayout.NORTH);
		
		panelTable.setLayout(new BorderLayout());
		panelTim1.setLayout(new FlowLayout());
		txtTim1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tìm kiếm",TitledBorder.LEADING,TitledBorder.TOP,null,Color.black));
        txtTim1.setPreferredSize(new Dimension(200,40));
        txtTim1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}			
			@Override
			public void keyReleased(KeyEvent e) {
				txtTim();	
			}		
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
        
        panelTim1.add(txtTim1);
        panelTable.add(panelTim1,BorderLayout.NORTH);
        
        DefaultTableModel dModel = new DefaultTableModel();
        dModel.addColumn("Mã KH");
        dModel.addColumn("Họ tên");
        dModel.addColumn("SĐT");
        dModel.addColumn("Địa chỉ");
        arrKH = KHACHHANGDAO.getInstance().selectAll();
        for (KHACHHANG khachhang : arrKH) {
			dModel.addRow(new Object[] {khachhang.getMaKH(),khachhang.getTenKH(),khachhang.getSdt(),khachhang.getDiaChi()});
		}
        tableNV.setModel(dModel);
        JScrollPane pane = new JScrollPane(tableNV);
        panelTable.add(pane,BorderLayout.CENTER);
        this.add(panelTable,BorderLayout.CENTER);
        
        // panel Thông tin khách hàng
        Border border = BorderFactory.createLineBorder(Color.black);
        panelTTKH.setLayout(new FlowLayout(10,10,FlowLayout.LEFT));
        panelmaKH.setBorder(BorderFactory.createTitledBorder(border, "Mã KH", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelmaKH.setPreferredSize(new Dimension(100,20));
        labelmaKH.setText(khb.autoID());
        panelmaKH.add(labelmaKH);
        panelTenKH.setBorder(BorderFactory.createTitledBorder(border, "Tên KH", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelTenKH.add(txtTenKH);
        panelSDT.setBorder(BorderFactory.createTitledBorder(border, "SĐT", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelSDT.add(txtSDT);
        panelDiaChi.setBorder(BorderFactory.createTitledBorder(border, "Địa chỉ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelDiaChi.add(txtDiaChi);
        panelTTKH.add(panelmaKH);
        panelTTKH.add(panelTenKH);
        panelTTKH.add(panelSDT);
        panelTTKH.add(panelDiaChi);
        panelTTKH.setVisible(false);
        
        panelButton1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btnHuy1.setBorder(BorderFactory.createLineBorder(Color.black));
		btnHuy1.setBackground(Color.white);
		btnHuy1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
		
		btnChon1.setBorder(BorderFactory.createLineBorder(Color.black));
		btnChon1.setBackground(Color.white);
		btnChon1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
		panelButton1.add(btnHuy1);
		panelButton1.add(btnChon1);
		panelButton1.setVisible(false);
        
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
		this.add(panelButton,BorderLayout.SOUTH);
		
		btnTTKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDSKH.setBackground(Color.white);
				btnTTKH.setBackground(Color.LIGHT_GRAY);
				panelTable.setVisible(false);
				panelButton.setVisible(false);
                panelButton1.setVisible(true);
				panelTTKH.setVisible(true);
				btnTTKH();
			}
		});
		
		btnDSKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(panelTTKH.isDisplayable())
				{
					btnTTKH.setBackground(Color.white);
					btnDSKH.setBackground(Color.LIGHT_GRAY);
					panelTTKH.setVisible(false);
					panelButton1.setVisible(false);
					panelTable.setVisible(true);
					panelButton.setVisible(true);
				}
			}
		});
		
		btnHuy1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHUY();
			}
		});
		
		btnChon1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOK1(txtData);
			}
		});
		this.add(panelButton,BorderLayout.SOUTH);

		this.setVisible(true);
	}
	
	private void btnHUY()
	{
		this.dispose();
	}
	
	private void btnOK(JTextField txt)
	{
			int index = tableNV.getSelectedRow();
			String id = String.valueOf(tableNV.getValueAt(index, 0));
			String tenNV = String.valueOf(tableNV.getValueAt(index, 1 ));
			txt.setText(tenNV);
			maKH = id;
			this.dispose();
	}
	
	private void btnOK1(JTextField txt)
	{
		if (checkInput()==true) {
			maKH = labelmaKH.getText();
			txt.setText(txtTenKH.getText());
			KHACHHANG aKhachhang = new KHACHHANG(labelmaKH.getText(), txtTenKH.getText(), txtSDT.getText(), txtDiaChi.getText(), "Khách hàng");
			KHACHHANGDAO.getInstance().insert(aKhachhang);
		}
	}
	
	private void btnTTKH()
	{
		 this.add(panelTTKH,BorderLayout.CENTER);
		 this.add(panelButton1,BorderLayout.SOUTH);

	}
	
	public void txtTim()
	{
		String sdtString = txtTim1.getText();
		if(sdtString.trim().equals("")==false)
		{
			DefaultTableModel model = (DefaultTableModel) tableNV.getModel();
			model.setRowCount(0);
			for (KHACHHANG khachhang : arrKH) {
				if(sdtString.equals(khachhang.getSdt()))
				{
					model.addRow(new Object[] {khachhang.getMaKH(),khachhang.getTenKH(),khachhang.getSdt(),khachhang.getDiaChi()});
				}
			}
			tableNV.setModel(model);
		}
		else {
			DefaultTableModel model = (DefaultTableModel) tableNV.getModel();
			model.setRowCount(0);
			for (KHACHHANG khachhang : arrKH) {
					model.addRow(new Object[] {khachhang.getMaKH(),khachhang.getTenKH(),khachhang.getSdt(),khachhang.getDiaChi()});
			}
			tableNV.setModel(model);
		}
			
	}
	
	public boolean checkInput()
	{
		if(txtTenKH.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(txtSDT.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(txtDiaChi.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			try {
				int num = Integer.parseInt(txtSDT.getText());
				if(txtSDT.getText().length()!=10)
				{
					JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ (Tối đa 10 số)", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ (Phải là số )", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
}
