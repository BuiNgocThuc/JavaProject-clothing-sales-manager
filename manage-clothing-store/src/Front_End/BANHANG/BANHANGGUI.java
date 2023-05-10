/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.BANHANG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Back_End.CTHoaDon.CTHoaDon;
import Back_End.CTHoaDon.CTHoaDonDAO;
import Back_End.HOADON.HOADON;
import Back_End.HOADON.HOADONBUS;
import Back_End.HOADON.HOADONDAO;
import Back_End.SANPHAM.SANPHAMBUS;
import Front_End.SANPHAM.SANPHAMGUI;

/**
 *
 * @author NGOC THUC
 */
public class BANHANGGUI extends JPanel {
	JPanel panelCenter = new JPanel();
	JPanel panelRight = new JPanel();
	JPanel panelHoaDon = new JPanel();
	JPanel panelCTHD = new JPanel();
	JPanel panelTongTien = new JPanel();
	JTable tableHoaDon = new JTable();
	JPanel panelChucNang = new JPanel();
	
	JTable tableSP = new JTable();
	JButton btnAdd = new JButton("Thêm");
	JPanel panelTim = new JPanel();
	JTextField txtTim = new JTextField(20);
	String maKH, maKM;
	
	// Panel hóa đơn
	 DefaultTableModel dModel = new DefaultTableModel();
	JPanel panelMaHD = new JPanel();
	JLabel labelMaHD = new JLabel("",JLabel.CENTER);
	JPanel panelMaNV = new JPanel();
	JLabel labelMaNV = new JLabel("",JLabel.CENTER);
	JPanel panelMaKH = new JPanel();
	JTextField txtMaKH = new JTextField(10);
	JButton btnChonKH = new JButton();
	JPanel panelNgayNhap = new JPanel();
	JLabel labelNgayNhap = new JLabel("",JLabel.CENTER);
	
	JLabel labelTongTien = new JLabel("Tổng tiền: ",JLabel.LEFT);
	JLabel labelTongTienValue = new JLabel("",JLabel.LEFT);
	JLabel labelTienKhach = new JLabel("Tiền khách đưa: ",JLabel.LEFT);
	JLabel TienKhachValue = new JLabel("",JLabel.LEFT);
	JTextField txtTienKhach = new JTextField(10);
	JLabel labelTienTra = new JLabel("Tiền trả lại: ",JLabel.LEFT);
	JLabel labelTienTraValue = new JLabel("",JLabel.LEFT);
	JButton btnKM = new JButton("Khuyến mãi");
	JLabel labelKM = new JLabel("",JLabel.LEFT);
	
	JButton btnXoa = new JButton("Xóa");
	JButton btnHoanThanh = new JButton("Hoàn thành");
	JButton btnLamMoi = new JButton("Làm mới");
	
	SANPHAMGUI spg = new SANPHAMGUI();
	SANPHAMBUS spb = new SANPHAMBUS();
	HOADONBUS hdb = new HOADONBUS();
	
	public BANHANGGUI()
	{
		init();
		spb.loadDataToTable_UseArray(tableSP);
		
	}

