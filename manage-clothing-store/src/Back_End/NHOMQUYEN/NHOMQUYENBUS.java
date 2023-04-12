/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHOMQUYEN;


import java.util.ArrayList;

/**
 *
 * @author NGOC THUC
 */
public class NHOMQUYENBUS {
    private ArrayList<NHOMQUYEN> dsnq = new ArrayList<>();
    NHOMQUYENDAO nqDAO = new NHOMQUYENDAO();

    public NHOMQUYENBUS() {
        dsnq = nqDAO.selectAll();
    }

    public void showConsole() {
        dsnq.forEach((nq) -> {
            System.out.print(nq.getMaQuyen() + " ");
            System.out.print(nq.getTenQuyen() + " ");
            System.out.println(nq.getMoTaQuyen() + " ");
        });
    }

    public String[] getTitle() {
        return new String[]{"Mã Quyền", "Tên Quyền", "Mô Tả Quyền"};
    }

    public String getNextID() {
        return "NQ" + String.valueOf(this.dsnq.size() + 1);
    }

    public ArrayList<NHOMQUYEN> search(String value, String type) {
        ArrayList<NHOMQUYEN> result = new ArrayList<>();

        dsnq.forEach((nq) -> {
            if (type.equals("Tất cả")) {
                if (nq.getMaQuyen().toLowerCase().contains(value.toLowerCase())
                        || nq.getTenQuyen().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(nq.getMoTaQuyen()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(nq);
                }
            } else {
                switch (type) {
                    case "Mã Quyền":
                        if (nq.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                    case "Tên Quyền":
                        if (nq.getTenQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                    case "Mô Tả Quyền":
                        if (String.valueOf(nq.getMoTaQuyen()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(nq);
                        }
                        break;
                }
            }
        });
        return result;
    }

    public boolean add(String maQuyen, String tenQuyen, String moTaQuyen, String trangThai) {
        NHOMQUYEN accouunt = new NHOMQUYEN(maQuyen, tenQuyen, moTaQuyen, trangThai);
        int add = nqDAO.insert(accouunt);
        if (add == 1) {
            dsnq.add(accouunt);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String maQuyen) {
        for (NHOMQUYEN role : dsnq) {
            if (role.getMaQuyen()== maQuyen) {
                int delete = nqDAO.delete(role);
                if (delete == 1) {
                    dsnq.remove(role); // đang phân vân có nên xóa khỏi giao diện không ? 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean update(String maQuyen, String tenQuyen, String moTaQuyen, String trangThai) {
        NHOMQUYEN role = new NHOMQUYEN(maQuyen, tenQuyen, moTaQuyen, trangThai);
        int update = nqDAO.update(role);
        if (update == 1) {
            dsnq.forEach((nq) -> {
                if (nq.getMaQuyen().equals(maQuyen)) {
                    nq.setTenQuyen(tenQuyen);
                    nq.setMoTaQuyen(moTaQuyen);
                    nq.setTrangThai(trangThai);
                }
            });
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<NHOMQUYEN> getDsnq() {
        return dsnq;
    }
}