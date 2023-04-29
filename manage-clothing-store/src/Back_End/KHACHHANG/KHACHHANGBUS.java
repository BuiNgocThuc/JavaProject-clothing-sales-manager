package Back_End.KHACHHANG;

import java.util.ArrayList;
import Front_End.KHACHHANG.KhachHangTest;
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
        model = (DefaultTableModel) KhachHangTest.tb.getModel();
        dskh = KHACHHANGDAO.getInstance().selectAll();
        model.setRowCount(0);
        dskh.forEach((kh) -> {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getTrangThai()});
        });
    }

    public void reset() {
        KhachHangTest.textMaKH.setText("");
        KhachHangTest.textHoTen.setText("");
        KhachHangTest.textPhone.setText("");
        KhachHangTest.textAddress.setText("");
        KhachHangTest.textStatus.setText("");
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
