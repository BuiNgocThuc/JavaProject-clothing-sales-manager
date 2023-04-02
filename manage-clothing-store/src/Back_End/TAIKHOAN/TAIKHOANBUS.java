/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.TAIKHOAN;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author NGOC THUC
 */
public class TAIKHOANBUS {

    private ArrayList<TAIKHOAN> dstk = new ArrayList<>();
    TAIKHOANDAO tkDAO = new TAIKHOANDAO();

    public TAIKHOANBUS() {
        dstk = tkDAO.selectAll();
    }

    public void showConsole() {
        dstk.forEach((km) -> {
            System.out.print(km.getUserName() + " ");
            System.out.print(km.getPassWord() + " ");
            System.out.println(km.getMaQuyen() + " ");
            System.out.println(km.getTrangthai() + " ");
        });
    }

    public String[] getTitle() {
        return new String[]{"Tên tài khoản", "Mật khẩu", "Mã Quyền", "Trạng thái"};
    }

    public String getNextID() {
        return "NV" + String.valueOf(this.dstk.size() + 1);
    }

    public ArrayList<TAIKHOAN> search(String value, String type) {
        ArrayList<TAIKHOAN> result = new ArrayList<>();

        dstk.forEach((km) -> {
            if (type.equals("Tất cả")) {
                if (km.getUserName().toLowerCase().contains(value.toLowerCase())
                        || km.getPassWord().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getMaQuyen()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(km);
                }
            } else {
                switch (type) {
                    case "Tên tài khoản":
                        if (km.getUserName().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Mật khẩu":
                        if (km.getPassWord().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Mã quyền":
                        if (String.valueOf(km.getMaQuyen()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Trạng thái":
                        if (String.valueOf(km.getTrangthai()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                }
            }
        });
        return result;
    }

    public boolean add(String userName, String passWord, String maQuyen, String trangthai) {
        TAIKHOAN accouunt = new TAIKHOAN(userName, passWord, maQuyen, trangthai);
        int add = tkDAO.insert(accouunt);
        if (add == 1) {
            dstk.add(accouunt);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String userName) {
        for (TAIKHOAN account : dstk) {
            if (account.getUserName()== userName) {
                int delete = tkDAO.delete(account);
                if (delete == 1) {
                    dstk.remove(account); // đang phân vân có nên xóa khỏi giao diện không ? 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean update(String userName, String passWord, String maQuyen, String trangthai) {
        TAIKHOAN account = new TAIKHOAN(userName, passWord, maQuyen, trangthai);
        int update = tkDAO.update(account);
        if (update == 1) {
            dstk.forEach((km) -> {
                if (km.getUserName().equals(userName)) {
                    km.setPassWord(passWord);
                    km.setMaQuyen(maQuyen);
                    km.setTrangthai(trangthai);
                }
            });
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<TAIKHOAN> getDskm() {
        return dstk;
    }

}
