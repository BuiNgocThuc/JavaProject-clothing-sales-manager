/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CHUCNANG;

import java.util.ArrayList;

/**
 *
 * @author NGOC THUC
 */
public class CHUCNANGBUS {

    private ArrayList<CHUCNANG> dscn = new ArrayList<>();
    CHUCNANGDAO cnDAO = new CHUCNANGDAO();

    public CHUCNANGBUS() {
        dscn = cnDAO.selectAll();
    }

    public void showConsole() {
        dscn.forEach((nq) -> {
            System.out.print(nq.getMaCN() + " ");
            System.out.print(nq.getTenCN() + " ");
            System.out.println(nq.getMoTa() + " ");
        });
    }

    public String[] getTitle() {
        return new String[]{"Mã Chức Năng", "Tên Chức Năng", "Mô Tả "};
    }

    public String getNextID() {
        return "CN" + String.valueOf(this.dscn.size() + 1);
    }

    public ArrayList<CHUCNANG> search(String value, String type) {
        ArrayList<CHUCNANG> result = new ArrayList<>();

        dscn.forEach((nq) -> {
            if (type.equals("Tất cả")) {
                if (nq.getMaCN().toLowerCase().contains(value.toLowerCase())
                        || nq.getTenCN().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(nq.getMoTa()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(nq);
                }
            } else {
                switch (type) {
                    case "Mã Quyền":
                        if (nq.getMaCN().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                    case "Tên Quyền":
                        if (nq.getTenCN().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                    case "Mô Tả Quyền":
                        if (String.valueOf(nq.getMoTa()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                }
            }
        });
        return result;
    }
    
    public boolean add(String maCN, String tenCN, String moTa) {
        CHUCNANG permission = new CHUCNANG(maCN , tenCN, moTa);
        int add = cnDAO.insert(permission);
        if (add == 1) {
            dscn.add(permission);
            return true;
        } else {
            return false;
        }
    }
    
     public boolean delete(String maCN) {
        for (CHUCNANG permission : dscn) {
            if (permission.getMaCN()== maCN) {
                int delete = cnDAO.delete(permission);
                if (delete == 1) {
                    dscn.remove(permission); // đang phân vân có nên xóa khỏi giao diện không ? 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
     
     public boolean update(String maCN, String tenCN, String moTa) {
        CHUCNANG permission = new CHUCNANG(maCN, tenCN, moTa);
        int update = cnDAO.update(permission);
        if (update == 1) {
            dscn.forEach((cn) -> {
                if (cn.getMaCN().equals(maCN)) {
                    cn.setTenCN(tenCN);
                    cn.setMoTa(moTa);
                }
            });
            return true;
        } else {
            return false;
        }
    }
     
     public ArrayList<CHUCNANG> getDscn() {
        return dscn;
    }
}
