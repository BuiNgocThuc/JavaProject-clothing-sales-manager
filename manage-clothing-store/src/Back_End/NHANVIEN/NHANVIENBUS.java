package Back_End.NHANVIEN;

import java.util.ArrayList;
import Front_End.NHANVIEN.NHANVIENGUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class NHANVIENBUS {
    public static ArrayList<NHANVIEN> dsnv = new ArrayList<>();
    private NHANVIENDAO nvDao = new NHANVIENDAO();
    public static DefaultTableModel model = new DefaultTableModel();
    
    public void loadData() {
        model = (DefaultTableModel) NHANVIENGUI.tb.getModel();
        dsnv = NHANVIENDAO.getInstance().selectAll();
        model.setRowCount(0);
        dsnv.forEach((nv) -> {
            model.addRow(new Object[]{nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getSdt(), nv.getDiaChi(), nv.getTrangThai()});
        });
    }

    public void reset() {
        NHANVIENGUI.textNhanVien.setText("");
        NHANVIENGUI.textHoTen.setText("");
        NHANVIENGUI.textDate.setText("");
        NHANVIENGUI.textPhone.setText("");
        NHANVIENGUI.textAddress.setText("");
        NHANVIENGUI.textStatus.setText("");
    }
    
    public void showConsole() {
        dsnv.forEach((nv) -> {
            System.out.print(nv.getMaNV() + " ");
            System.out.println(nv.getTenNV() + " ");
            System.out.println(nv.getNgaySinh() + " ");
            System.out.println(nv.getSdt() + " ");
            System.out.println(nv.getDiaChi() + " ");
            System.out.println(nv.getTrangThai());
        });
    }
    
    public boolean add(String id,String name,String date,String phone,String address,String status){
        NHANVIEN nv = new NHANVIEN(id, name, date, phone, address, status);
        int check = nvDao.insert(nv);
        if (check == 1){
            dsnv.add(nv);
            return true;
        }
        else {
            return false;
        }
    }
    
     public boolean edit(String id,String name,String date,String phone,String address,String status){
        NHANVIEN nv = new NHANVIEN(id, name, date, phone, address, status);
        int check = nvDao.update(nv);
        if (check == 1){
            dsnv.forEach((list)-> {
                if (list.getMaNV().equals(id)){
                    list.setTenNV(name);
                    list.setNgaySinh(date);
                    list.setSdt(phone);
                    list.setDiaChi(address);
                    list.setTrangThai(status);
                }
            });
            return true;
        }
        else {
            return false;
        }
    }
     
    public boolean delete(int index){
        NHANVIEN nv = NHANVIENBUS.dsnv.get(index);
        int check = nvDao.delete(nv);
        if (check == 1){
            dsnv.remove(nv);
            return true;
        }
        else {
            return false;
        }
    }
    
    public ArrayList<NHANVIEN> getDsnv() {
        return dsnv;
    }
  
}
