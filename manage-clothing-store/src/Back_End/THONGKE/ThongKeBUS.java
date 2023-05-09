/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.THONGKE;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    Locale locale = new Locale("en", "EN");
    String pattern = "###,###.# VNĐ";
    DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    public void uploadSLB() {
        ArrayList<CTHoaDon> arrTK = new ArrayList<CTHoaDon>();
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
    public void applyDate(JDateChooser Date_Start, JDateChooser Date_End, JLabel lblApplyDate, JLabel lblReset, JComboBox<String> cb_thongKe) {
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
                        DefaultTableModel dtm = (DefaultTableModel) THONGKEGUI.tblList.getModel();

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
                            dcf.applyPattern(pattern);
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

        lblReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                uploadSLB();
                Date_Start.setDate(null);
                Date_End.setDate(null);
//				cb_thongKe.setSelectedIndex(0);
                super.mouseClicked(e);
            }
        });
    }
}
