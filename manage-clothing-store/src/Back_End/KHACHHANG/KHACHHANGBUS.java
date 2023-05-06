package Back_End.KHACHHANG;

import java.util.ArrayList;
import Front_End.KHACHHANG.KHACHHANGGUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class KHACHHANGBUS {

    public static ArrayList<KHACHHANG> dskh = new ArrayList<>();
    private KHACHHANGDAO khDao = new KHACHHANGDAO();
    public static DefaultTableModel model = new DefaultTableModel();

    public void loadData() {
        model = (DefaultTableModel) KHACHHANGGUI.tb.getModel();
        dskh = KHACHHANGDAO.getInstance().selectAll();
        model.setRowCount(0);
        dskh.forEach((kh) -> {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getTrangThai()});
        });
    }
    
    public String autoID()
    {
    	String id = new String();
		if(dskh.isEmpty())
		{
			dskh = KHACHHANGDAO.getInstance().selectAll();
			if (dskh.isEmpty()) {
				id = "KH001";
				return id;
			}
		}
		String end = String.valueOf(dskh.get(dskh.size()-1).getMaKH());
		char tmp[] = new char[10];
		end.getChars(2, end.length(), tmp, 0);
        int str = 0;
		
		String chuoi = String.valueOf(tmp[0]);
		String chuoi1 = String.valueOf(tmp[1]);
		String chuoi2 = String.valueOf(tmp[2]);
		String strEnd = chuoi + chuoi1 + chuoi2;
		str = Integer.parseInt(strEnd);
		
		if (str + 1 <10) {
			id = "KH00" + String.valueOf(str+1);
		}
		else if(str+1<100)
		{
			id = "KH0" + String.valueOf(str+1);
		}
		else if (str+1<1000) {
			id = "KH" + String.valueOf(str+1);
		}
    	return id;
    }

    public void reset() {
        KHACHHANGGUI.textMaKH.setText("");
        KHACHHANGGUI.textHoTen.setText("");
        KHACHHANGGUI.textPhone.setText("");
        KHACHHANGGUI.textAddress.setText("");
        KHACHHANGGUI.textStatus.setText("");
    }

    public void showConsole() {
        dskh.forEach((kh) -> {
            System.out.print(kh.getMaKH() + " ");
            System.out.println(kh.getTenKH() + " ");
            System.out.println(kh.getSdt() + " ");
            System.out.println(kh.getDiaChi() + " ");
            System.out.println(kh.getTrangThai());
        });
    }

    public boolean add(String id, String name, String phone, String address, String status) {
        KHACHHANG kh = new KHACHHANG(id, name, phone, address, status);
        int check = khDao.insert(kh);
        if (check == 1) {
            dskh.add(kh);
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(String id, String name, String phone, String address, String status) {
        KHACHHANG kh = new KHACHHANG(id, name, phone, address, status);
        int check = khDao.update(kh);
        if (check == 1) {
            dskh.forEach((list) -> {
                if (list.getMaKH().equals(id)) {
                    list.setTenKH(name);
                    list.setSdt(phone);
                    list.setDiaChi(address);
                    list.setTrangThai(status);
                }
            });
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int index) {
        KHACHHANG kh = KHACHHANGBUS.dskh.get(index);
        int check = khDao.delete(kh);
        if (check == 1) {
            dskh.remove(kh);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<KHACHHANG> getDskh() {
        return dskh;
    }

}