	public void init() {
        this.setLayout(new BorderLayout());
        //Panel sản phẩm
        panelCenter.setLayout(new BorderLayout());
        panelCenter.add(spg.createTable(tableSP), BorderLayout.CENTER);
        panelTim.setLayout(new FlowLayout());
        txtTim.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tìm kiếm",TitledBorder.LEADING,TitledBorder.TOP,null,Color.black));
        txtTim.setPreferredSize(new Dimension(150,50));
        panelTim.add(txtTim);
        btnAdd.setBackground(Color.white);
        btnAdd.setBorder(BorderFactory.createLineBorder(Color.black));
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-28.png")));
        panelCenter.add(btnAdd,BorderLayout.SOUTH);
        panelCenter.add(panelTim,BorderLayout.NORTH);
        
        txtTim.addFocusListener(new FocusListener() {	
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTim.getText().equals(""))
				{
					txtTim.setText("Tên hoặc mã sản phẩm");
					txtTim.setForeground(new Color(153,153,153));
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTim.getText().equals("Tên hoặc mã sản phẩm"))
				{
					txtTim.setText("");
					txtTim.setForeground(new Color(153,153,153));
				}
				
			}
		});
        spb.txtTimKiem(txtTim, tableSP);
        this.add(panelCenter,BorderLayout.CENTER);
        
        // Panel hóa đơn
        panelRight.setLayout(new BorderLayout(0,5));
        panelRight.setPreferredSize(new Dimension(400, 600));
        
        panelHoaDon.setLayout(new FlowLayout(10,10,FlowLayout.LEFT));
        panelHoaDon.setPreferredSize(new Dimension(panelRight.getWidth(),150));
        panelHoaDon.setBorder(BorderFactory.createLineBorder(Color.black));
        
        panelMaHD.setBorder(BorderFactory.createTitledBorder(null, "Mã HĐ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelMaHD.setPreferredSize(new Dimension(145, 20));
        labelMaHD.setText(hdb.autoID());
        panelMaHD.add(labelMaHD);
        panelHoaDon.add(panelMaHD);
        
        panelMaNV.setBorder(BorderFactory.createTitledBorder(null, "Mã NV", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelMaNV.setPreferredSize(new Dimension(145, 20));
        labelMaNV.setText("NV001");
        panelMaNV.add(labelMaNV);
        panelHoaDon.add(panelMaNV);
        txtMaKH.setEnabled(false);
        
        panelMaKH.setBorder(BorderFactory.createTitledBorder(null, "Tên KH", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panelMaKH.setPreferredSize(new Dimension(175, 55));
        btnChonKH.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_more_20px.png")));
        btnChonKH.setBackground(Color.white);
        btnChonKH.setPreferredSize(new Dimension(22,22));
        panelMaKH.add(txtMaKH);
        panelMaKH.add(btnChonKH);
        panelHoaDon.add(panelMaKH);
        
        panelNgayNhap.setBorder(BorderFactory.createTitledBorder(null, "Ngày nhập", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        labelNgayNhap.setPreferredSize(new Dimension(145, 20));
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngayNhap = dateFormat.format(date);
        labelNgayNhap.setText(String.valueOf(ngayNhap));
        panelNgayNhap.add(labelNgayNhap);
        panelHoaDon.add(panelNgayNhap);
        panelRight.add(panelHoaDon,BorderLayout.NORTH);
        
        panelCTHD.setLayout(new BorderLayout());
        dModel.addColumn("Mã SP");
        dModel.addColumn("Tên SP");
        dModel.addColumn("Số lượng");
        dModel.addColumn("Đơn giá");
        tableHoaDon.setModel(dModel);
        JScrollPane pane = new JScrollPane(tableHoaDon);
        panelCTHD.add(pane,BorderLayout.CENTER);
        
        panelTongTien.setLayout(null);
        panelTongTien.setPreferredSize(new Dimension(panelRight.getWidth(), 85));
        
        labelTongTien.setBounds(5, 5, 75, 20);
        labelTongTienValue.setBounds(80, 5, 75, 20);
        labelTongTienValue.setText("0");
        panelTongTien.add(labelTongTien);
        panelTongTien.add(labelTongTienValue);
        
        labelTienKhach.setBounds(5, 25, 100, 20);
        TienKhachValue.setBounds(105, 25, 75, 20);
        txtTienKhach.setBounds(105, 25, 75, 20);
        TienKhachValue.setVisible(false);
        txtTienKhach.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(txtTienKhach.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(txtTienKhach, "Chưa nhập tiền khách đưa", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else {
						try {
							Float numFloat = Float.parseFloat(txtTienKhach.getText());
							Float tongTienFloat = Float.parseFloat(labelTongTienValue.getText());
							if(tongTienFloat-numFloat>0)
							{
								JOptionPane.showMessageDialog(txtTienKhach, "Số tiền không đủ", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
							else {
								TienKhachValue.setText(txtTienKhach.getText());
								txtTienKhach.setVisible(false);
								TienKhachValue.setVisible(true);
								labelTienTraValue.setText(String.valueOf(numFloat-tongTienFloat));
								
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(txtMaKH, "Số tiền không hợp lệ(phải là số thực)", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}		
			}
		});
        panelTongTien.add(labelTienKhach);
        panelTongTien.add(TienKhachValue);
        panelTongTien.add(txtTienKhach);
        
        labelTienTra.setBounds(5, 45, 75, 20);
        labelTienTraValue.setBounds(80, 45, 75, 20);
        labelTienTraValue.setText("0");
        panelTongTien.add(labelTienTra);
        panelTongTien.add(labelTienTraValue);
        btnKM.setBackground(Color.white);
        btnKM.setBounds(5, 65, 100, 20);
        labelKM.setBounds(110, 65, 170, 20);
        panelTongTien.add(btnKM);
        panelTongTien.add(labelKM);
        btnKM.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(labelKM.getText().equals(""))
				{
					maKM = hdb.getTenKM2(labelTongTienValue, labelKM);
					if(labelKM.getText().equals(""))
					{
						JOptionPane.showMessageDialog(labelKM, "Không có khuyến mãi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					Float tongTien=0.0f;
					for(int i=0; i<tableHoaDon.getRowCount(); i++)
					{
						tongTien = tongTien + (Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2))) * Float.parseFloat(String.valueOf(tableHoaDon.getValueAt(i, 3))));
					}
					labelTongTienValue.setText(String.valueOf(tongTien));
					maKM = hdb.getTenKM2(labelTongTienValue, labelKM);	
				}
			}
		});
        panelCTHD.add(panelTongTien,BorderLayout.SOUTH);
        
        panelRight.add(panelCTHD,BorderLayout.CENTER);
        
        // panel chức năng
        panelChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelChucNang.setBorder(BorderFactory.createLineBorder(Color.black));
		panelChucNang.setPreferredSize(new Dimension(panelRight.getWidth(),100));
		btnXoa.setBackground(Color.white);
		btnXoa.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-remove-28.png")));
		btnXoa.setPreferredSize(new Dimension(90, 30));
		btnHoanThanh.setBackground(Color.white);
		btnHoanThanh.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-cash-receipt-32.png")));
		btnHoanThanh.setPreferredSize(new Dimension(140,30));
		btnLamMoi.setBackground(Color.white);
		btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
		btnLamMoi.setPreferredSize(new Dimension(140,30));
		
		panelChucNang.add(btnXoa);
		panelChucNang.add(btnHoanThanh);
		panelChucNang.add(btnLamMoi);
		panelRight.add(panelChucNang,BorderLayout.SOUTH);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThemMouseClick();				
			}
		});
        
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoaMouseClick();	
			}
		});
		
		btnChonKH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormChonKH kh = new FormChonKH(txtMaKH);
				maKH = kh.getmaKH();
			}
		});
		
		btnHoanThanh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHoanThanhMouseClick();
			}
		});
		
		btnLamMoi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLamMoiMouseClick();			
			}
		});
        this.add(panelRight,BorderLayout.EAST);
	}
	
	public void btnThemMouseClick()
	{
		int row = -1;
		row = tableSP.getSelectedRow();
		if(row >= 0)
		{
			maKM = "";
			labelKM.setText("");
			Float tongTien = (float) 0;
			for(int i=0; i<tableHoaDon.getRowCount(); i++)
			{
				tongTien = tongTien + (Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2))) * Float.parseFloat(String.valueOf(tableHoaDon.getValueAt(i, 3))));
			}
			labelTongTienValue.setText(String.valueOf(tongTien));
			//
			
			int tmp = 0;
			boolean check = false;
			while(check==false)
			{
				String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng","Thông báo", JOptionPane.PLAIN_MESSAGE);
				if(soLuong!=null)
				{
					int soLuongSP = Integer.parseInt(String.valueOf(tableSP.getValueAt(row, 6)));
					int num;
					try {
						num = Integer.parseInt(soLuong);
						if(num!=0 && num > 0)
						{
							if(soLuongSP-num >= 0)
							{
								String maSP = String.valueOf(tableSP.getValueAt(row, 1));
								String tenSP = String.valueOf(tableSP.getValueAt(row, 3));
								Float donGia = Float.parseFloat(String.valueOf(tableSP.getValueAt(row, 7)));
								if(dModel.getRowCount()==0)
								{
									System.out.println("0");
									tmp = num;
									dModel.addRow(new Object[] {maSP,tenSP,num,donGia});
									labelTongTienValue.setText(String.valueOf(num*donGia));
								}
								else {
									for(int i=0; i<dModel.getRowCount(); i++)
									{
										if(maSP.equals(String.valueOf(tableHoaDon.getValueAt(i, 0))))
										{
											System.out.println("Mã SP =" + maSP);
											System.out.println(String.valueOf(tableHoaDon.getValueAt(i, 0)));
											int numNew = num + Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2)));
											tmp = numNew;
											dModel.removeRow(i);
											dModel.insertRow(i, new Object[] {maSP,tenSP,numNew,donGia});
											Float tongTienFloat = Float.parseFloat(labelTongTienValue.getText());
											Float tongTienNew = tongTienFloat + (numNew-num)*donGia;
											labelTongTienValue.setText(String.valueOf(tongTienNew));
											System.out.println("1");
											break;
										}
										else {
											if(i==dModel.getRowCount()-1)
											{
												tmp = num;
												dModel.addRow(new Object[] {maSP,tenSP,num,donGia});
												Float tongTienFloat = Float.parseFloat(labelTongTienValue.getText());
												Float tongTienNew = tongTienFloat + num*donGia;
												labelTongTienValue.setText(String.valueOf(tongTienNew));
												System.out.println("2");
												break;
											}
										}
									}
									
								}
								check = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Vượt quá số lượng sản phẩm đang có trong cửa hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(this, "Số lượng phải là số dương và khác 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ(Phải là số nguyên)", "Lỗi", JOptionPane.ERROR_MESSAGE);		
					}
				}
				else {
					check = true;
				}
				
		}
		
		System.out.println("row = "+row+" "+"tmp = "+tmp);
		if(tmp!=0) {
		updateSoLuongInTable(row, tmp, 1);
		}
	}
		else {
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
}
	
	public void updateSoLuongInTable(int row, int soLuong, int choose)
	{	
		switch (choose) {
		case 0:
			String maSPHD = String.valueOf(tableHoaDon.getValueAt(row, 0));
			for(int i=0; i<tableSP.getRowCount(); i++)
			{
				if(maSPHD.equals(String.valueOf(tableSP.getValueAt(i, 1))))
				{
					String STT = String.valueOf(tableSP.getValueAt(i, 0));
					String maSP = String.valueOf(tableSP.getValueAt(i, 1));
					String maTH = String.valueOf(tableSP.getValueAt(i, 2));
					String tenSP = String.valueOf(tableSP.getValueAt(i, 3));
					String size = String.valueOf(tableSP.getValueAt(i, 4));
					String mau = String.valueOf(tableSP.getValueAt(i, 5));
					String soLuongStr = String.valueOf(tableSP.getValueAt(i, 6));
					int soLuongNew = 0;
					soLuongNew = Integer.parseInt(soLuongStr) + soLuong;
					String donGia = String.valueOf(tableSP.getValueAt(i, 7));
					DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
					model.removeRow(i);
					model.insertRow(i, new Object[] {STT,maSPHD,maTH,tenSP,size,mau,soLuongNew,donGia});
					break;
				}
			}
			break;
		case 1:
			String STT = String.valueOf(tableSP.getValueAt(row, 0));
			String maSP = String.valueOf(tableSP.getValueAt(row, 1));
			String maTH = String.valueOf(tableSP.getValueAt(row, 2));
			String tenSP = String.valueOf(tableSP.getValueAt(row, 3));
			String size = String.valueOf(tableSP.getValueAt(row, 4));
			String mau = String.valueOf(tableSP.getValueAt(row, 5));
			String soLuongStr = String.valueOf(tableSP.getValueAt(row, 6));
			int soLuongNew = 0;
			String donGia = String.valueOf(tableSP.getValueAt(row, 7));
			soLuongNew = Integer.parseInt(soLuongStr) - soLuong;
			DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
			model.removeRow(row);
			model.insertRow(row, new Object[] {STT,maSP,maTH,tenSP,size,mau,soLuongNew,donGia});
			break;
		default:
			break;
		}		
		
	}
	
	public void btnXoaMouseClick()
	{
		int row = -1;
		row = tableHoaDon.getSelectedRow();
		if(row >= 0)
		{
			maKM = "";
			labelKM.setText("");
			Float tongTien2 = (float) 0;
			for(int i=0; i<tableHoaDon.getRowCount(); i++)
			{
				tongTien2 = tongTien2 + (Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2))) * Float.parseFloat(String.valueOf(tableHoaDon.getValueAt(i, 3))));
			}

			Float tongTien;
			
			int soLuong = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(row, 2)));
			Float tmp = Float.parseFloat(String.valueOf(tableHoaDon.getValueAt(row, 3))) * Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(0, 2)));
			updateSoLuongInTable(row, soLuong, 0);
			dModel.removeRow(row);
			tongTien = tongTien2 - tmp;
			labelTongTienValue.setText(String.valueOf(tongTien));
		}
		else {
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnHoanThanhMouseClick()
	{
		if(checkInput()==true)
		{
			String maHD = labelMaHD.getText();
			String maNV = labelMaNV.getText();
			String arr[] = labelNgayNhap.getText().split("-");
			String ngayNhap = arr[2]+"-"+arr[1]+"-"+arr[0];
			Float TongTien = Float.parseFloat(labelTongTienValue.getText());
			HOADON t = new HOADON(maHD, maNV, maKM, maKH, ngayNhap, TongTien, "Chưa hủy");
			HOADONDAO.getInstance().insert(t);
			
			for(int i=0; i<tableHoaDon.getRowCount(); i++)
			{
				String maSP = String.valueOf(tableHoaDon.getValueAt(i, 0));
				int soLuong = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2)));
				Float donGia = Float.parseFloat(String.valueOf(tableHoaDon.getValueAt(i, 3)));
				CTHoaDon aCtHoaDon = new CTHoaDon(maHD, maSP, donGia, soLuong);
				CTHoaDonDAO.getInstance().insert(aCtHoaDon);
				spb.updateGiaBan_SoLuong1(maSP, soLuong);
			}
			JOptionPane.showMessageDialog(this, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public boolean checkInput()
	{
		if(txtMaKH.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(TienKhachValue.getText().trim().equals("")){
			JOptionPane.showMessageDialog(this, "Chưa nhập tiền khách đưa", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(tableHoaDon.getRowCount()==0)
		{
			JOptionPane.showMessageDialog(this, "Bảng hóa đơn trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void btnLamMoiMouseClick()
	{
		labelMaHD.setText(hdb.autoID());
		txtMaKH.setText("");
		labelTongTienValue.setText("0");
		TienKhachValue.setVisible(false);
		labelTienTraValue.setText("0");
		txtTienKhach.setVisible(true);
		txtTienKhach.setText("");
		labelKM.setText("");
		for(int i=0; i<dModel.getRowCount(); i++)
		{
			dModel.removeRow(i);
		}
		spb.loadDataToTable_UseArray(tableSP);
	}
	
}
