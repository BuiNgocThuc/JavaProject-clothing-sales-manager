/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.THONGKE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Back_End.CTHoaDon.CTHoaDon;
import Back_End.CTHoaDon.CTHoaDonDAO;
import Back_End.HOADON.HOADON;
import Back_End.HOADON.HOADONDAO;
import Front_End.THONGKE.THONGKEGUI;

/**
 *
 * @author NGOC THUC
 */
public class ThongKeBUS {
	ArrayList<CTHoaDon> arrTK;
	
    Locale locale = new Locale("en", "EN");
    String pattern = "###,###.# VNĐ";
    DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    public void uploadData() {
        arrTK = new ArrayList<CTHoaDon>();
        ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectAll();
        DefaultTableModel dtm = (DefaultTableModel) THONGKEGUI.tblList.getModel();

        for (CTHoaDon ctHD : arrCTHD) {
            if ((CTHoaDonDAO.getInstance().selectTinhTrang(ctHD.getMaHD())).equals("Chưa hủy")) {
                int dem = 0;
                for (CTHoaDon ctTK : arrTK) {
                    if ((ctHD.getMaSP()).equals(ctTK.getMaSP()) && (ctHD.getDonGia() == ctTK.getDonGia())) {
                        int tmp = ctTK.getSoLuong() + ctHD.getSoLuong();
                        ctTK.setSoLuong(tmp);
                        dem++;
                        break;
                    }
                }
                if (dem == 0) {
                    CTHoaDon tmpCTHD = new CTHoaDon(null, ctHD.getMaSP(), ctHD.getDonGia(), ctHD.getSoLuong());
                    arrTK.add(tmpCTHD);
                }
            }
        }

        dcf.applyPattern(pattern);
        dtm.setRowCount(0);
        for (CTHoaDon ctTK : arrTK) {
            float tongTien = (float) ctTK.getDonGia() * ctTK.getSoLuong();
            dtm.addRow(new Object[]{ctTK.getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(ctTK.getMaSP()), dcf.format(ctTK.getDonGia()), ctTK.getSoLuong(), dcf.format(tongTien)});
        }
    }
    
//	public void uploadSLN() {
//		ArrayList<CTHoaDon> arrTK = new ArrayList<CTHoaDon>();
//		ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectAll();  
//    	DefaultTableModel dtm = (DefaultTableModel) THONGKEGUI.tblList.getModel();
//    	
//    	for (CTHoaDon ctHD : arrCTHD) {
//    		int dem = 0;
//			for(CTHoaDon ctTK : arrTK) {
//				if((ctHD.getMaSP()).equals(ctTK.getMaSP()) && ctHD.getDonGia() == ctTK.getDonGia()) {
//					int tmp = ctTK.getSoLuong() + ctHD.getSoLuong();
//					ctTK.setSoLuong(tmp);
//					dem++;
//					break;
//				}
//			}
//			if(dem == 0) {
//				CTHoaDon tmpCTHD = new CTHoaDon(null, ctHD.getMaSP(), ctHD.getDonGia(), ctHD.getSoLuong());
//				arrTK.add(tmpCTHD);
//			}
//		}
//    	
//		dcf.applyPattern(pattern);
//    	dtm.setRowCount(0);
//    	for (CTHoaDon ctTK : arrTK) {
//    		float tongTien = (float) ctTK.getDonGia() * ctTK.getSoLuong();
//			dtm.addRow(new Object[] {ctTK.getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(ctTK.getMaSP()), dcf.format(ctTK.getDonGia()), ctTK.getSoLuong(), dcf.format(tongTien)});
//		}
//	}
    public void allEvent(JDateChooser Date_Start, JDateChooser Date_End, JLabel lblApplyDate, JLabel lblReset, JComboBox<String> cb_thongKe, JTextField txtTopSP) {
    	DefaultTableModel dtm = (DefaultTableModel) THONGKEGUI.tblList.getModel();
    	
        lblApplyDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String dateT = sdf.format(Date_Start.getDate());
                    String dateE = sdf.format(Date_End.getDate());
                    String[] dateStrT = dateT.split("-");
                    String[] dateStrE = dateE.split("-");
                    Integer[] dateStart = new Integer[3];
                    Integer[] dateEnd = new Integer[3];
                    for (int i = 0; i < 3; i++) {
                        dateStart[i] = Integer.valueOf(dateStrT[i]);
                        dateEnd[i] = Integer.valueOf(dateStrE[i]);
                    }
                    if ((dateStart[0] > dateEnd[0] && dateStart[1] >= dateEnd[1] && dateStart[2] >= dateEnd[2]) || (dateStart[1] > dateEnd[1] && dateStart[2] >= dateEnd[2]) || (dateStart[2] > dateEnd[2])) {
                        JOptionPane.showMessageDialog(THONGKEGUI.tblList, "Ngày không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        ArrayList<CTHoaDon> arrTK = new ArrayList<CTHoaDon>();
                        ArrayList<HOADON> arrHD = HOADONDAO.getInstance().selectAll();

                        for (HOADON hoadon : arrHD) {
                            String[] dateStr = hoadon.getNgayNhap().split("-");
                            Integer[] date = {Integer.valueOf(dateStr[2]), Integer.valueOf(dateStr[1]), Integer.valueOf(dateStr[0])};
                            if (!((date[0] > dateEnd[0] && date[1] >= dateEnd[1] && date[2] >= dateEnd[2]) || (date[1] > dateEnd[1] && date[2] >= dateEnd[2]) || (date[2] > dateEnd[2])) && !((dateStart[0] > date[0] && dateStart[1] >= date[1] && dateStart[2] >= date[2]) || (dateStart[1] > date[1] && dateStart[2] >= date[2]) || (dateStart[2] > date[2])) && (hoadon.getTinhTrang().equals("Chưa hủy"))) {
                                String condition = "CTHD_MAHD = '" + hoadon.getMaHD() + "'";
                                ArrayList<CTHoaDon> arrCTHD = CTHoaDonDAO.getInstance().selectByCondition(condition);
                                for (CTHoaDon ctHD : arrCTHD) {
                                    int dem = 0;
                                    for (CTHoaDon ctTK : arrTK) {
                                        if ((ctHD.getMaSP()).equals(ctTK.getMaSP()) && ctHD.getDonGia() == ctTK.getDonGia()) {
                                            int tmp = ctTK.getSoLuong() + ctHD.getSoLuong();
                                            ctTK.setSoLuong(tmp);
                                            dem++;
                                            break;
                                        }
                                    }
                                    if (dem == 0) {
                                        CTHoaDon tmpCTHD = new CTHoaDon(null, ctHD.getMaSP(), ctHD.getDonGia(), ctHD.getSoLuong());
                                        arrTK.add(tmpCTHD);
                                    }
                                }
                            }
                            
                            dtm.setRowCount(0);
                            for (CTHoaDon ctTK : arrTK) {
                                float tongTien = (float) ctTK.getDonGia() * ctTK.getSoLuong();
                                dtm.addRow(new Object[]{ctTK.getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(ctTK.getMaSP()), dcf.format(ctTK.getDonGia()), ctTK.getSoLuong(), dcf.format(tongTien)});
                            }
                        }
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(THONGKEGUI.tblList, "Ngày không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                super.mouseClicked(e);
            }
        });
        
        txtTopSP.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					if(txtTopSP.getText().equals("")) {
						uploadData();
					}else {
						Integer n = Integer.valueOf(txtTopSP.getText());

						if(n == 0) {
							JOptionPane.showMessageDialog(THONGKEGUI.tblList, "Vui lòng nhập 1 số nguyên lớn hơn 0.", "Thông báo", JOptionPane.WARNING_MESSAGE);
							txtTopSP.setText(null);
						}else {
							for (int i = 0; i < arrTK.size(); i++) {
								for (int j = i+1; j < arrTK.size(); j++) {
									if(arrTK.get(i).getSoLuong() < arrTK.get(j).getSoLuong()) {
										CTHoaDon tmp = arrTK.get(i);
										arrTK.set(i, arrTK.get(j));
										arrTK.set(j, tmp);
									}
								}
							}
							
							dtm.setRowCount(0);
							if(n > arrTK.size()) {
								n = arrTK.size();
							}
					        for(Integer i = 0; i < n; i++) {
					            float tongTien = (float) arrTK.get(i).getDonGia() * arrTK.get(i).getSoLuong();
					            dtm.addRow(new Object[]{arrTK.get(i).getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(arrTK.get(i).getMaSP()), dcf.format(arrTK.get(i).getDonGia()), arrTK.get(i).getSoLuong(), dcf.format(tongTien)});
					        }
						}
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(THONGKEGUI.tblList, "Vui lòng nhập 1 số nguyên lớn hơn 0.", "Thông báo", JOptionPane.WARNING_MESSAGE);
					txtTopSP.setText(null);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        cb_thongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị được chọn và hiển thị lên JLabel
                String selectedItem = cb_thongKe.getSelectedItem().toString();
                switch(selectedItem) {
                    case "Bán Chạy Nhất":
                    	for (int i = 0; i < arrTK.size(); i++) {
							for (int j = i+1; j < arrTK.size(); j++) {
								if(arrTK.get(i).getSoLuong() < arrTK.get(j).getSoLuong()) {
									CTHoaDon tmp = arrTK.get(i);
									arrTK.set(i, arrTK.get(j));
									arrTK.set(j, tmp);
								}
							}
						}
                    	
                        dtm.setRowCount(0);
                        for (CTHoaDon ctTK : arrTK) {
                            float tongTien = (float) ctTK.getDonGia() * ctTK.getSoLuong();
                            dtm.addRow(new Object[]{ctTK.getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(ctTK.getMaSP()), dcf.format(ctTK.getDonGia()), ctTK.getSoLuong(), dcf.format(tongTien)});
                        }
                        break;
                    case "Doanh Thu Cao Nhất":
                    	for (int i = 0; i < arrTK.size(); i++) {
                    		float tongTieni = (float) arrTK.get(i).getDonGia() * arrTK.get(i).getSoLuong();
							for (int j = i+1; j < arrTK.size(); j++) {
								float tongTienj = (float) arrTK.get(j).getDonGia() * arrTK.get(j).getSoLuong();
								if(tongTieni < tongTienj) {
									CTHoaDon tmp = arrTK.get(i);
									arrTK.set(i, arrTK.get(j));
									arrTK.set(j, tmp);
								}
							}
						}
                    	
                        dtm.setRowCount(0);
                        for (CTHoaDon ctTK : arrTK) {
                            float tongTien = (float) ctTK.getDonGia() * ctTK.getSoLuong();
                            dtm.addRow(new Object[]{ctTK.getMaSP(), CTHoaDonDAO.getInstance().selectTenSP(ctTK.getMaSP()), dcf.format(ctTK.getDonGia()), ctTK.getSoLuong(), dcf.format(tongTien)});
                        }
                        break;
                    case "Sắp Xếp Theo":
                    	uploadData();
                    	break;
                    default:
                    	break;
                }
            }
        });

        lblReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	uploadData();
                Date_Start.setDate(null);
                Date_End.setDate(null);
                txtTopSP.setText(null);
				cb_thongKe.setSelectedIndex(0);
                super.mouseClicked(e);
            }
        });
    }
}
