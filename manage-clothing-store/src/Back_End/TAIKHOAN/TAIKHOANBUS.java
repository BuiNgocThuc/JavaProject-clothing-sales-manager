/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.TAIKHOAN;

import Back_End.CTPhanQuyen.CTPhanQuyen;
import Back_End.CTPhanQuyen.CTPhanQuyenBUS;
import Back_End.NHANVIEN.NHANVIENBUS;
import Front_End.BANHANG.BANHANGGUI;
import Front_End.FrameLayout.LayoutFrame;
import Front_End.LoginForm.LoginForm;
import Front_End.LoginForm.LoginFormtest;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author NGOC THUC
 */
public class TAIKHOANBUS {

    public static ArrayList<TAIKHOAN> dstk = new ArrayList<>();
    TAIKHOANDAO tkDAO = new TAIKHOANDAO();
    public static String tenTK;

    public TAIKHOANBUS() {
        dstk = tkDAO.selectAll();
    }

    public void insertDTO(ArrayList<ArrayList<Object>> data) {
        ArrayList<TAIKHOAN> listKM = new ArrayList<>();
        for (ArrayList<Object> voucher : data) {
            String username = voucher.get(1).toString();
            String password = voucher.get(2) + "";
            String maQuyen = voucher.get(3) + "";

            String trangthai = "ĐANG HOẠT ĐỘNG";
            TAIKHOAN kmDTO = new TAIKHOAN(username, password, maQuyen, trangthai);
            listKM.add(kmDTO);
        }
        tkDAO.insertArray(listKM);
    }

    public static TAIKHOAN curentLogin = new TAIKHOANBUS().getByUsername("3121410482");

    public static void login(LoginForm lg) {
        tenTK = lg.getUsername().getText();
        String matkhau = lg.getPassword().getText();
        TAIKHOANBUS qltk = new TAIKHOANBUS();
        curentLogin = qltk.getByUsername(tenTK);
        if (curentLogin != null) {
            String trangThai = qltk.getTrangThai(tenTK);
            if (trangThai == "ngừng hoạt động") {
                JOptionPane.showMessageDialog(null, "Tài khoản bị vô hiệu hóa ");
                return;
            }
            if (curentLogin.getPassWord().equals(matkhau)) {
                ArrayList<String> dsq = new CTPhanQuyenBUS().getListCTQByNQuyen(curentLogin.getMaQuyen());
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {

                }
                LayoutFrame lf = new LayoutFrame();
                String name = qltk.getNameByUsername(tenTK);
                qltk.phanQuyen(dsq, lf);
                qltk.currentUser(name, lf);

                lg.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập");
        }
    }

    public void phanQuyen(ArrayList<String> dsq, LayoutFrame lf) {
        lf.getLblBanHang().setVisible(false);
        lf.getLblNhapHang().setVisible(false);
        lf.getLblSanPham().setVisible(false);
        lf.getLblThuongHieu().setVisible(false);
        lf.getLblHoaDon().setVisible(false);
        lf.getLblPhieuNhap().setVisible(false);
        lf.getLblNhanVien().setVisible(false);
        lf.getLblKhachHang().setVisible(false);
        lf.getLblNhaCungCap().setVisible(false);
        lf.getLblThongKe().setVisible(false);
        lf.getLblKhuyenMai().setVisible(false);
        lf.getLblTaiKhoan().setVisible(false);
        lf.getLblPhanQuyen().setVisible(false);

        for (String q : dsq) {
            switch (q) {
                case "1" ->
                    lf.getLblBanHang().setVisible(true);
                case "2" ->
                    lf.getLblNhapHang().setVisible(true);
                case "3" ->
                    lf.getLblSanPham().setVisible(true);
                case "4" ->
                    lf.getLblThuongHieu().setVisible(true);
                case "5" ->
                    lf.getLblHoaDon().setVisible(true);
                case "6" ->
                    lf.getLblPhieuNhap().setVisible(true);
                case "7" ->
                    lf.getLblNhanVien().setVisible(true);
                case "8" ->
                    lf.getLblKhachHang().setVisible(true);
                case "9" ->
                    lf.getLblNhaCungCap().setVisible(true);
                case "10" ->
                    lf.getLblThongKe().setVisible(true);
                case "11" ->
                    lf.getLblKhuyenMai().setVisible(true);
                case "12" ->
                    lf.getLblTaiKhoan().setVisible(true);
                case "13" ->
                    lf.getLblPhanQuyen().setVisible(true);
            }
        }
    }

    public void currentUser(String name, LayoutFrame lf) {
        lf.getInfoUser().setText("Xin chào, " + name);
    }

    public void getMaNV(String Username) {
    }

    public String getTrangThai(String username) {
        return tkDAO.getTrangThaiByMaTk(username);
    }

    public TAIKHOAN getByUsername(String tentk) {
        return tkDAO.getByUserName(tentk);
    }

    public String getNameByUsername(String Username) {
        return tkDAO.getNameByUsername(Username);
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
        return new String[]{"Số Thứ Tự", "Tên tài khoản", "Mật khẩu", "Mã Quyền"};
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
        TAIKHOAN account = new TAIKHOAN(userName, passWord, maQuyen, trangthai);
        int add = tkDAO.insert(account);
        if (add == 1) {
            dstk.add(account);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String userName) {
        for (TAIKHOAN account : dstk) {
            if (account.getUserName() == userName) {
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
        TAIKHOAN account = new TAIKHOAN(userName, passWord, maQuyen);
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

    public ArrayList<TAIKHOAN> getDstk() {
        dstk = tkDAO.selectAll();
        return dstk;
    }

}
