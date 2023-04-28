/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KHUYENMAI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NGOC THUC
 */
public class KHUYENMAIBUS {

    private ArrayList<KHUYENMAI> dskm = new ArrayList<>();
    KhuyenMaiDao kmDAO = new KhuyenMaiDao();

    public KHUYENMAIBUS() {
        dskm = kmDAO.selectAll();
    }

    public void showConsole() {
        dskm.forEach((km) -> {
            System.out.print(km.getMaKM() + " ");
            System.out.print(km.getTenKM() + " ");
            System.out.println(km.getDieuKien() + " ");
            System.out.println(km.getPhanTramGiamGia() + " ");
            System.out.println(km.getNgayBD() + " ");
            System.out.println(km.getNgayKT() + " ");
            System.out.println(km.getTrangThai() + " ");
        });
    }

    public String[] getTitle() {
        return new String[]{"Số thứ tự","Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện khuyến mãi", "Phần trăm khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc"};
    }

    public String getNextID() {
        return "KM" + String.valueOf(this.dskm.size() + 1);
    }

    public ArrayList<KHUYENMAI> search(String value, String type, int dk1, int dk2, float phantram1, float phantram2, LocalDate ngay1, LocalDate ngay2) {
        ArrayList<KHUYENMAI> result = new ArrayList<>();

        dskm.forEach((km) -> {
            if (type.equals("Tất cả")) {
                if (km.getMaKM().toLowerCase().contains(value.toLowerCase())
                        || km.getTenKM().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getDieuKien()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getPhanTramGiamGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getNgayBD()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(km.getNgayKT()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(km);
                }
            } else {
                switch (type) {
                    case "Mã khuyến mãi":
                        if (km.getMaKM().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Tên khuyến mãi":
                        if (km.getTenKM().toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Điều kiện khuyến mãi":
                        if (String.valueOf(km.getDieuKien()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Phần trăm khuyến mãi":
                        if (String.valueOf(km.getPhanTramGiamGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Ngày bắt đầu":
                        if (String.valueOf(km.getNgayBD()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                    case "Ngày kết thúc":
                        if (String.valueOf(km.getNgayKT()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(km);
                        }
                        break;
                }
            }
        });

//        for (int i = result.size() - 1; i >= 0; i--) {
//            KHUYENMAI km = result.get(i);
//            double dkkm = km.getDieuKien();
//            double phantram = km.getPhanTramGiamGia();
//            LocalDate ngaybd = km.getNgayBD();
//            LocalDate ngaykt = km.getNgayKT();
//
//            Boolean dkKhongThoa = (dk1 != -1 && dkkm < dk1) || (dk2 != -1 && dkkm > dk2);
//            Boolean phantramKhongThoa = (phantram1 != -1 && phantram < phantram1) || (phantram2 != -1 && phantram > phantram2);
//            Boolean ngayBDKhongThoa = (ngay1 != null && ngaybd.isBefore(ngay1)) || (ngay2 != null && ngaybd.isAfter(ngay2));
//            Boolean ngayKTKhongThoa = (ngay1 != null && ngaykt.isBefore(ngay1)) || (ngay2 != null && ngaykt.isAfter(ngay2));
//
//            if (dkKhongThoa || phantramKhongThoa || (ngayBDKhongThoa && ngayKTKhongThoa)) {
//                result.remove(i);
//            }
//        }
        return result;
    }

    public boolean add(String maKM, String tenKM, double dieuKien, double phanTram, LocalDate ngayBD, LocalDate ngayKT, String tinhTrang) {
        KHUYENMAI voucher = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phanTram, tinhTrang);
        int add = kmDAO.insert(voucher);
        if (add == 1) {
            dskm.add(voucher);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String maKM) {
        for (KHUYENMAI voucher : dskm) {
            if (voucher.getMaKM() == maKM) {
                int delete = kmDAO.delete(voucher);
                if (delete == 1) {
                    dskm.remove(voucher); // đang phân vân có nên xóa khỏi giao diện không ? 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean update(String maKM, String tenKM, double dieuKien, double phanTram, LocalDate ngayBD, LocalDate ngayKT, String tinhTrang) {
        KHUYENMAI voucher = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phanTram, tinhTrang);
        int update = kmDAO.update(voucher);
        if (update == 1) {
            dskm.forEach((km) -> {
                if (km.getMaKM().equals(maKM)) {
                    km.setTenKM(tenKM);
                    km.setDieuKien(dieuKien);
                    km.setPhanTramGiamGia(phanTram);
                    km.setNgayBD(ngayBD);
                    km.setNgayKT(ngayKT);
                    km.setTrangThai(tinhTrang);
                }
            });
            return true;
        } else {
            return false;
        }
    }
    
     public ArrayList<KHUYENMAI> getDskm() {
        return dskm;
    }

}
