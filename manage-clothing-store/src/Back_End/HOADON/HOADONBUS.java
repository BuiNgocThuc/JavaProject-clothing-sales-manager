/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.HOADON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.FlatteningPathIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Back_End.CTHoaDon.CTHoaDon;
import Back_End.CTHoaDon.CTHoaDonBUS;
import Back_End.CTHoaDon.CTHoaDonDAO;
import Back_End.KHUYENMAI.KHUYENMAI;
import Back_End.KHUYENMAI.KhuyenMaiDao;
import Back_End.PHIEUNHAP.PHIEUNHAPDAO;
import Back_End.SANPHAM.SANPHAM;
import Back_End.SANPHAM.SANPHAMDAO;
import Front_End.HOADON.HOADONGUI;
/**
 *
 * @author NGOC THUC
 */
public class HOADONBUS {
    public static ArrayList<HOADON> arrHD = new ArrayList<>();
    
    Locale locale = new Locale("en", "EN");
	String pattern = "###,###.# VNĐ";
	DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    
	public void uploadData() {
    	arrHD = HOADONDAO.getInstance().selectAll();
    	DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();
    	
		dcf.applyPattern(pattern);
    	dtm.setRowCount(0);
    	for (HOADON hoadon : arrHD) {
    		if(hoadon.getTinhTrang().equals("Chưa hủy")) {
    			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), dcf.format(hoadon.getTongTien())});
    		}
		}
    }
	
	public String autoID()
	{ 
		String id = new String();
			if(arrHD.isEmpty())
			{
				arrHD = HOADONDAO.getInstance().selectAll();
				if (arrHD.isEmpty()) {
					id = "HD001";
					return id;
				}
			}
			String end = String.valueOf(arrHD.get(arrHD.size()-1).getMaHD());
			char tmp[] = new char[10];
			end.getChars(2, end.length(), tmp, 0);
	                int str = 0;
			
			String chuoi = String.valueOf(tmp[0]);
			String chuoi1 = String.valueOf(tmp[1]);
			String chuoi2 = String.valueOf(tmp[2]);
			String strEnd = chuoi + chuoi1 + chuoi2;
			str = Integer.parseInt(strEnd);
			
			if (str + 1 <10) {
				id = "HD00" + String.valueOf(str+1);
			}
			else if(str+1<100)
			{
				id = "HD0" + String.valueOf(str+1);
			}
			else if (str+1<1000) {
				id = "HD" + String.valueOf(str+1);
			}
		return id;
	}
    
    public void timKiem(JTextField txt, JButton btn, JDateChooser dc, JComboBox<String> cb) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(null);
				cb.setSelectedIndex(0);
				dc.setDate(null);
				uploadData();
			}
		});
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList<HOADON> arrTimKiem = new ArrayList<>();
				DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();
				String text = txt.getText().toLowerCase();
				
				for (HOADON hoadon : arrHD) {
					if((((hoadon.getMaHD()).toLowerCase().contains(text) || (HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH())).toLowerCase().contains(text) || (HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV())).toLowerCase().contains(text))) && (hoadon.getTinhTrang().equals("Chưa hủy"))) {
						arrTimKiem.add(hoadon);
					}
				}

				dcf.applyPattern(pattern);
				dtm.setRowCount(0);
				for (HOADON hoadon : arrTimKiem) {
	    			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), dcf.format(hoadon.getTongTien())});
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {				
			}
		});
		
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				ArrayList<HOADON> arrTimKiem = new ArrayList<>();
		    	DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();
				if(e.getItem() == "Dưới 1.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() <= 1000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else if(e.getItem() == "1.000.000 - 5.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() >= 1000000 && hoadon.getTongTien() <= 5000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else if(e.getItem() == "5.000.000 - 10.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() >= 5000000 && hoadon.getTongTien() <= 10000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else if(e.getItem() == "10.000.000 - 15.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() >= 10000000 && hoadon.getTongTien() <= 15000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else if(e.getItem() == "15.000.000 - 20.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() >= 15000000 && hoadon.getTongTien() <= 20000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else if(e.getItem() == "Trên 20.000.000") {
					for (HOADON hoadon : arrHD) {
						if(hoadon.getTongTien() >= 20000000) {
							arrTimKiem.add(hoadon);
						}
					}
				}else {
					arrTimKiem = arrHD;
				}
				
				dcf.applyPattern(pattern);
				dtm.setRowCount(0);
				for (HOADON hoadon : arrTimKiem) {
	    			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), dcf.format(hoadon.getTongTien())});
				}
			}
		});
		
		dc.getDateEditor().getUiComponent().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dc.getDate() == null) {
				}else {
			    	DefaultTableModel dtm = (DefaultTableModel) HOADONGUI.tbl.getModel();

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dc.getDate());
					
					dcf.applyPattern(pattern);
					dtm.setRowCount(0);
					for (HOADON hoadon : arrHD) {
						if(date.equals(hoadon.getNgayNhap())) {
			    			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), dcf.format(hoadon.getTongTien())});
						}
					}
				}
			}
		});

	}
    
    public void showHDHuy(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				dialog.setLayout(new BorderLayout());
				dialog.setTitle("Danh sách hóa đơn đã hủy");
				dialog.setModal(true);
				dialog.setResizable(false);
				dialog.setSize(new Dimension(700, 750));
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				int w = d.width;
				int h = d.height;
				int x = (w - dialog.getSize().width) / 2;
				int y = (h - dialog.getSize().height) / 2;
				dialog.setLocation(x, y);
																
				JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
				
				JTable tbl1 = new JTable();
				DefaultTableModel dtm = new DefaultTableModel() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				dtm.addColumn("Mã hóa đơn");
				dtm.addColumn("Khách hàng");
				dtm.addColumn("Nhân viên lập hóa đơn");
				dtm.addColumn("Ngày nhập");
				dtm.addColumn("Tổng tiền");
				tbl1.setModel(dtm);
				tbl1.setAutoCreateRowSorter(true);
				tbl1.getTableHeader().setPreferredSize(new Dimension(1000, 40));
				tbl1.getTableHeader().setFont(new Font(null, Font.BOLD, 13));
				tbl1.setRowHeight(30);
				tbl1.getColumnModel().getColumn(0).setPreferredWidth(50);
				tbl1.getColumnModel().getColumn(1).setPreferredWidth(80);
				tbl1.getColumnModel().getColumn(2).setPreferredWidth(100);
				tbl1.getColumnModel().getColumn(3).setPreferredWidth(70);
				tbl1.getColumnModel().getColumn(4).setPreferredWidth(100);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				tbl1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				tbl1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				tbl1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				tbl1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				tbl1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				tbl1.setBorder(BorderFactory.createRaisedBevelBorder());
				
				JScrollPane sp = new JScrollPane(tbl1);
				sp.setBorder(BorderFactory.createRaisedBevelBorder());
				
				dcf.applyPattern(pattern);
				dtm.setRowCount(0);
				for (HOADON hoadon : arrHD) {
		    		if(hoadon.getTinhTrang().equals("Đã hủy")) {
		    			dtm.addRow(new Object[] {hoadon.getMaHD(), HOADONDAO.getInstance().selectTenKH(hoadon.getMaKH()), HOADONDAO.getInstance().selectTenNV(hoadon.getMaNV()), hoadon.getNgayNhap(), dcf.format(hoadon.getTongTien())});
		    		}
				}
				
				JButton btn1 = new JButton("Khôi phục HĐ");
				
				btn1.setPreferredSize(new Dimension(135, 30));
				btn1.setBackground(Color.WHITE);
				btn1.setMargin(new Insets(0, 0, 0, 0));
				btn1.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png")));
				btn1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (tbl1.getSelectedRow() == -1) {
							JOptionPane.showMessageDialog(dialog, "Vui lòng chọn hóa đơn cần khôi phục.", "Thông báo", JOptionPane.WARNING_MESSAGE);
						}else {
							int output = JOptionPane.showConfirmDialog(dialog, "Bạn có chắc chắn muốn khôi phục hóa đơn này?", "Thông báo", JOptionPane.YES_NO_OPTION);
							if(output == JOptionPane.YES_OPTION) {
								String maHD = String.valueOf(tbl1.getValueAt(tbl1.getSelectedRow(), 0));
								for (HOADON hoadon : arrHD) {
									if(hoadon.getMaHD().equals(maHD)) {
										HOADON hd = new HOADON(maHD, hoadon.getMaNV(), hoadon.getMaKM(), hoadon.getMaKH(), hoadon.getNgayNhap(), hoadon.getTongTien(), "Chưa hủy");
										HOADONDAO.getInstance().update(hd);
										hoadon.setTinhTrang("Chưa hủy");
										dtm.removeRow(tbl1.getSelectedRow());
										uploadData();
									}
								}
								
								String condition = "CTHD_MAHD = '" + maHD + "'";
	                            ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectByCondition(condition);
	                            for (CTHoaDon cthd : arrCTHD) {
									SANPHAM sanpham = new SANPHAM(cthd.getMaSP(), null, null, null, null, 0, 0, 0, null, null);
									sanpham = SANPHAMDAO.getInstance().selectById(sanpham);
									sanpham.setSoLuongSP(sanpham.getSoLuongSP() - cthd.getSoLuong());
									SANPHAMDAO.getInstance().update(sanpham);
								}
							}
						}
					}
				});
				
				JButton btn2 = new JButton("Xem chi tiết HĐ");
				btn2.setPreferredSize(new Dimension(135, 30));
				btn2.setBackground(Color.WHITE);
				btn2.setMargin(new Insets(0, 0, 0, 0));
				btn2.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-bill-32.png")));
				CTHoaDonBUS.showCTHDHuy(tbl1, btn2);
				
				pnl2.add(btn1);
				pnl2.add(btn2);
				
				dialog.add(sp, BorderLayout.CENTER);
				dialog.add(pnl2, BorderLayout.SOUTH);
				dialog.setVisible(true);
			}
		});
	}
    
    public static String getTenKM(String maHD) {
    	String ten = "Không";
    	for (HOADON hoadon : arrHD) {
			if(maHD.equals(hoadon.getMaHD())) {
				if(!(HOADONDAO.getInstance().selectTenKM(hoadon.getMaKM()).equals(""))) {
					ten = HOADONDAO.getInstance().selectTenKM(hoadon.getMaKM());
				}
				break;
			}
		}
    	return ten;
	}
    
    public static String getTenKM2(JLabel labelTongTien,JLabel tenKM) {
    	String maKM = "";
    	String ten = new String();
    	ArrayList<KHUYENMAI> aKhuyenmais = KhuyenMaiDao.getInstance().selectAll();
    	Float tongTieFloat = Float.parseFloat(labelTongTien.getText());
    	int km = 0;
    	float dieukien=0, tmp = 0;
    	int i = 0;
    	for (KHUYENMAI khuyenmai : aKhuyenmais) {
			if(khuyenmai.getTrangThai().equals("Đang hoạt động"))
			{
				dieukien = (float) khuyenmai.getDieuKien();
				if(tongTieFloat>dieukien)
				{
					if(i == 0)
					{
						km = (int) khuyenmai.getPhanTramGiamGia();
						ten = khuyenmai.getTenKM();
						maKM = khuyenmai.getMaKM();
						tmp = tongTieFloat-dieukien;
						i++;
					}
					else {
						if(tongTieFloat-dieukien < tmp)
						{
							km = (int) khuyenmai.getPhanTramGiamGia();
							ten = khuyenmai.getTenKM();
							maKM = khuyenmai.getMaKM();
							tmp = tongTieFloat-dieukien;
							i++;
						}
						else {
							i++;
						}
					}
				}
			}
		}
    	if (km!=0) {
			Float tongTien = tongTieFloat - (tongTieFloat*km/100);
			labelTongTien.setText(String.valueOf(tongTien));
			tenKM.setText(ten);
		}
    	return maKM;
	}
}