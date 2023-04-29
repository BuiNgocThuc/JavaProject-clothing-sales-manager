package Back_End.NHACUNGCAP;

import Front_End.NHACUNGCAP.NhaCungCapTest;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class NHACUNGCAPBUS {

    public static ArrayList<NHACUNGCAP> dsncc = new ArrayList<>();
    private NHACUNGCAPDAO nccDao = new NHACUNGCAPDAO();
    public static DefaultTableModel model = new DefaultTableModel();

    public void loadData() {
        model = (DefaultTableModel) NhaCungCapTest.tb.getModel();
        dsncc = NHACUNGCAPDAO.getInstance().selectAll();
        model.setRowCount(0);
        dsncc.forEach((ncc) -> {
            model.addRow(new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(), ncc.getDiaChi(), ncc.getTrangThai()});
        });
    }

    public void reset() {
        NhaCungCapTest.textMaNCC.setText("");
        NhaCungCapTest.textTenNCC.setText("");
        NhaCungCapTest.textPhone.setText("");
        NhaCungCapTest.textAddress.setText("");
        NhaCungCapTest.textStatus.setText("");
    }

    public void showConsole() {
        dsncc.forEach((ncc) -> {
            System.out.print(ncc.getMaNCC() + " ");
            System.out.println(ncc.getTenNCC() + " ");
            System.out.println(ncc.getSdt() + " ");
            System.out.println(ncc.getDiaChi() + " ");
            System.out.println(ncc.getTrangThai());
        });
    }

    public boolean add(String id, String name, String phone, String address, String status) {
        NHACUNGCAP ncc = new NHACUNGCAP(id, name, phone, address, status);
        int check = nccDao.insert(ncc);
        if (check == 1) {
            dsncc.add(ncc);
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(String id, String name, String phone, String address, String status) {
        NHACUNGCAP ncc = new NHACUNGCAP(id, name, phone, address, status);
        int check = nccDao.update(ncc);
        if (check == 1) {
            dsncc.forEach((list) -> {
                if (list.getMaNCC().equals(id)) {
                    list.setTenNCC(name);
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
        NHACUNGCAP ncc = NHACUNGCAPBUS.dsncc.get(index);
        int check = nccDao.delete(ncc);
        if (check == 1) {
            dsncc.remove(ncc);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<NHACUNGCAP> getDsncc() {
        return dsncc;
    }

}
