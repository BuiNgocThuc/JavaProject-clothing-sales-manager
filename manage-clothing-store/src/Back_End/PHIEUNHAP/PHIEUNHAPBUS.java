package Back_End.PHIEUNHAP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import Back_End.PHIEUNHAP.PHIEUNHAPDAO;
import Front_End.HOADON.HOADONGUI;
import Front_End.PHIEUNHAP.PHIEUNHAPGUI;
import Import_Export.IOExcel;
/**
 *
 * @author NGOC THUC
 */
public class PHIEUNHAPBUS {
	public static ArrayList<PHIEUNHAP> arrPN = new ArrayList<>();
	
	Locale locale = new Locale("en", "EN");
	String pattern = "###,###.# VNĐ";
	DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	
	public void uploadData() {
		DefaultTableModel dtm = (DefaultTableModel) PHIEUNHAPGUI.tbl.getModel();
		arrPN = PHIEUNHAPDAO.getInstance().selectAll();
		
		dcf.applyPattern(pattern);
		dtm.setRowCount(0);
		for (PHIEUNHAP phieunhap : arrPN) {
			dtm.addRow(new Object[] {phieunhap.getMaPN(), PHIEUNHAPDAO.getInstance().selectTenNCC(phieunhap.getMaNCC()), PHIEUNHAPDAO.getInstance().selectTenNV(phieunhap.getMaNV()), phieunhap.getNgayNhap(), dcf.format(phieunhap.getTongTien())});
		}
	}

        public void insertDaTa(PHIEUNHAP t)
	{
		int ketQua = PHIEUNHAPDAO.getInstance().insert(t);
	}
	
	public String autoID()
	{
		String id = new String();
		if(arrPN.isEmpty())
		{
			arrPN = PHIEUNHAPDAO.getInstance().selectAll();
			if (arrPN.isEmpty()) {
				id = "PN001";
				return id;
			}
		}
		String end = String.valueOf(arrPN.get(arrPN.size()-1).getMaPN());
		char tmp[] = new char[10];
		end.getChars(2, end.length(), tmp, 0);
                int str = 0;
		
		String chuoi = String.valueOf(tmp[0]);
		String chuoi1 = String.valueOf(tmp[1]);
		String chuoi2 = String.valueOf(tmp[2]);
		String strEnd = chuoi + chuoi1 + chuoi2;
		str = Integer.parseInt(strEnd);
		
		if (str + 1 <10) {
			id = "PN00" + String.valueOf(str+1);
		}
		else if(str+1<100)
		{
			id = "PN0" + String.valueOf(str+1);
		}
		else if (str+1<1000) {
			id = "PN" + String.valueOf(str+1);
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
				ArrayList<PHIEUNHAP> arrTimKiem = new ArrayList<>();
				DefaultTableModel dtm = (DefaultTableModel) PHIEUNHAPGUI.tbl.getModel();
				String text;
				text = txt.getText().toLowerCase();
				
				for (PHIEUNHAP phieunhap : arrPN) {
					if((phieunhap.getMaPN()).toLowerCase().contains(text) || (PHIEUNHAPDAO.getInstance().selectTenNCC(phieunhap.getMaNCC())).toLowerCase().contains(text) || (PHIEUNHAPDAO.getInstance().selectTenNV(phieunhap.getMaNV())).toLowerCase().contains(text)) {
						arrTimKiem.add(phieunhap);
					}
				}

				dcf.applyPattern(pattern);
				dtm.setRowCount(0);
				for (PHIEUNHAP phieunhap : arrTimKiem) {
					dtm.addRow(new Object[] {phieunhap.getMaPN(), PHIEUNHAPDAO.getInstance().selectTenNCC(phieunhap.getMaNCC()), PHIEUNHAPDAO.getInstance().selectTenNV(phieunhap.getMaNV()), phieunhap.getNgayNhap(), dcf.format(phieunhap.getTongTien())});
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {				
			}
		});
		
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				ArrayList<PHIEUNHAP> arrTimKiem = new ArrayList<>();
				DefaultTableModel dtm = (DefaultTableModel) PHIEUNHAPGUI.tbl.getModel();
				if(e.getItem() == "Dưới 1.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() <= 1000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else if(e.getItem() == "1.000.000 - 5.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() >= 1000000 && phieunhap.getTongTien() <= 5000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else if(e.getItem() == "5.000.000 - 10.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() >= 5000000 && phieunhap.getTongTien() <= 10000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else if(e.getItem() == "10.000.000 - 15.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() >= 10000000 && phieunhap.getTongTien() <= 15000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else if(e.getItem() == "15.000.000 - 20.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() >= 15000000 && phieunhap.getTongTien() <= 20000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else if(e.getItem() == "Trên 20.000.000") {
					for (PHIEUNHAP phieunhap : arrPN) {
						if(phieunhap.getTongTien() >= 20000000) {
							arrTimKiem.add(phieunhap);
						}
					}
				}else {
					arrTimKiem = arrPN;
				}
				dcf.applyPattern(pattern);
				dtm.setRowCount(0);
				for (PHIEUNHAP phieunhap : arrTimKiem) {
					dtm.addRow(new Object[] {phieunhap.getMaPN(), PHIEUNHAPDAO.getInstance().selectTenNCC(phieunhap.getMaNCC()), PHIEUNHAPDAO.getInstance().selectTenNV(phieunhap.getMaNV()), phieunhap.getNgayNhap(), dcf.format(phieunhap.getTongTien())});
				}
			}
		});
		
		dc.getDateEditor().getUiComponent().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dc.getDate() == null) {
				}else {
					DefaultTableModel dtm = (DefaultTableModel) PHIEUNHAPGUI.tbl.getModel();

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dc.getDate());
					
					dcf.applyPattern(pattern);
					dtm.setRowCount(0);
					for (PHIEUNHAP phieunhap : arrPN) {
						if(date.equals(phieunhap.getNgayNhap())) {
							dtm.addRow(new Object[] {phieunhap.getMaPN(), PHIEUNHAPDAO.getInstance().selectTenNCC(phieunhap.getMaNCC()), PHIEUNHAPDAO.getInstance().selectTenNV(phieunhap.getMaNV()), phieunhap.getNgayNhap(), dcf.format(phieunhap.getTongTien())});
						}
					}
				}
			}
		});
	}
	
	public void xuatEx(JButton btn1) {
    	btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IOExcel.writeExcel(PHIEUNHAPGUI.tbl, "Danh sách phiếu nhập", "DSPN");
			}
		});
	}
}
